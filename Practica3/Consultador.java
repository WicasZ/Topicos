package Practica3;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;

import javax.swing.*;
import java.net.*;

public class Consultador extends JFrame implements ActionListener {

    public Consultador() {
        menu();
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

        toAcept.addActionListener(this);
        clear.addActionListener(this);
        item.addActionListener(this);

    }

    private void menu() {
        menubar = new JMenuBar();
        menu = new JMenu("Menu");
        item = new JMenuItem("Ayuda");

        this.setJMenuBar(menubar);
        menubar.add(menu);
        menu.add(item);

    }

    private void topPanel() {
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.yellow);

        web = new JLabel("Introduce la direcion web: ");
        web.setBackground(Color.DARK_GRAY);
        web.setForeground(Color.WHITE);

        directionIP = new JTextField();

        toAcept = new JButton("Aceptar");
        toAcept.setBackground(new Color(93, 173, 226));
        toAcept.setForeground(Color.WHITE);

        topPanel.add(web, BorderLayout.WEST);
        topPanel.add(directionIP);
        topPanel.add(toAcept, BorderLayout.EAST);

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

        clear = new JButton("Limpiar");

        clear.setBackground(new Color(245, 176, 65));
        clear.setForeground(Color.WHITE);
        bottomPanel.add(clear);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();

        if (buttonPressed == toAcept) {
            try {
                getIP();
            } catch (Exception error) {
                // TODO: handle exception
            }
        }
        if (buttonPressed == clear) {
            information.setText("");
            directionIP.setText("");
        }
        if (buttonPressed == item) {
            JDialog d = new JDialog(this);
            h = new Ayuda(d, true);
            h.setVisible(true);
        }
    }

    public void getIP() throws UnknownHostException {
        String url = directionIP.getText();
        InetAddress ip = InetAddress.getByName(url);
        information.setText("La direccion IP es: \n" + ip.getHostAddress());
    }

    public static void main(String[] args) {
        Consultador con = new Consultador();
    }

    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem item;
    private JTextField directionIP;
    private JLabel web;
    private JTextArea information;
    private JButton toAcept;
    private JButton clear;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private Ayuda h;

}
