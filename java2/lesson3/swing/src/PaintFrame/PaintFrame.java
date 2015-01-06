package PaintFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class PaintFrame extends JFrame {
    List<ColorLine> lines = new ArrayList<>();
    Point lastPoint;
    JPanel pane = new DrawPane();
    Color color = Color.RED;

    public PaintFrame() {
        super("Paint Frame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());
        add(pane, BorderLayout.CENTER);
        add(new ButtonPanel(), BorderLayout.NORTH);

        DrawListener listener = new DrawListener();
        pane.addMouseListener(listener);
        pane.addMouseMotionListener(listener);
    }


    // class to handle mouse action from DrawPane
    private class DrawListener extends MouseAdapter {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (lastPoint == null) {
                    lastPoint = e.getPoint();
                    return;
                }
                ColorLine line = new ColorLine(new Line2D.Float(lastPoint, e.getPoint()), color);
                lines.add(line);
                lastPoint = e.getPoint();

                pane.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                lastPoint = null;
            }
    }

    class DrawPane extends JPanel{
        public void paintComponent(Graphics g){
            // delete line below :)
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (ColorLine line : lines) {
                g2d.setColor(line.color);
                g2d.draw(line.line);
            }
        }
    }

    class ButtonPanel extends JPanel implements ActionListener {
        JButton btnRed;
        JButton btnBlue;
        JButton btnGreen;
        JButton btnKey;

        private static final String RED_BTN = "red";
        private static final String BLUE_BTN = "blue";
        private static final String GREEN_BTN = "green";
        private static final String BLACK_BTN = "black";

        private void addGeneratedButton(JButton button, String name, Color color) {
            button = new JButton(name);
            button.setBackground(color);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setActionCommand(name);
            button.addActionListener(this);
            add(button);
        }

        public ButtonPanel(){
            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            addGeneratedButton(btnRed, RED_BTN, Color.red);
            addGeneratedButton(btnBlue, BLUE_BTN, Color.blue);
            addGeneratedButton(btnGreen, GREEN_BTN, Color.green);
            addGeneratedButton(btnKey, BLACK_BTN, Color.black);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case RED_BTN:
                    color = Color.RED;
                    break;
                case BLUE_BTN:
                    color = Color.BLUE;
                    break;
                case GREEN_BTN:
                    color = Color.GREEN;
                    break;
                case BLACK_BTN:
                    color = Color.BLACK;
                    System.out.println(lines);
                    break;
            }
        }
    }

    public static class ColorLine {
        Line2D.Float line;
        Color color;

        public ColorLine(){}

        public ColorLine(Line2D.Float line, Color color) {
            this.line = line;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        javax.swing.JFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}
