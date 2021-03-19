package Ejercicio5.BlocNota;
import java.awt.*;
import java.awt.event.*;
import java.awt.Frame;

public class VentanaBloc extends Frame implements ActionListener{
  
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public VentanaBloc(){
        iniVentana();

        
    }

    private void iniVentana() {
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        this.setSize(700,700);
        this.setVisible(true);
        this.setTitle("Editor de texto");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    public static void main(String[] args) {
        VentanaBloc bloc = new VentanaBloc();
    }
    
}
