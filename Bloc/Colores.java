package Bloc;

import java.awt.event.*;

import javax.swing.border.Border;

import java.awt.*;

import Bloc.BlocNota;

public class Colores extends Frame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Colores(TextArea tArea) {
        initComponents();
        textAreaC = tArea;
    }

    public void initComponents() {

        // Creación de los paneles superior, central e inferior
        panel_superior = new Panel();
        panel_central = new Panel();
        panel_inferior = new Panel();

        // Asignación del Layout en los paneles
        panel_superior.setLayout(new FlowLayout());
        panel_central.setLayout(new FlowLayout());
        panel_inferior.setLayout(new FlowLayout());

        // Creación de los botones
        blackColor = new Button("Negro");
        redColor = new Button("Rojo");
        greenColor = new Button("Verde");
        yellowColor = new Button("Amarillo");
        blueColor = new Button("Azul");
        magentaColor = new Button("Magenta");
        whiteColor = new Button("Blanco");
        cyanColor = new Button("Cyan");

        btn_toAccept = new Button("Aceptar");
        btn_toApply = new Button("Aplicar");

        // lbl_msg = new Label("Este es un texto de ejemplo");
        textAreaC = new TextArea();
        textAreaC.setText("Ejemplo");
        textAreaC.getForeground();
        textAreaC.setEditable(false);

        fontM = new Fonts();

        this.setFont(fontM.FontM(0, 12f));

        setLayout(new BorderLayout());

        // Implementación de lo botones en el panel superior
        panel_superior.add(blackColor, FlowLayout.LEFT);
        panel_superior.add(redColor, FlowLayout.CENTER);
        panel_superior.add(greenColor, FlowLayout.RIGHT);
        panel_superior.add(yellowColor, FlowLayout.CENTER);
        this.add(panel_superior, BorderLayout.NORTH);

        // Implementación de lo botones en el panel central
        // panel_central.add(lbl_msg, FlowLayout.LEFT);
        panel_central.add(btn_toAccept, FlowLayout.LEFT);
        panel_central.add(textAreaC, BorderLayout.CENTER);
        panel_central.add(btn_toApply, FlowLayout.RIGHT);
        this.add(panel_central, BorderLayout.CENTER);

        // Implementación de los botones en el panel inferior
        panel_inferior.add(blueColor, FlowLayout.LEFT);
        panel_inferior.add(magentaColor, FlowLayout.CENTER);
        panel_inferior.add(whiteColor, FlowLayout.RIGHT);
        panel_inferior.add(cyanColor, FlowLayout.CENTER);
        this.add(panel_inferior, BorderLayout.SOUTH);

        // Creación de la ventana
        this.setLocationRelativeTo(null);
        this.setSize(500, 350);
        this.setTitle("Colores");
        this.setResizable(false);
        this.setVisible(true);

        TextColor tBlackColor = new TextColor(Color.BLACK, textAreaC);
        TextColor tRedColor = new TextColor(Color.RED, textAreaC);
        TextColor tBlueColor = new TextColor(Color.BLUE, textAreaC);

        blackColor.addActionListener(tBlackColor);
        redColor.addActionListener(tRedColor);
        blueColor.addActionListener(tBlueColor);

        ButtonAssig btn_toAceptAssig = new ButtonAssig(null, btn_toAccept, textAreaC);
        ButtonAssig btn_toApplyAssig = new ButtonAssig(Color.MAGENTA, btn_toApply, textAreaC);

        btn_toAccept.addActionListener(btn_toAceptAssig);
        btn_toApply.addActionListener(btn_toApplyAssig);
        // textAreaC.addActionListener(btn_toApplyAssig);
    }

    public static void main(String[] args) {
        // todo
    }

    private Panel panel_superior;
    private Panel panel_central;
    private Panel panel_inferior;

    private Button blackColor;
    private Button redColor;
    private Button greenColor;
    private Button yellowColor;
    private Button blueColor;
    private Button magentaColor;
    private Button whiteColor;
    private Button cyanColor;

    private Button btn_toAccept;
    private Button btn_toApply;

    // private Label lbl_msg;

    private TextArea textAreaC;
    private Color textAreaColorAssig;

    private Fonts fontM;

    private class TextColor implements ActionListener {

        public TextColor(Color color, TextArea textAreaTC) {
            textColor = textAreaColorAssig = color;
            txtArea = textAreaTC;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            txtArea.setForeground(textColor);

            if (e.getSource() == btn_toApply) {
                textAreaC.setForeground(textColor);
                // txtArea.setForeground(textColor);
            }
        }

        private Color textColor;
        private Label lbl_text;
        private TextArea txtArea;

    }

    private class ButtonAssig implements ActionListener {

        public ButtonAssig(Color textColor, Button btn, TextArea textAreaB) {
            tColor = textAreaColorAssig = textColor;
            btn_press = btn;
            txtArea = textAreaB;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btn_toAccept) {
                dispose();
            }

            txtArea.setForeground(tColor);

            if (e.getSource() == btn_toApply) {
                textAreaC.setForeground(tColor);
                setVisible(false);
            }

        }

        private Color tColor;
        private Button btn_press;
        private TextArea txtArea;
    }

    public void setTextAreaC(TextArea textAreaC) {
        this.textAreaC = textAreaC;
    }

    public Color getTextAreaColorAssig() {
        return textAreaColorAssig;
    }

    public void setTextAreaColorAssig(Color textAreaColorAssig) {
        this.textAreaColorAssig = textAreaColorAssig;
    }

}