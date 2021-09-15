package ru.vsu.computergraphics.levin;

import java.awt.Color;
import java.awt.Graphics2D;

public class Oval {
  private final Integer width;
  private final Integer height;
  private final Color fillColor;
  private final Color outlineColor;
  private final Integer x;
  private final Integer y;

  public Oval(
      Integer x, Integer y, Integer width, Integer height, Color fillColor, Color outlineColor) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.fillColor = fillColor;
    this.outlineColor = outlineColor;
  }

  public void draw(Graphics2D g2d) {

    Color g2dColor = g2d.getColor();

    g2d.setColor(this.fillColor);
    g2d.fillOval(this.x, this.y, this.width, this.height);
    g2d.setColor(this.outlineColor);
    g2d.drawOval(this.x, this.y, this.width, this.height);
    g2d.setColor(g2dColor);
  }
}