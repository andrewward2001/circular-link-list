import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by student on 10/25/17.
 */
class Panel extends JPanel {

    private Timer timer;
    private LinkedList<String> linkedList = new LinkedList<>();
    private ArrayList<Circle> circleList = new ArrayList<>();
    private int theta;
    private int smallDiameter = 70;
    private int bigRadius = (getWidth() - smallDiameter) / 2;

    Panel() {
        ArrayList<String> names = new ArrayList<>();
        try {
            names = Main.readFile("res" + File.separator + "names.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        names.forEach(linkedList::addLast);

        theta = 360 / linkedList.size();

        populateCircleList();



        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                linkedList.remove(linkedList.getLast());
                System.out.println("linked size " + linkedList.size());
                System.out.println("circle size " + circleList.size());
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_B){
                    System.out.println("linked size " + linkedList.size());
                    System.out.println("circle size " + circleList.size());
                }
                if(e.getKeyCode() == KeyEvent.VK_C){
                    circleList.forEach(System.out::println);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paint(g2);

        theta = 360 / linkedList.size();

        bigRadius = (getWidth() - smallDiameter) / 2;

        for (int i = 1; i <= linkedList.size(); i++) {
            populateCircleList();
            circleList.get(i - 1).draw(g2);
//            g2.setColor(new Color(0,0,0));
//            g2.fillOval((int)(bigRadius - bigRadius*(Math.cos(Math.toRadians(theta*i)))), (int)(bigRadius - bigRadius*(Math.sin(Math.toRadians(theta*i)))), 70, 70);
//            g2.setColor(new Color(255, 255, 255));
//            g2.drawString(linkedList.get(i-1), (int)(bigRadius - bigRadius*(Math.cos(Math.toRadians(theta*i))))+smallDiameter/2, (int)(bigRadius - bigRadius*(Math.sin(Math.toRadians(theta*i))))+smallDiameter/2);
        }
        repaint();
    }

    private void populateCircleList(){
        circleList.clear();
        for (int i = 1; i <= linkedList.size(); i++)
            circleList.add(new Circle((int) (bigRadius - bigRadius * (Math.cos(Math.toRadians(theta * i)))), (int) (bigRadius - bigRadius * (Math.sin(Math.toRadians(theta * i)))), smallDiameter, linkedList.get(i - 1)));

    }

}
