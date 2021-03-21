package Topicos.BlocNota;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;


public class VentanaBloc extends Frame implements ActionListener{
  
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private TextArea txt_IO;
    //private Button btn_Color;
    private Button btn_addComillas;
    //private Button btn_Tamaño;
    private Button btn_Abrir;
    private Button btn_Salir;
    private Button btn_Guardar;
    private Panel panel_superior;
    private Panel panel_central;
    private Panel panel_inferior;
    private Button btn_Clean;
    private TextArea Info;
    private JComboBox Colores;
    private JComboBox Tamaño;
    private JComboBox OpGuardar;
    private int tamañofuente = 11;
    private String [] NomColor= {"-Colores-","Rojo", "Verde", "Azul", "Negro"};
    private String [] tamaños = {"Tamaño", "Aumentar", "Disminuir"};
    private String [] opcion = {"Nuevo", "Ya guardado"};
    String [] nombre = new String [10];
    String [] dato = new String [10];
    
    private int posicion = 1;
    

    public VentanaBloc(){
        iniVentana();
        nombre[0] = "Saludo - Editor de texto";
        dato[0] = "Hola...";

        
    }

    private void iniVentana() {
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        panel_superior = new Panel();
        panel_central = new Panel();
        panel_inferior = new Panel();
        panel_superior.setLayout(new FlowLayout());
        panel_central.setLayout(new BorderLayout());
        panel_inferior.setLayout(new BorderLayout());
        txt_IO = new TextArea();
        Info = new TextArea();
        //btn_Color = new Button("Color");
        Colores = new JComboBox<>(NomColor);
        Tamaño = new JComboBox<>(tamaños);
        //OpGuardar = new JComboBox<>(opcion);
        btn_addComillas = new Button("Entre comillado");
        //btn_Tamaño = new Button("Tama\u00f1o"); //\u00f1=ñ
        btn_Abrir = new Button("Abrir");
        btn_Salir = new Button("Salir");
        btn_Guardar = new Button("Guardar");
        btn_Clean = new Button("Limpiar");
        this.setLayout(new FlowLayout());
        this.setLayout(new BorderLayout());
        //panel_superior.add(btn_Color);
        panel_superior.add(Colores);
        panel_superior.add(btn_addComillas);
        panel_superior.add(Tamaño);
        //panel_superior.add(btn_Tamaño);
        panel_superior.add(btn_Abrir);
        panel_superior.add(btn_Salir);
        panel_superior.add(btn_Guardar);
        //panel_superior.add(OpGuardar);
        panel_central.add(txt_IO);
        panel_inferior.add(Info, BorderLayout.CENTER);
        this.add(panel_superior, BorderLayout.NORTH);
        this.add(panel_central, BorderLayout.CENTER);
        this.add(panel_inferior, BorderLayout.SOUTH);
        //btn_Color.addActionListener(this);
        Colores.addActionListener(this);
        btn_addComillas.addActionListener(this);
        Tamaño.addActionListener(this);
        //btn_Tamaño.addActionListener(this);
        btn_Abrir.addActionListener(this);
        btn_Salir.addActionListener(this);
        btn_Guardar.addActionListener(this);
        //OpGuardar.addActionListener(this);



        

        this.setSize(500,700);
        this.setVisible(true);
        //if(){}
        this.setTitle(" - Editor de texto");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btn_addComillas){
            String todo = txt_IO.getText();
            String texto = txt_IO.getSelectedText();
            txt_IO.setText(todo.replace(texto, "''"+texto+"''"));
            //int ini = txt_IO.getSelectionStart();
            //int fin = txt_IO.getSelectionEnd();
            //texto = "''" + texto + "''";
            //txt_IO.replaceText(texto, ini, fin);
            //txt_IO.setText("''" + texto + "''");
            Info.append("Comollas a\u00f1adido a -" + texto + "-\n");
        }

        /*if(e.getSource() == btn_Tamaño){
            Info.append("Tama\u00f1o cambiado\n");
        }*/

        if(e.getSource() == btn_Abrir){
            String nom = JOptionPane.showInputDialog("Nombre del archivo");
            nom += " - Editor de texto";
            for(int i = 0; i<nombre.length; i++){
                if((nombre[i]).equals(nom)){
                    txt_IO.setText(dato[i]);
                    this.setTitle(nombre[i]);
                }
            }

            Info.append("Abierto.\n");
        }

        if(e.getSource() == btn_Salir){
            Info.append("Salido.\n");
            System.exit(WIDTH);
        }

        /*if(e.getSource() == OpGuardar){
            if(OpGuardar.getSelectedItem().equals("Nuevo")){
            String nom = JOptionPane.showInputDialog("Nombre");
            nombre[posicion] = nom;
            dato[posicion] = txt_IO.getText();
            Info.append("Guardado.\n");
            }
            if(OpGuardar.getSelectedItem().equals("Ya guardado")){
                //boolean buscado = false;
                for(int i = 0; i<nombre.length; i++){
                    if(nombre[i].equals(nom)){
                        nombre[posicion] = nom;
                        dato[posicion] = txt_IO.getText();
                        //buscado = true;
                    }
                }
                //if(!buscado){
                    //JOptionPane.showMessageDialog(null, "No se ha guardado con anterioridad");
                //}
                Info.append("Guardado.\n");
            }

            
        }*/

        if(e.getSource() == btn_Guardar){
            //nt pos = 0;
            boolean guardo = false;
            String nombree = getTitle();
            System.out.println(nombree);
            for(int i = 0; i<nombre.length; i++){
                if(nombree.equals(nombre[i])){
                    nombre[i] = nombree;
                    dato[i] = txt_IO.getText();
                    guardo = true;
                    Info.append("Guardado.\n");
                }
                
            }
            if(!guardo){
                String nom = JOptionPane.showInputDialog("Nombre");
                nombre[posicion] = nom + " - Editor de texto";
                dato[posicion] = txt_IO.getText();
                posicion++;
                //Info.append("Guardado.\n");
            }
            guardo = false;
            
            
        }


        if(e.getSource() == Colores){
            //String todo = txt_IO.getText();
            //String texto = txt_IO.getSelectedText();
            //(txt_IO.getSelectedText()).setForeground(Color.red);;
            if(Colores.getSelectedItem().equals("Rojo")){
                
                txt_IO.setForeground(Color.red);
            }

            if(Colores.getSelectedItem().equals("Verde")){
                txt_IO.setForeground(Color.green);
            }

            if(Colores.getSelectedItem().equals("Azul")){
                txt_IO.setForeground(Color.blue);
            }

            if(Colores.getSelectedItem().equals("Negro")){
                txt_IO.setForeground(Color.black);
            }
            
            if(!Colores.getSelectedItem().equals("-Colores-")){
                Info.append("Cabiado a "+ Colores.getSelectedItem()+"\n");
            }
        }

        if(e.getSource() ==Tamaño){
            if(Tamaño.getSelectedItem().equals("Aumentar")){
                tamañofuente++;
                txt_IO.setFont(new Font("Arial", 0, tamañofuente));
                Info.append("Tamaño aumentado\n");
            }
            if(Tamaño.getSelectedItem().equals("Disminuir")){
                tamañofuente--;
                txt_IO.setFont(new Font("Arial", 0, tamañofuente));
                Info.append("Tamaño disminuido\n");
            }
            
        }

            
    }
        

        
    

    public static void main(String[] args) {
        VentanaBloc bloc = new VentanaBloc();
    }
    
}
