package Ejercicio5;
import java.awt.Frame;
import java.awt.event.*; //libreria para la line 13 hasta la 18 el WindowListener
import java.awt.*;

import org.w3c.dom.events.MouseEvent;
public class Pantalla extends Frame implements MouseListener{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Contenedor obj_pintable;

    public Pantalla(){
        initComponents();

    }

    public void initComponents(){
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        obj_pintable = new Contenedor();
        obj_pintable.addMouseListener(this);
        this.add(obj_pintable);
        this.setSize(500,500);
        this.setVisible(true);
        this.setTitle("Lienzo");
    }
    public static void main(String [] args){
        Pantalla p = new Pantalla();

    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Clicked");
        if(obj_pintable.isClicked()){
            obj_pintable.setW(e.getX());
            obj_pintable.setH(e.getY());
            obj_pintable.repaint();
            
        }else{
            obj_pintable.setX(e.getX());
            obj_pintable.setY(e.getY());
        }
        obj_pintable.setClicked();
        
        
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Presionado");
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Liberado");
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Entrado");
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Salido");
        
    }
}
