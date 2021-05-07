package segundoparcial.Ejercicio1.ejercicio3;

public class Productor extends Thread{
    private String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String processName;
    private Almacen container;

    public Productor(int n, Almacen m){
        processName = "P-" + n;
        container = m;
    }

    public void run(){
        char c;
        System.out.print(processName);
        for(int i = 0; i<10; i++){
            c = letras.charAt((int)(Math.random()*26));
            container.asignar(c);
            System.out.println(String.format("[%s]: Produce letra: %s", processName, c));
            try {
                Thread.sleep((int)Math.random()*100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
