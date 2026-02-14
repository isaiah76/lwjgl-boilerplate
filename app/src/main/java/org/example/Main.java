package org.example;

import org.lwjgl.opengl.GL;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Main {
  private long window;

  public void run() {
    init();
    loop();
    glfwDestroyWindow(window);
    glfwTerminate();
  }

  private void init() {
    if (!glfwInit())
      throw new IllegalStateException("Unable to initialize GLFW");
    window = glfwCreateWindow(800, 600, "LWJGL Window", NULL, NULL);
    glfwMakeContextCurrent(window);
    glfwShowWindow(window);
    GL.createCapabilities();
  }

  private void loop() {
    while (!glfwWindowShouldClose(window)) {
      glClear(GL_COLOR_BUFFER_BIT);
      glfwSwapBuffers(window);
      glfwPollEvents();
    }
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
