package com.company;
import java.awt.*;
// two crossed rectangles
public class Cross extends Shape {
    Rectangle hRect;
    Rectangle vRect;

    public Cross(int aX, int aY, int size1, int size2) {
        super(aX, aY);
        hRect = new Rectangle(aX - size1 / 2, aY - size2 / 2, size1, size2);
        vRect = new Rectangle(aX - size2 / 2, aY - size1 / 2, size2, size1);
    }

    @Override
    public boolean contains(int x, int y) {
        return hRect.contains(x,y) || vRect.contains(x,y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        vRect.draw(g);
        hRect.draw(g);

        if(isSelected()){
            Color temp = g.getColor();
            g.setColor(Color.RED);
            g.drawRect(vRect.getX(), vRect.getY(), vRect.getWidth(), vRect.getHeight());
            g.drawRect(hRect.getX(), hRect.getY(), hRect.getWidth(), vRect.getHeight());
            g.setColor(temp);
        }
    }
    @Override
    public String toString(){
        return "("+hRect.toString()+")" + " (" +vRect.toString() + ")";
    }
}
