package Topicos.Ejercicio7;
import java.awt.*;
public class NewContenedor extends Canvas{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int x,y;
    private int w,h;
    private int l,a;
    private boolean isClicked;

    public NewContenedor(){
        this.l = 50;
        this.a = 20;
        this.y = 100;
        this.x = 100;
        this.isClicked = false;
    }
    public void paint(Graphics g){
        g.fillRect(x, y, l, a);
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public boolean isClicked() {
        return isClicked;
    }
    public void setClicked() {
        this.isClicked = !this.isClicked;
    }
    public int getL() {
        return l;
    }
    public int getA() {
        return a;
    }
    public void setA(int a) {
        this.a = a;
    }
    public void setL(int l) {
        this.l = l;
    }
}
