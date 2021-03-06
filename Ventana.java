import java.awt.*;
import java.awt.event.*;
public class Ventana extends Frame{
    private static final long serialVersionUID = 1L;

    public Ventana(){
        this.setSize(300,200);
        this.setVisible(true);
        this.setTitle("Ventana ejemplo");
    }
    public static void main(String[] args) {
        Ventana windows = new Ventana();
        windows.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){
            System.exit(0);
        }});
    }
}