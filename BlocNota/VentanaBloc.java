package BlocNota;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ProcessHandle.Info;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VentanaBloc extends Frame implements ActionListener{
  
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //Atributos
    
    private TextArea txt_IO;//Area donde escribire
    private TextField Info;//Area donde mostrare todo la realizado, es un historial
    
    //Botones
    private Button btn_Color;
    private Button btn_addComillas;
    private Button btn_nuevo;
    private Button btn_Abrir;
    private Button btn_Salir;
    private Button btn_Guardar;
    //secciones para distribuir los batones, area de texto e historial
    private Panel panel_superior;
    private Panel panel_central;
    private Panel panel_inferior;
    
    //Listado de opciones
    private JComboBox Tamaño;
    private int tamañofuente = 12;
    private String [] tamaños = {"-Tamaño-", "Aumentar", "Disminuir"};
    
    //Constructor
    public VentanaBloc(){
        iniVentana();
        

        
    }

    //Metodo donde se crea la ventana
    private void iniVentana() {
        //para cerrar ventana y terminar porceso del programa
        this.addWindowListener(new WindowAdapter(){

            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        //inicializo los paneles
        panel_superior = new Panel();
        panel_central = new Panel();
        panel_inferior = new Panel();
        //añado que tipo de dsitribucion tendran en su interior
        panel_superior.setLayout(new FlowLayout());
        panel_central.setLayout(new BorderLayout());
        panel_inferior.setLayout(new BorderLayout());
        //inicializo los botones y las areas de texto
        txt_IO = new TextArea();
        Info = new TextField();
        btn_Color = new Button("Color");
        Tamaño = new JComboBox<>(tamaños);
        btn_addComillas = new Button("Entre comillado");
        btn_nuevo = new Button("Nuevo");
        btn_Abrir = new Button("Abrir");
        btn_Salir = new Button("Salir");
        btn_Guardar = new Button("Guardar");
        //empiezo a poner en que seccion iran cada boton y areas de texto
        this.setLayout(new FlowLayout());
        this.setLayout(new BorderLayout());
        panel_superior.add(btn_nuevo);
        panel_superior.add(btn_Color);
        panel_superior.add(btn_addComillas);
        panel_superior.add(Tamaño);
        panel_superior.add(btn_Abrir);
        panel_superior.add(btn_Salir);
        panel_superior.add(btn_Guardar);
        panel_central.add(txt_IO);
        //señalo en que parte de la vantana iran los paneles
        panel_inferior.add(Info, BorderLayout.CENTER);
        this.add(panel_superior, BorderLayout.NORTH);
        this.add(panel_central, BorderLayout.CENTER);
        this.add(panel_inferior, BorderLayout.SOUTH);
        //les añado un escuchador
        btn_Color.addActionListener(this);
        btn_addComillas.addActionListener(this);
        Tamaño.addActionListener(this);
        btn_nuevo.addActionListener(this);
        btn_Abrir.addActionListener(this);
        btn_Salir.addActionListener(this);
        btn_Guardar.addActionListener(this);

        //creo el tamaño, visibilidad, titulo y localizacion
        this.setSize(700,1000);
        this.setVisible(true);
        this.setTitle(" - Mi editor de texto");
        this.setLocationRelativeTo(null);
        txt_IO.setFont(new Font("Arial", 0, tamañofuente));
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //si se presiona el boton "Entre comillas"
        if(e.getSource() == btn_addComillas){
            
            String todo = txt_IO.getText();//obtengo todo el texto
            String texto = txt_IO.getSelectedText();// y el texto seleccionado
            if(!texto.equals("")){//pregunto que si lo seleccionado tiene algo entra si no, no hace el entrecomillado
                txt_IO.setText(todo.replace(texto, "''"+texto+"''"));//remplazo del todo el texto de la ventana los que seleccione y le añado entrecomillado
                Info.setText("Comillas a\u00f1adido a -" + texto + "-\n");//muestro que hice
            }
        }

        if(e.getSource() == btn_Abrir){
            //Muestra el cuadro de dialogo para que se puedaa escoger un archivo
            JFileChooser archivoseleccion = new JFileChooser(System.getProperty("user.dir"));
            archivoseleccion.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            //muestra la accion del usuario del JFileChoose
            int resultado = archivoseleccion.showOpenDialog(this);
            //guardo en una variable Archivo el archivo selecciondo
            File archivo = archivoseleccion.getSelectedFile();

            //SAbier si el archivo seleccionado es invalido
            if((archivo == null) || (archivo.getName().equals(""))){
                JOptionPane.showMessageDialog(this, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
            }
                //variable para leer contenido del archivo y titulo
            String leer;
            try {
                //leo linea por linea contenido del archivo
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                leer = br.readLine();
                //ciclo para leer y añadir el contenido del archivo 
                while(leer != null){
                    txt_IO.append(leer+"\n");
                    leer = br.readLine();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
                
                
            leer = archivo.getName();//obtengo el nombre del archivo
            this.setTitle(leer + " - Mi editor de texto");//añado el nombre del archivo a la ventana
            Info.setText("El archivo " + leer + " se ha abierto.\n");//muestro lo que hice
        }

        if(e.getSource() == btn_Salir){
            Info.setText("Salido.\n");//muestro lo que hice
            System.exit(WIDTH);//cierro ventana y proceso de la clase
        }

        if(e.getSource() == btn_Guardar){
            //creo la vantana para escoger donde guardar
            JFileChooser paguardar = new JFileChooser();
            paguardar.setFileSelectionMode(JFileChooser.FILES_ONLY);//indica que solo archivos puedo guardar y crear
            if(JFileChooser.APPROVE_OPTION == paguardar.showSaveDialog(txt_IO)){
                File archivo = paguardar.getSelectedFile();
                FileWriter escrito = null;//se usara para guardar el texto de la ventana
                try{
                    //lo inicializo
                    escrito = new FileWriter(archivo);
                    //escribo todo lo que tiene el textArea y lo paso al archivo
                    escrito.write(txt_IO.getText());
                    Info.setText("Archivo guardado.\n");//muestro lo que hice
                }catch(FileNotFoundException ex){
                    Logger.getLogger(VentanaBloc.class.getName()).log(Level.SEVERE, null, ex);//excepcion si falla en guardar el archivo
                }catch(IOException excepcion){
                    Logger.getLogger(VentanaBloc.class.getName()).log(Level.SEVERE, null, excepcion);//excepcion de entreada y salida
                }finally{
                    try{
                        escrito.close();
                    }catch(IOException exc){
                        Logger.getLogger(VentanaBloc.class.getName()).log(Level.SEVERE, null, exc);
                    }
                }
            }
            
            
        }


        if(e.getSource() == btn_nuevo){
            txt_IO.setText("");//limpia el TextArea para escribir
            Info.setText("Nuevo archivo");//muestro lo que hice
        }

        if(e.getSource() == btn_Color){
            Colores color = new Colores(txt_IO);//llamo una clase que mostrara otra ventana 
            color.setVisible(true);
            color.getForeground();
            Info.setText("Cambiado de color");
        }

        if(e.getSource() ==Tamaño){
            //tengo dos condiciones si aumneto o disminuyo
            if(Tamaño.getSelectedItem().equals("Aumentar")){
                tamañofuente++;//al tamaño fuente le aumneto
                txt_IO.setFont(new Font("Arial", 0, tamañofuente));
                Info.setText("Tamaño aumentado\n");//muestro lo que hice
            }
            if(Tamaño.getSelectedItem().equals("Disminuir")){
                tamañofuente--;//al tamaño fuente le disminuyo
                txt_IO.setFont(new Font("Arial", 0, tamañofuente));
                Info.setText("Tamaño disminuido\n");//muestro lo que hice
            }
            
        }

            
    }
        

        
    

    public static void main(String[] args) {
        VentanaBloc bloc = new VentanaBloc();//aqui inicio la clase
    }
    
}
