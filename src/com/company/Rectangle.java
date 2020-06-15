package com.company;
import java.awt.*;

public class Rectangle extends Shape {
    private int width, height;
    public Rectangle(int x, int y, int width, int height){
        super(x, y);
        this.width = width;
        this.height = height;
    }
    public boolean contains(int x, int y){
        return x >= getX() && x < getX()  + width && y >= getY() && y < getY() + height;
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(getX(), getY(), width, height);
        if(isSelected()){
            Color temp = g.getColor();
            g.drawRect(getX(), getY(), width, height);
            g.setColor(Color.red);
            g.setColor(temp);
        }
    }

    @Override
    public String toString(){
        String t = "Rectangle: " + getX() + ", " + getY() + ", " + width+ ", " + height;
        return t;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
