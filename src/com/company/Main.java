package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//the program allows to create shapes, move them, delete them, and see their properties

public class Main extends JFrame {
    ArrayList<Shape> shapes = new ArrayList<>();
    private JPanel buttons;
    private JButton rec, cir;
    Shape selected = null;
    int prevMouseX, prevMouseY;
    boolean dragged = false;

    public Main() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Graphics Editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        Canvas canvas = new Canvas();

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON3) {
                    Shape selectedShape = null;
                    for(Shape shape : shapes){
                        if(shape.contains(e.getX(),e.getY())){
                            selectedShape = shape;
                        }
                    }
                    if (selected != null) {
                        JOptionPane.showMessageDialog(null, selected.toString());
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (selected != null) {
                    selected.setSelected(false);
                    selected = null;
                }
                Shape selectedShape = null;
                for (Shape shape : shapes) {
                    if (shape.contains(e.getX(), e.getY())) {
                        selectedShape = shape;
                    }
                }
                if (selectedShape != null) {
                    selected = selectedShape;
                    selected.setSelected(true);

                    prevMouseX = e.getX();
                    prevMouseY = e.getY();
                    dragged = true;
                }
                repaint();

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragged = false;
            }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(dragged){
                    selected.move(e.getX() - prevMouseX, e.getY() - prevMouseY );
                    prevMouseY = e.getY();
                    prevMouseX = e.getX();
                    repaint();
                }

            }
        });
        canvas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    if (selected != null) {
                        shapes.remove(selected);
                        selected = null;
                        repaint();
                    }
                }
            }
        });

        buttons = new JPanel();
        rec = new JButton("Rectangle");
        cir = new JButton("Circle");
        buttons.setLayout(new GridLayout(1, 3));
        buttons.add(cir);
        buttons.add(rec);

        rec.addActionListener(e -> {
            int x = (int) (Math.random() * getWidth());
            int y = (int) (Math.random() * getHeight());
            int width = (int) (Math.random() * 100);
            int height = (int) (Math.random() * 100);
            shapes.add(new Rectangle(x, y, width, height));
            canvas.requestFocus();
            repaint();
        });

        cir.addActionListener(e -> {
            int x = (int) (Math.random() * getWidth());
            int y = (int) (Math.random() * getHeight());
            int radius = (int) (Math.random() * 50);
            shapes.add(new Circle(x, y, radius));
            canvas.requestFocus();
            repaint();
        });

        add(canvas, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
    class Canvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.blue);
            for (Shape shape : shapes) {
                shape.draw(g);
            }
        }
    }
}

