package fr.gregoirelpv.gamengine.test;

import fr.gregoirelpv.gamengine.entities.Camera;
import fr.gregoirelpv.gamengine.entities.Entity;
import fr.gregoirelpv.gamengine.models.TextureModel;
import fr.gregoirelpv.gamengine.renderEngine.DisplayManager;
import fr.gregoirelpv.gamengine.renderEngine.Loader;
import fr.gregoirelpv.gamengine.models.RawModel;
import fr.gregoirelpv.gamengine.renderEngine.Renderer;
import fr.gregoirelpv.gamengine.shaders.StaticShader;
import fr.gregoirelpv.gamengine.textures.ModelTexture;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import java.io.IOException;

public class MainGameLoop {

    public static void main(String[] args) throws LWJGLException, IOException {

        // Create display
        DisplayManager.createDisplay();

        Loader loader = new Loader();
        StaticShader shader = new StaticShader();
        Renderer  renderer = new Renderer(shader);

        float[] vertices = {
                -0.5f,0.5f,0,
                -0.5f,-0.5f,0,
                0.5f,-0.5f,0,
                0.5f,0.5f,0,

                -0.5f,0.5f,1,
                -0.5f,-0.5f,1,
                0.5f,-0.5f,1,
                0.5f,0.5f,1,

                0.5f,0.5f,0,
                0.5f,-0.5f,0,
                0.5f,-0.5f,1,
                0.5f,0.5f,1,

                -0.5f,0.5f,0,
                -0.5f,-0.5f,0,
                -0.5f,-0.5f,1,
                -0.5f,0.5f,1,

                -0.5f,0.5f,1,
                -0.5f,0.5f,0,
                0.5f,0.5f,0,
                0.5f,0.5f,1,

                -0.5f,-0.5f,1,
                -0.5f,-0.5f,0,
                0.5f,-0.5f,0,
                0.5f,-0.5f,1

        };

        int[] indices = {
                0,1,3,
                3,1,2,
                4,5,7,
                7,5,6,
                8,9,11,
                11,9,10,
                12,13,15,
                15,13,14,
                16,17,19,
                19,17,18,
                20,21,23,
                23,21,22
        };

        float[] textureCoords = {

                0,0,
                0,1,
                1,1,
                1,0,
                0,0,
                0,1,
                1,1,
                1,0,
                0,0,
                0,1,
                1,1,
                1,0,
                0,0,
                0,1,
                1,1,
                1,0,
                0,0,
                0,1,
                1,1,
                1,0,
                0,0,
                0,1,
                1,1,
                1,0
        };

        RawModel model = loader.loadToVao(vertices, indices, textureCoords);
        ModelTexture texture = new ModelTexture(loader.loadTexture("image"));
        TextureModel textureModel = new TextureModel(model, texture);

        Entity entity = new Entity(textureModel, new Vector3f(0, 0, -5), 0, 0, 0, 1);

        Camera camera = new Camera();

        /* While display opened */
        while(!Display.isCloseRequested()) {
            entity.increaseRotation(1, 1, 0);
            camera.move();

            renderer.prepare();

            shader.start();
            shader.loadViewMatrix(camera);

            renderer.render(entity, shader);

            shader.stop();

            DisplayManager.updateDisplay();
        }

        // Kill process
        shader.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();

    }

}
