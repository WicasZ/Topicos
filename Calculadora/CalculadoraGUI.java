package Calculadora;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraGUI extends Frame implements ActionListener{

    private static final long serialVersionUID = 1L;
    private Panel panel_sup;
    private Panel panel_inf;
    private Label mostrar;
    private TextField txt;
    private Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num0;
    private Button sum, mul, rest, punto, div, igual, aParentesis, cParentesis, porcentaje, AC;
    private double resul_op;
    private int operacion;
    private int contador;
    private String [] savedig;
    Operaciones opera;

    public CalculadoraGUI(String nombre){
        setTitle(nombre);
        iniComponent();
        this.contador = 0;
        savedig = new String [20];
        opera = new Operaciones();
    }

    private void iniComponent() {
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        //Paneles
        panel_sup = new Panel();
        panel_inf = new Panel();
        //Label
        mostrar = new Label("1234567890");
        mostrar.setForeground(Color.GRAY);//Color de lo que mostrara
        mostrar.setFont(new Font("Arial", 0, 20));
        mostrar.setAlignment(Label.RIGHT);
        //Botones
        num1 = new Button("1");
        num2 = new Button("2");
        num3 = new Button("3");
        num4 = new Button("4");
        num5 = new Button("5");
        num6 = new Button("6");
        num7 = new Button("7");
        num8 = new Button("8");
        num9 = new Button("9");
        num0 = new Button("0");
        sum = new Button("+");
        mul = new Button("x");
        rest = new Button("-");
        punto = new Button(".");
        div = new Button("/");
        igual = new Button("=");
        aParentesis = new Button("(");
        cParentesis = new Button(")");
        porcentaje = new Button("%");
        AC = new Button("AC");
        //campo
        txt = new TextField("1234567890");
        panel_sup.setLayout(new BorderLayout());
        panel_sup.add(mostrar, BorderLayout.EAST);
        panel_inf.setLayout(new GridLayout(5,4, 5,5));
        this.setLayout(new BorderLayout());
        //añadiendo botones en el panel inferior
        panel_inf.add(num0, 0,0);
        panel_inf.add(punto, 0,1);
        panel_inf.add(igual, 0,2);
        igual.setBackground(Color.BLUE); //Le añado un color al boton de igualdad
        igual.setForeground(Color.WHITE);//le asigno un color al simbolo de igualdad
        panel_inf.add(sum, 0,3);
        panel_inf.add(num1, 1,0);
        panel_inf.add(num2, 1,1);
        panel_inf.add(num3, 1,2);
        panel_inf.add(rest, 1,3);
        panel_inf.add(num4, 2,0);
        panel_inf.add(num5, 2,1);
        panel_inf.add(num6, 2,2);
        panel_inf.add(mul, 2,3);
        panel_inf.add(num7, 3,0);
        panel_inf.add(num8, 3,1);
        panel_inf.add(num9, 3,2);
        panel_inf.add(div, 3,3);
        panel_inf.add(aParentesis, 4,0);
        panel_inf.add(cParentesis, 4,1);
        panel_inf.add(porcentaje, 4,2);
        panel_inf.add(AC, 4,3);
        this.add(panel_sup, BorderLayout.NORTH);
        this.add(panel_inf);
        num1.addActionListener(this);
        num2.addActionListener(this);
        num3.addActionListener(this);
        num4.addActionListener(this);
        num5.addActionListener(this);
        num6.addActionListener(this);
        num7.addActionListener(this);
        num8.addActionListener(this);
        num9.addActionListener(this);
        num0.addActionListener(this);
        mul.addActionListener(this);
        punto.addActionListener(this);
        igual.addActionListener(this);
        div.addActionListener(this);
        rest.addActionListener(this);
        sum.addActionListener(this);
        aParentesis.addActionListener(this);
        cParentesis.addActionListener(this);
        porcentaje.addActionListener(this);
        AC.addActionListener(this);

        this.setSize(500,400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == num1){
            if(mostrar.getText().equals("1234567890")){
                mostrar.setText("");
            }
            if(!(mostrar.getText()).equals(null)){
                String num =mostrar.getText() + "1";
                mostrar.setText(num);
            }else{
                savedig[contador] = "1";
            }
            mostrar.setText("1");
            contador++;
            mostrar.setForeground(Color.BLACK);
        }
        
        if(e.getSource() == num4){
            if(mostrar.getText().equals("1234567890")){
                mostrar.setText("");
            }
            if(!(mostrar.getText()).equals(null)){
                String num =mostrar.getText() + "4";
                mostrar.setText(num);
            }else{
                mostrar.setText("4");
            }
            savedig[contador] = "4";
            contador++;
            mostrar.setForeground(Color.BLACK);
        }
        
        if(e.getSource() == num7){
            if(mostrar.getText().equals("1234567890")){
                mostrar.setText("");
            }
            if(!(mostrar.getText()).equals(null)){
                String num =mostrar.getText() + "7";
                mostrar.setText(num);
            }else{
                mostrar.setText("7");
            }
            savedig[contador] = "7";
            contador++;
            mostrar.setForeground(Color.BLACK);
        }

        if(e.getSource() == mul){
            if(!mostrar.getText().equals("1234567890")){
                //operacion = 1;
                //resul_op = Double.parseDouble(mostrar.getText());
                mostrar.setText(mostrar.getText()+"x");
                savedig[contador] = "*";
                contador++;
            }
        }
        
        if(e.getSource() == num2){
            if(mostrar.getText().equals("1234567890")){
                mostrar.setText("");
            }
            if(!(mostrar.getText()).equals(null)){
                String num =mostrar.getText() + "2";
                mostrar.setText(num);
            }else{
                mostrar.setText("2");
            }
            savedig[contador] = "2";
            contador++;
            mostrar.setForeground(Color.BLACK);
        }
        
        if(e.getSource() == num5){
            if(mostrar.getText().equals("1234567890")){
                mostrar.setText("");
            }
            if(!(mostrar.getText()).equals(null)){
                String num =mostrar.getText() + "5";
                mostrar.setText(num);
            }else{
                mostrar.setText("5");
            }
            savedig[contador] = "5";
            contador++;
            mostrar.setForeground(Color.BLACK);
        }
        
        if(e.getSource() == num8){
            if(mostrar.getText().equals("1234567890")){
                mostrar.setText("");
            }
            if(!(mostrar.getText()).equals(null)){
                String num =mostrar.getText() + "8";
                mostrar.setText(num);
            }else{
                mostrar.setText("8");
            }
            savedig[contador] = "8";
            contador++;
            mostrar.setForeground(Color.BLACK);
        }

        if(e.getSource() == num0){
            if(mostrar.getText().equals("1234567890")){
                mostrar.setText("");
            }
            if(!(mostrar.getText()).equals(null)){
                String num =mostrar.getText() + "0";
                mostrar.setText(num);
            }else{
                mostrar.setText("0");
            }
            savedig[contador] = "0";
            contador++;
            mostrar.setForeground(Color.BLACK);
        }

        if(e.getSource() == num3){
            if(mostrar.getText().equals("1234567890")){
                txt.setText("");
            }
            if(!(mostrar.getText()).equals(null)){
                String num =mostrar.getText() + "3";
                mostrar.setText(num);
            }else{
                mostrar.setText("3");
            }
            savedig[contador] = "3";
            contador++;
            mostrar.setForeground(Color.BLACK);
        }
        
        if(e.getSource() == num6){
            if(mostrar.getText().equals("1234567890")){
                mostrar.setText("");
            }
            if(!(mostrar.getText()).equals(null)){
                String num =mostrar.getText() + "6";
                mostrar.setText(num);
            }else{
                mostrar.setText("6");
            }
            savedig[contador] = "6";
            contador++;
            mostrar.setForeground(Color.BLACK);
        }
        
        if(e.getSource() == num9){
            if(mostrar.getText().equals("1234567890")){
                mostrar.setText("");
            }
            if(!(mostrar.getText()).equals(null)){
                String num =mostrar.getText() + "9";
                mostrar.setText(num);
            }else{
                mostrar.setText("9");
            }
            savedig[contador] = "9";
            contador++;
            mostrar.setForeground(Color.BLACK);
        }
        
        if(e.getSource() == punto){
            if(mostrar.getText().equals("1234567890") || mostrar.getText().equals("")){
                mostrar.setText("0.");
                savedig[contador] = "0";
                contador++;
                savedig[contador] = ".";

            }else{
                String num =mostrar.getText() + ".";
                mostrar.setText(num);
                savedig[contador] = ".";
                contador++;
            }
            mostrar.setForeground(Color.BLACK);
        }

        if(e.getSource() == sum){
            if(!mostrar.getText().equals("1234567890")){
                //operacion = 3;
                //resul_op = Double.parseDouble(mostrar.getText());
                mostrar.setText(mostrar.getText() + "+");
                savedig[contador] = "+";
                contador++;
            }
        }
        
        if(e.getSource() == rest){
            if(!mostrar.getText().equals("1234567890")){
                //operacion = 4;
                //resul_op = Double.parseDouble(mostrar.getText());
                mostrar.setText(mostrar.getText() + "-");
                savedig[contador] = "-";
                contador++;
            }
        }
        
        if(e.getSource() == div){
            if(!mostrar.getText().equals("1234567890")){
                //operacion = 5;
                //resul_op = Double.parseDouble(mostrar.getText());
                mostrar.setText(mostrar.getText() + "/");
                savedig[contador] = "/";
                contador++;
            }
        }
        if(e.getSource() == igual){
            if(!mostrar.getText().equals("1234567890")){
                //String resultado = (opera.operacion(operacion, resul_op, (Double.parseDouble(mostrar.getText()))));
                //mostrar.setText(resultado);
                sohw();
                operacion=0;
                resul_op = 0;
                contador = 0;
            }     
        }

        if(e.getSource() == aParentesis){
            if(mostrar.getText().equals("1234567890")){
                mostrar.setText("");
            }
            if(!(mostrar.getText()).equals(null)){
                String num =mostrar.getText() + "(";
                mostrar.setText(num);
            }else{
                mostrar.setText("(");
            }
            savedig[contador] = "(";
            contador++;
            mostrar.setForeground(Color.BLACK);
        }

        if(e.getSource() == cParentesis){
            if(mostrar.getText().equals("1234567890")){
                mostrar.setText("");
            }
            if(!(mostrar.getText()).equals(null)){
                String num =mostrar.getText() + ")";
                mostrar.setText(num);
            }else{
                mostrar.setText(")");
            }
            savedig[contador] = ")";
            contador++;
            mostrar.setForeground(Color.BLACK);
        }
        
        if(e.getSource() == AC){
            mostrar.setText("");
            operacion = 0;
            resul_op = 0;
        }
    }
    

    private void sohw() {
        int i = 0;
        while(!savedig[i].equals(null)){
            System.out.print(savedig[i]);
            i++;
        }
    }

    public static void main(String[] args) {
        CalculadoraGUI micalculadora = new CalculadoraGUI("Calculadora Simple");
    }
    
}