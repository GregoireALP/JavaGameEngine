package fr.gregoirelpv.gamengine.entities;

import fr.gregoirelpv.gamengine.models.TextureModel;
import org.lwjgl.util.vector.Vector3f;

public class Entity {

    private TextureModel model;
    private Vector3f postition;
    private float rotX, rotY, rotZ;
    private float scale;

    public Entity(TextureModel model, Vector3f postition, float rotX, float rotY, float rotZ, float scale) {
        this.model = model;
        this.postition = postition;
        this.rotX = rotX;
        this.rotY = rotY;
        this.rotZ = rotZ;
        this.scale = scale;
    }

    public void increasePosition(float dx, float dy, float dz) {
        this.postition.x += dx;
        this.postition.y += dy;
        this.postition.z += dz;
    }

    public void increaseRotation(float dx, float dy, float dz) {
        this.rotX += dx;
        this.rotY += dy;
        this.rotZ =+ dz;
    }

    public TextureModel getModel() {
        return model;
    }

    public void setModel(TextureModel model) {
        this.model = model;
    }

    public Vector3f getPostition() {
        return postition;
    }

    public void setPostition(Vector3f postition) {
        this.postition = postition;
    }

    public float getRotX() {
        return rotX;
    }

    public void setRotX(float rotX) {
        this.rotX = rotX;
    }

    public float getRotY() {
        return rotY;
    }

    public void setRotY(float rotY) {
        this.rotY = rotY;
    }

    public float getRotZ() {
        return rotZ;
    }

    public void setRotZ(float rotZ) {
        this.rotZ = rotZ;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
