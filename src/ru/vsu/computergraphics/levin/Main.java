package ru.vsu.computergraphics.levin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Main {

  public static void initializeGUI(int windowWidth, int windowHeight) {

    JFrame frame = new JFrame("Computer Graphics. Task 1");
    frame.setSize(windowWidth, windowHeight);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.add(new DrawingPanel(windowWidth, windowHeight));

    frame.setVisible(true);
  }

  public static void main(String[] args) {
    final int WINDOW_WIDTH = 800;
    final int WINDOW_HEIGHT = 800;

    javax.swing.SwingUtilities.invokeLater(() -> initializeGUI(WINDOW_WIDTH, WINDOW_HEIGHT));
  }
}
