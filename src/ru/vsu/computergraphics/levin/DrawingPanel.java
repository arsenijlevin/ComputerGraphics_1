package ru.vsu.computergraphics.levin;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingPanel extends JPanel implements ActionListener {
  private final int TIMER_DELAY = 1;
  private final int OVAL_COUNT = 9;
  private final int SPEED = 10;
  private final int OVAL_SIZE = 75;

  private final Timer timer = new Timer(TIMER_DELAY, this);
  private final int backgroundWidth;
  private final int backgroundHeight;
  private int xCord = 0;
  private int delta;

  public DrawingPanel(int panelWidth, int panelHeight) {
    this.backgroundWidth = panelWidth;
    this.backgroundHeight = panelHeight;
    this.delta = SPEED;
    setSize(panelWidth, panelHeight);
    setVisible(true);
    timer.start();
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;

    super.paintComponent(g);

    this.setBackground(Color.GRAY);

    drawOvals(OVAL_COUNT, OVAL_SIZE, g2d);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == timer) {
      repaint();
    }
  }

  private void drawOvals(int count, int size, Graphics2D g2d) {
    if (xCord + delta < 0) {
      delta = SPEED;
    } else if (xCord + delta > getWidth() - OVAL_SIZE) {
      delta = -SPEED;
    }
    xCord = xCord + delta;

    int gapBetweenOvals = backgroundHeight / count - 5;

    for (int i = 0; i < count; i++) {
      int newXOval = (i % 2 == 1) ? this.xCord : -this.xCord + getWidth() - size;
      Oval oval =
              new Oval(
                      newXOval, gapBetweenOvals * i, size, size, Color.ORANGE, Color.ORANGE);
      oval.draw(g2d);
    }
  }
}
