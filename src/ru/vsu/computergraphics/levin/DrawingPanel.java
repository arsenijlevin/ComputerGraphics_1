package ru.vsu.computergraphics.levin;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingPanel extends JFrame implements ActionListener {
  private final int BACKGROUND_WIDTH = 800;
  private final int BACKGROUND_HEIGHT = 800;
  private final int TIMER_DELAY = 1000;
  private final Timer timer = new Timer(TIMER_DELAY, this);
  private int ticksFromStart = 0;

  public DrawingPanel() {
    setTitle("Drawing Panel");
    setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    timer.start();
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;

    this.setBackground(Color.BLACK);

    g2d.setColor(Color.BLACK);
    g2d.fillRect(
        ticksFromStart, BACKGROUND_HEIGHT / 2, BACKGROUND_WIDTH / 10, BACKGROUND_WIDTH / 10);
    g2d.setColor(Color.GREEN);
    g2d.fillOval(
        ticksFromStart, BACKGROUND_HEIGHT / 2, BACKGROUND_HEIGHT / 10, BACKGROUND_WIDTH / 10);


  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == timer) {
      repaint();
      ++ticksFromStart;
    }
  }
}
