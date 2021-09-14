package ru.vsu.computergraphics.levin;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public class Figure {
    private final Shape figure;
    private final Color fillColor;
    private final Color outlineColor;

    public Figure(Shape figure, Color fillColor, Color outlineColor) {
        this.figure = figure;
        this.fillColor = fillColor;
        this.outlineColor = outlineColor;
    }

    public void drawFigure(Graphics2D g2d) {
        Color g2dColor = g2d.getColor();
        g2d.setColor(fillColor);
        g2d.fill(this.figure);
        g2d.setColor(outlineColor);
        g2d.draw(this.figure);
        g2d.setColor(g2dColor);
    }
}
