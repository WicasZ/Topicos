package Calculadora;
import java.awt.TextField;
public class Operaciones{
    int operacion;
    double var1;
    TextField Op_Usar;
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
}