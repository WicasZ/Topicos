package Calculadora;
import java.awt.*;
import java.awt.event.*;
public class Calculadora extends Frame implements ActionListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Panel panel_sup;
    private Panel panel_cen;
    private Panel panel_inf;
    private TextArea txt;
    private Button btn_clean;
    private Button btn_sumar;
    private Button btn_restar;
    private Button btn_mult;
    private Button btn_dividir;

    public Calculadora(){
        iniComponent();
    }

    private void iniComponent() {
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        panel_sup = new Panel();
        panel_cen = new Panel();
        panel_inf = new Panel();
        
        panel_sup.setLayout(new BorderLayout());
        txt = new TextArea();
        btn_clean = new Button("Limpiar");
        btn_sumar = new Button("+");
        btn_restar = new Button("-");
        btn_mult = new Button("*");
        btn_dividir = new Button("/");
        


        this.setSize(300,500);
        this.setVisible(true);
        this.setTitle("Calculadora");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    public static void main(String[] args) {
        Calculadora micalculadora = new Calculadora();
    }
    
}