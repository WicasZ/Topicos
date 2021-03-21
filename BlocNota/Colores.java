package Topicos.BlocNota;
import java.awt.event.*;
import java.awt.*;
public class Colores extends Frame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Button Red;
    private Button Blue;
    private Button Black;
    private Button Yellow;
    private Button Green;
    private Button Orange;
    private Panel panel_up;
    private Panel panel_cen;
    private Panel panel_dow;
    public Colores(){
        iniColores();

    }

    private void iniColores(){
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        /*panel_up = new Panel();
        panel_cen = new Panel();
        panel_dow = new Panel();
        panel_up.setLayout(new FlowLayout());
        panel_cen.setLayout(new FlowLayout());
        panel_dow.setLayout(new FlowLayout());*/
        Red = new Button("Rojo");
        Blue = new Button("Azul");
        Black = new Button("Negro");
        Yellow = new Button("Amarillo");
        Green = new Button("Verde");
        Orange = new Button("Anaranjado");
        this.setLayout(new FlowLayout());
        //this.setLayout(new BorderLayout());
        this.add(Black);
        this.add(Red);
        this.add(Blue);
        this.add(Green);
        this.add(Orange);
        this.add(Yellow);
        /*this.add(panel_up, BorderLayout.NORTH);
        this.add(panel_cen, BorderLayout.CENTER);
        this.add(panel_dow, BorderLayout.SOUTH);
        panel_up.add(Black);
        panel_up.add(Red);
        panel_cen.add(Blue);
        panel_cen.add(Green);
        panel_dow.add(Orange);
        panel_dow.add(Yellow);*/
        setResizable(false);
        setSize(200,140);
        setVisible(true);
        setTitle("Color");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    public static void main(String[] args) {
        Colores c = new Colores();
    }
}
