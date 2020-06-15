package com.company;
import java.awt.*;

public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }
    @Override
    public boolean contains(int x, int y) {
        int dx = getX() - x;
        int dy = getY() - y;
        return dx*dx + dy*dy < radius*radius;
    }
    @Override
    public void draw(Graphics g) {
        g.fillOval(getX()-radius, getY() - radius, radius*2, radius*2);
        if(isSelected()){
            Color temp = g.getColor();
            g.drawOval(getX()-radius, getY() - radius, radius*2, radius*2);
            g.setColor(Color.red);
            g.setColor(temp);
        }

    }
    public String toString(){
        return "Circle: " + getX() + ", " + getY() + ", " + radius;
    }
}
