package Calculadora;
import java.awt.TextField;
public class Operaciones{
    int operacion;
    double var1, var2, y;
    TextField Op_Usar;
    public Object [] ecuacion;
    private int longitud;
    public Operaciones(/*TextField op*/){
        //this.Op_Usar = op;
        
    }
    
    public String operacion(int tipo, double op, double var){
        double result = op;

        switch(tipo){
            case 1:
                result *= var;
                break;
            case 2:
                break;
            case 3:
                result += var;
                break;
            case 4:
                result -= var;
                break;
            case 5:
                try {
                    result /= var;
                } catch (ArithmeticException e) {
                    return ("Error: ");
                }
                break;

        }     

        return result + "";
    }

    public void guardar(String [] a){
        ecuacion = new Object [a.length];
        for(int j = 0; j<a.length; j++){
            if(isNume(a[j])){
                ecuacion[j] = Double.parseDouble(a[j]);
            }else{
                ecuacion[j] = a[j];
            }
            longitud++;
        }
        show(ecuacion);
    }

    public static boolean isNume(String valor){
        try{
            if(valor!=null);{
                Integer.parseInt(valor);
            }
        } catch(NumberFormatException e){
            return false;
        }
        return true;

    }

    public void show(Object [] ad){
        int i = 0;
        while(!ad[i].equals(null)){
            System.out.print(ad[i]);
            i++;
        }
    }

    public void pila(){
        for(int l = 0; l<longitud; l++){
            if(ecuacion[l].equals("(")){
                boolean cerrar = false;
                while(!cerrar){
                    
                }
            }
        }
    }
}