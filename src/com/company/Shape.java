package com.company;
import java.awt.*;
//abstract class for shapes

public abstract class Shape {
    protected int x, y;
    private boolean selected;
    public Shape(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public abstract boolean contains(int x, int y);
    public void move(int dx, int dy){
        x += dx;
        y += dy;
    }
    public abstract void draw(Graphics g);
}
