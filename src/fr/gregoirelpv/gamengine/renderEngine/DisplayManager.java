package fr.gregoirelpv.gamengine.renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

public class DisplayManager {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FPS_CAP = 120;

    /**
     * Create Displayed Windows
     * @throws LWJGLException
     */
    public static void createDisplay() throws LWJGLException {

        /* Engine Settings */
        ContextAttribs attribs = new ContextAttribs(3, 2);
        attribs.withForwardCompatible(true);
        attribs.withProfileCore(true);

        /* Display Settings */
        Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
        Display.create(new PixelFormat(), attribs);
        Display.setTitle("Java 3D Engine | " + FPS_CAP + "FPS");

        GL11.glViewport(0, 0, WIDTH, HEIGHT);
    }

    /**
     * Update Display on FPS_CAP
     */
    public static void updateDisplay() {

        /* Display Updater */
        Display.sync(FPS_CAP);
        Display.update();
    }

    /**
     * Kill Process
     */
    public static void closeDisplay() {

        Display.destroy();

    }
}
