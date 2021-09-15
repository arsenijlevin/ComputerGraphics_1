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
  private final int OVAL_COUNT = 8;
  private final int SPEED = 10;
  private final int OVAL_SIZE = 75;

  private final Timer timer = new Timer(TIMER_DELAY, this);
  private final int backgroundWidth;
  private final int backgroundHeight;
  private int x = 0;
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

    if (x + delta < 0) {
      delta = SPEED;
    } else if (x + delta > getWidth() - OVAL_SIZE) {
      delta = -SPEED;
    }
    x = x + delta;

    int gapBetweenOvals = backgroundHeight / OVAL_COUNT - 5;

    for (int i = 0; i < OVAL_COUNT; i++) {
      int x = (i % 2 == 0) ? this.x : -this.x + getWidth() - OVAL_SIZE;
      Oval oval =
          new Oval(
              x, gapBetweenOvals * i, OVAL_SIZE, OVAL_SIZE, Color.ORANGE, Color.ORANGE);
      oval.draw(g2d);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == timer) {
      repaint();
    }
  }
}
