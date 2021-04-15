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
    private Button sum, mul, rest, punto, div, igual, relleno1, relleno2, relleno3, ac;
    //private double resul_op;
    private int operacion = 0;
    private int contador;
    private String [] savedig;
    Operaciones opera;

    public CalculadoraGUI(String nombre){
        setTitle(nombre);
        iniComponent();
        this.contador = 0;
        savedig = new String [3];
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
        relleno1 = new Button();
        relleno2 = new Button();
        relleno3 = new Button();
        ac = new Button("AC");
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
        panel_inf.add(relleno1, 4,0);
        panel_inf.add(relleno2, 4,1);
        panel_inf.add(relleno3, 4,2);
        panel_inf.add(ac, 4,3);
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
        relleno1.addActionListener(this);
        relleno2.addActionListener(this);
        relleno3.addActionListener(this);
        ac.addActionListener(this);

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
                mostrar.setText("1");
            }
            if(operacion==0){
                savedig[contador] = "1";
                operacion++;
            }else{
                savedig[contador] += "1";
            }
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
            if(operacion==0){
                savedig[contador] = "4";
                operacion++;
            }else{
                savedig[contador] += "4";
            }
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
            if(operacion==0){
                savedig[contador] = "7";
                operacion++;
            }else{
                savedig[contador] += "7";
            }
            mostrar.setForeground(Color.BLACK);
        }

        if(e.getSource() == mul){
            if(!mostrar.getText().equals("1234567890")){
                mostrar.setText(mostrar.getText()+"x");
                if(operacion!=0)contador++;
                savedig[contador] = "1";
                contador++;
                operacion = 0;
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
            if(operacion==0){
                savedig[contador] = "2";
                operacion++;
            }else{
                savedig[contador] += "2";
            }
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
            if(operacion==0){
                savedig[contador] = "5";
                operacion++;
            }else{
                savedig[contador] += "5";
            }
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
            if(operacion==0){
                savedig[contador] = "8";
                operacion++;
            }else{
                savedig[contador] += "8";
            }
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
            if(operacion==0){
                savedig[contador] = "0";
                operacion++;
            }else{
                savedig[contador] += "0";
            }
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
            if(operacion==0){
                savedig[contador] = "3";
                operacion++;
            }else{
                savedig[contador] += "3";
            }
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
            if(operacion==0){
                savedig[contador] = "6";
                operacion++;
            }else{
                savedig[contador] += "6";
            }
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
            if(operacion==0){
                savedig[contador] = "9";
                operacion++;
            }else{
                savedig[contador] += "9";
            }
            mostrar.setForeground(Color.BLACK);
        }
        
        if(e.getSource() == punto){
            if(mostrar.getText().equals("1234567890") || mostrar.getText().equals("")){
                mostrar.setText("0.");
                if(operacion==0){
                    savedig[contador] = "0.";
                    operacion++;
                }

            }else{

                String num =mostrar.getText() + ".";
                mostrar.setText(num);
                    savedig[contador] += ".";
            }
            mostrar.setForeground(Color.BLACK);
        }

        if(e.getSource() == sum){
            if(!mostrar.getText().equals("1234567890")){
                mostrar.setText(mostrar.getText() + "+");
                if(operacion!=0)contador++;
                savedig[contador] = "3";
                contador++;
                operacion =0;
            }
        }
        
        if(e.getSource() == rest){
            if(!mostrar.getText().equals("1234567890")){
                mostrar.setText(mostrar.getText() + "-");
                if(operacion!=0)contador++;
                savedig[contador] = "4";
                contador++;
                operacion =0;
            }
        }
        
        if(e.getSource() == div){
            if(!mostrar.getText().equals("1234567890")){
                mostrar.setText(mostrar.getText() + "/");
                if(operacion!=0)contador++;
                savedig[contador] = "5";
                contador++;
                operacion = 0;
            }
        }
        if(e.getSource() == igual){
            if(!mostrar.getText().equals("1234567890")){
                opera = new Operaciones();
                operacion=0;
                contador = 1;
                savedig[0] = opera.operacion(savedig);
                mostrar.setText(savedig[0]);
            }     
        }
        
        if(e.getSource() == ac){
            contador = 0;
            mostrar.setText("");
            operacion = 0;
        }
    }

    public static void main(String[] args) {
        CalculadoraGUI micalculadora = new CalculadoraGUI("Calculadora Simple");
    }
    
}