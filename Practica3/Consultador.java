package Practica3;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;

import javax.swing.*;
import java.net.*;

public class Consultador extends JFrame implements ActionListener {

    public Consultador() {
        topPanel();
        centerPanel();
        bottomPanel();
        initComponents();
    }

    public void initComponents() {
        this.setSize(450, 300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Consultador de IP");

        this.setLayout(new BorderLayout());

        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        btn_consultar.addActionListener(this);
        btn_clean.addActionListener(this);
        item.addActionListener(this);

    }

    private void topPanel() {
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.yellow);

        web = new JLabel("<html><body>"+"Introduce la direcion web:"+"<br>"+"Por ejemplo: www.ejemplo.com");
        web.setBackground(Color.DARK_GRAY);
        web.setForeground(Color.WHITE);

        directionIP = new JTextField();

        btn_consultar = new JButton("Consultar");
        btn_consultar.setBackground(new Color(93, 173, 226));
        btn_consultar.setForeground(Color.WHITE);

        topPanel.add(web, BorderLayout.WEST);
        topPanel.add(directionIP);
        topPanel.add(btn_consultar, BorderLayout.EAST);

    }

    private void centerPanel() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(new Color(178, 186, 187));

        information = new JTextArea();
        centerPanel.add(information);
    }

    private void bottomPanel() {

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2));
        topPanel.setBackground(new Color(128, 139, 150));

        btn_clean = new JButton("Limpiar");

        btn_clean.setBackground(new Color(245, 176, 65));
        btn_clean.setForeground(Color.WHITE);
        bottomPanel.add(btn_clean);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();

        if (buttonPressed == btn_consultar) {
            try {
                getIP();
            } catch (Exception error) {
                // TODO: handle exception
            }
        }
        if (buttonPressed == btn_clean) {
            information.setText("");
            directionIP.setText("");
        }
    }

    public void getIP() throws UnknownHostException {
        String url = directionIP.getText();
        InetAddress ip = InetAddress.getByName(url);
        information.setText("La direccion IP es: " + ip.getHostAddress());
    }

    public static void main(String[] args) {
        Consultador con = new Consultador();
    }
    private JMenuItem item;
    private JTextField directionIP;
    private JLabel web;
    private JTextArea information;
    private JButton btn_consultar;
    private JButton btn_clean;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;

}
