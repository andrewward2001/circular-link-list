import java.awt.*;

/**
 * Created by student on 10/25/17.
 */
class Circle {
    private int x;
    private int y;
    private String data;
    private int diam;

    public Circle(int x, int y, int diam, String data){
        this.x = x;
        this.y = y;
        this.diam = diam;
        this.data = data;
    }

    public boolean checkClick(int x2, int y2) {
        return Math.abs(x - x2) <= 20 && Math.abs(y - y2) <= 20;
    }

    public String getData() {
        return data;
    }

    void draw(Graphics2D g2){
        g2.setColor(new Color(0,0,0));
        g2.fillOval(x, y, diam, diam);
        g2.setColor(new Color(255, 255, 255));
        g2.drawString(data, x+diam/4, y+diam/2);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", data='" + data + '\'' +
                ", diam=" + diam +
                '}';
    }
}
