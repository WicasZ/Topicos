package BlocNota;
import java.awt.event.*;
import java.awt.*;
public class Colores extends Frame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private TextArea Colores;
    private Button Red;
    private Button Blue;
    private Button Black;
    private Button Yellow;
    private Button Green;
    private Button Orange;
    private Panel panel_up;
    private Panel panel_cen;
    private Panel panel_dow;

    //contructor, donde resible el texto area de la clase principal
    public Colores(TextArea text){
        this.Colores = text;
        iniColores();

    }

    //public void asignarColor(TextArea area){
      //  this.Colores = area;
    //}

    private void iniColores(){
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        Red = new Button("Rojo");
        Blue = new Button("Azul");
        Black = new Button("Negro");
        Yellow = new Button("Amarillo");
        Green = new Button("Verde");
        Orange = new Button("Anaranjado");
        this.setLayout(new FlowLayout());
        this.add(Black);
        this.add(Red);
        this.add(Blue);
        this.add(Green);
        this.add(Orange);
        this.add(Yellow);
        
        //Añado un accion cada vez que son presionados
        Black.addActionListener(this);
        Red.addActionListener(this);
        Blue.addActionListener(this);
        Green.addActionListener(this);
        Orange.addActionListener(this);
        Yellow.addActionListener(this);

        //Añado tamaño, visibilidad, Titulo, y para que no sean agrandados
        this.setResizable(false);
        this.setSize(250,100);
        this.setVisible(true);
        this.setTitle("Color");
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //se camia los colores
        if(e.getSource() == Red){
            //Metodo para cambia el color de las letras
            Colores.setForeground(Color.red);
            dispose(); //para salir solamente de la vetana colores
        }
        if(e.getSource() == Black){
            Colores.setForeground(Color.black);
            dispose();//para salir solamente de la vetana colores
        }
        if(e.getSource() == Yellow){
            Colores.setForeground(Color.yellow);
            dispose();//para salir solamente de la vetana colores
        }
        if(e.getSource() == Orange){
            Colores.setForeground(Color.orange);
            dispose();//para salir solamente de la vetana colores
        }
        if(e.getSource() == Green){
            Colores.setForeground(Color.green);
            dispose();//para salir solamente de la vetana colores
        }
        if(e.getSource() == Blue){
            Colores.setForeground(Color.blue);
            dispose();//para salir solamente de la vetana colores
        }
        
    }
    public static void main(String[] args) {
        //Colores c = new Colores();
    }
}
