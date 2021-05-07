package segundoparcial.Ejercicio1.ejercicio3;

public class Almacen {
    private char [] contenedor = new char [6];
    int ptr = 0;
    private boolean isFull = true;
    private boolean isEmpty = true;

    public synchronized char obtener(){
        if(!isEmpty){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ptr--;
        char ret = contenedor[ptr];
        if(ptr<0){
            isEmpty = true;
        }
        isFull = false;
        notify();
        return ret;
    }



    public synchronized void asignar(char c){
        if(isFull){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        contenedor[ptr-1] = c;
        ptr++;
        if(ptr == contenedor.length){
            isFull = true;
        }
        isEmpty = false;
        notify();
    }
}
