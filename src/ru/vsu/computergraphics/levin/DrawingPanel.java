package ru.vsu.computergraphics.levin;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    g2d.setColor(Color.BLACK);
    g2d.drawOval(ticksFromStart, backgroundHeight / 2, backgroundWidth / 10, backgroundHeight / 10);
    g2d.setColor(Color.GREEN);
    g2d.fillOval(ticksFromStart, backgroundHeight / 2, backgroundWidth / 10, backgroundHeight / 10);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == timer) {
      repaint();
      ++ticksFromStart;
    }
  }
}
