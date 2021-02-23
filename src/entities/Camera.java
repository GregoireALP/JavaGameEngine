package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	
	private Vector3f position;
	private float pitch = 10;
	private float yaw ;
	private float roll;

	private final float MOVE_SPEED = 0.5F;
	
	public Camera(int x, int y, int z){
		position = new Vector3f(x,y,z);
	}
	
	public void move(){
		if(Keyboard.isKeyDown(Keyboard.KEY_Z)){
			position.z-=MOVE_SPEED;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			position.z+=MOVE_SPEED;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			position.x+=MOVE_SPEED;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)){
			position.x-=MOVE_SPEED;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			position.y+=MOVE_SPEED;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			position.y-=MOVE_SPEED;
		}
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}

}
