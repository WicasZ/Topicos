package Calculadora;
public class Operaciones{
    
    public String operacion(String [] arr){
        double result = Double.parseDouble(arr[0]);
        

        switch(Integer.parseInt(arr[1])){
            case 1:
                result *= Double.parseDouble(arr[2]);
                break;
            case 2:
                break;
            case 3:
                result += Double.parseDouble(arr[2]);
                break;
            case 4:
                result -= Double.parseDouble(arr[2]);
                break;
            case 5:
                try {
                    result /= Double.parseDouble(arr[2]);
                } catch (ArithmeticException e) {
                    return e+"";
                }
                break;
        }     

        return result + "";
    }
}