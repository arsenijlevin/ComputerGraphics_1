package ru.vsu.computergraphics.levin;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class DrawingPanel extends JPanel implements ActionListener {
  private final int TIMER_DELAY = 100;
  private final Timer timer = new Timer(TIMER_DELAY, this);
  private final int backgroundWidth;
  private final int backgroundHeight;
  private int ticksFromStart = 0;

  public DrawingPanel(int panelWidth, int panelHeight) {
    this.backgroundWidth = panelWidth;
    this.backgroundHeight = panelHeight;

    setSize(panelWidth, panelHeight);
    setVisible(true);
    timer.start();
  }

  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;

    super.paintComponent(g);

    this.setBackground(Color.YELLOW);

    Figure circle =
        new Figure(
            new Ellipse2D.Double(
                ticksFromStart,
                backgroundHeight / 2d,
                backgroundWidth / 10d,
                backgroundHeight / 10d),
            Color.BLACK,
            Color.GREEN);

    circle.drawFigure(g2d);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == timer) {
      repaint();
      ++ticksFromStart;
    }
  }
}
