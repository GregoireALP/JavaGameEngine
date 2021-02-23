package engineTester;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.RawModel;
import models.TexturedModel;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import terrains.Terrain;
import textures.ModelTexture;
import entities.Camera;
import entities.Entity;
import entities.Light;

public class MainGameLoop {

	public static void main(String[] args) {

		DisplayManager.createDisplay();
		Loader loader = new Loader();


		RawModel model = OBJLoader.loadObjModel("tree", loader);

		TexturedModel staticModel = new TexturedModel(model,new ModelTexture(loader.loadTexture("tree")));

		List<Entity> entities = new ArrayList<Entity>();
		Random random = new Random();
		for(int i=0;i<250;i++){
			entities.add(new Entity(staticModel, new Vector3f(
					((float) (Math.random() * (800 - 0)) + 0),
					0,
					(float) (Math.random() * (800 - 0)) + 0),
					0,0,0,3));
		}

		Light light = new Light(new Vector3f(20000,20000,2000),new Vector3f(1,1,1));

		Terrain terrain = new Terrain(0,0,loader,new ModelTexture(loader.loadTexture("grass")));

		Camera camera = new Camera(400, 50, 400);
		MasterRenderer renderer = new MasterRenderer();

		while(!Display.isCloseRequested()){
			camera.move();

			renderer.processTerrain(terrain);
			for(Entity entity:entities){
				renderer.processEntity(entity);
			}
			renderer.render(light, camera);
			DisplayManager.updateDisplay();
		}

		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
