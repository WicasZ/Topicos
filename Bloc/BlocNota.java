package Bloc;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.concurrent.Flow;
import java.awt.*;

public class BlocNota extends Frame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public BlocNota() {
        initComponents();
    }

    public void initComponents() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // Creación de los paneles superior, central e inferior
        panel_superior = new Panel();
        panel_central = new Panel();
        panel_inferior = new Panel();

        // Asignación del Layout en los paneles
        panel_superior.setLayout(new FlowLayout());
        panel_central.setLayout(new BorderLayout());
        panel_inferior.setLayout(new BorderLayout());

        // Creacion del TextArea
        txt_out = new TextArea();

        // Creación del TextField
        txt_init = new TextField();
        txt_init.setEditable(false);

        // Creación de los botones
        btn_asigColor = new Button("Color");
        btn_addCom = new Button("Comillas");
        btn_tamFont = new Button("Fuente");
        btn_open = new Button("Abrir");
        btn_save = new Button("Guardar");
        btn_exit = new Button("Salir");
        btn_info = new Button("Acerca de BN");

        fontM = new Fonts();

        this.setFont(fontM.FontM(1, 12f));

        setLayout(new BorderLayout());

        // Implementación de lo botones en el panel superior
        panel_superior.add(btn_asigColor, FlowLayout.LEFT);
        panel_superior.add(btn_exit, FlowLayout.CENTER);
        panel_superior.add(btn_info, FlowLayout.RIGHT);
        panel_superior.add(btn_save, FlowLayout.CENTER);
        panel_superior.add(btn_open, FlowLayout.CENTER);
        panel_superior.add(btn_addCom, FlowLayout.CENTER);
        panel_superior.add(btn_tamFont, FlowLayout.CENTER);
        this.add(panel_superior, BorderLayout.NORTH);

        // Implementación del TextArea en el panel central
        panel_central.add(txt_out, BorderLayout.CENTER);
        this.add(panel_central, BorderLayout.CENTER);

        // Implementación del TextFiel en el panel inferior
        panel_inferior.add(txt_init, BorderLayout.SOUTH);
        this.add(panel_inferior, BorderLayout.SOUTH);

        btn_asigColor.addActionListener(this);
        btn_exit.addActionListener(this);

        // Creación de la ventana
        this.setSize(500, 350);
        changeTitle();
        this.setVisible(true);
    }

    // Título por defecto al crear una nueva nota
    public void changeTitle() {

        title_aux = "";

        String initTitle = ": Bloc de notas";
        if (title_aux.compareTo("") == 0)
            title_aux = "S\u00edn t\u00edtulo";
        initTitle = title_aux + initTitle;
        setTitle(initTitle);
    }

    public void saveFile(boolean save) {
        // TODO: acción para guardar archivo
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_asigColor) {
            color = new Colores(txt_out);
            color.setVisible(true);
            color.getForeground();
        }

        if (e.getSource() == btn_exit) {
            dispose();
        }

    }

    public static void main(String[] args) {
        BlocNota bn = new BlocNota();
    }

    private TextArea txt_out;
    private TextField txt_init;

    private Button btn_asigColor;
    private Button btn_addCom;
    private Button btn_tamFont;
    private Button btn_open;
    private Button btn_save;
    private Button btn_exit;
    private Button btn_info;

    private Panel panel_superior;
    private Panel panel_central;
    private Panel panel_inferior;

    private Fonts fontM;
    private String title_aux;

    private Colores color;
}
