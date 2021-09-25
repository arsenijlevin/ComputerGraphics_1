package ru.vsu.computergraphics.levin;

import javax.swing.JFrame;

public class Main {

  public static void initializeGUI(int windowWidth, int windowHeight) {

    JFrame frame = new JFrame("Computer Graphics. Task 1");
    frame.setSize(windowWidth, windowHeight);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.add(new DrawingPanel(windowWidth, windowHeight));

    frame.setVisible(true);
  }

  public static void main(String[] args) {
    final int WINDOW_WIDTH = 1000;
    final int WINDOW_HEIGHT = 1000;

    javax.swing.SwingUtilities.invokeLater(() -> initializeGUI(WINDOW_WIDTH, WINDOW_HEIGHT));
  }
}