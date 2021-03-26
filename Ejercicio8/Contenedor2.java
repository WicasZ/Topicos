package Ejercicio8;
import java.awt.*;

public class Contenedor2 extends Canvas{

    private int x,y;
    private int w,h;
    private boolean isClicked;
    private String pathImage;
    private Image imagen;
    private Image images[];
    private int t;
    private Image buffer;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Contenedor2(){
        images = new Image[4];
        this.x = 30;
        this.y = 30;
        isClicked = false;
        pathImage = "C:/Users/WillH/Documents/Ejemplo/Topicos/Recursos/fondo.jpg";
        imagen = Toolkit.getDefaultToolkit().getImage(pathImage);
        this.t = 0;
        for(int i=1; i<=4; i++){
        images[i-1] = Toolkit.getDefaultToolkit().getImage("C:/Users/WillH/Documents/Ejemplo/Topicos/Recursos/vuelo"+i+".png");

        }
    }
        public void paint(Graphics g){
            Graphics2D g2d = (Graphics2D)g;
            buffer = createImage(1024,500);
            Graphics mi2d = buffer.getGraphics();
            mi2d.setColor(Color.white);
            mi2d.fillRect(0, 0, 1024, 765);


            //g.setColor(Color.yellow);
            //g.drawRect(x, y, w, h);
            //g.fillOval(x, y, w, h);
            //g.setColor(Color.black);
            //g.fillOval((x+30), (y+30), (int)(w*0.30), (int)(h*0.30));
            mi2d.drawImage(imagen, 0, 0, 1024, 765, this);
            mi2d.drawImage(images[this.t], x, y, this);
            g2d.drawImage(buffer, 0, 0, this);

        }

        public void tick(){
            this.t++;
            if(t>=images.length){
                this.t=0;
            }
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
        public int getW() {
            return w;
        }
        public void setW(int w) {
            this.w = w;
        }
        public int getH() {
            return h;
        }
        public void setH(int h) {
            this.h = h;
        }
        public boolean isClicked() {
            return isClicked;
        }
        public void setClicked() {
            this.isClicked = !this.isClicked;
        }
}
