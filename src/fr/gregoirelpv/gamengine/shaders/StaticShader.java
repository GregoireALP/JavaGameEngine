package fr.gregoirelpv.gamengine.shaders;

import fr.gregoirelpv.gamengine.entities.Camera;
import fr.gregoirelpv.gamengine.utils.Maths;
import org.lwjgl.util.vector.Matrix4f;

public class StaticShader extends ShaderProgram {

    private static final String VERTEX_FILE = "src/fr/gregoirelpv/gamengine/shaders/vertexShader.txt";
    private static final String FRAGMENT_FILE = "src/fr/gregoirelpv/gamengine/shaders/fragmentShader.txt";

    private int loacation_transformationMatrix;
    private int loacation_projectionMatrix;
    private int location_viewMatrix;

    public  StaticShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void getAllUniformLocations() {
        loacation_transformationMatrix = super.getUniformLocation("transformationMatrix");
        loacation_projectionMatrix = super.getUniformLocation("projectionMatrix");
        location_viewMatrix = super.getUniformLocation("viewMatrix");
    }

    public void loadTransformationMatrix(Matrix4f matrix) {
        super.loadMatrix(loacation_transformationMatrix, matrix );
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
        super.bindAttribute(1, "textureCoords");
    }

    public void loadProjectionMatrix(Matrix4f projection) {
        super.loadMatrix(loacation_projectionMatrix, projection);
    }

    public void loadViewMatrix(Camera camera) {
        Matrix4f viewMatrix = Maths.createViewMatrix(camera);
        super.loadMatrix(location_viewMatrix, viewMatrix);
    }
}
