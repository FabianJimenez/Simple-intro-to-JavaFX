package integral;

public class Solucionador 
{
    
    private double a;
    private double b;
    
    public Solucionador(double a, double b)
    {
        this.a = a;
        this.b = b;
    }
    
    public double resolverIntegral(int funcion)
    {
        double resultado = 0;
        
        if(funcion == 1) // f(x) = x
        {
            resultado = (Math.pow(b,2)/2) - (Math.pow(a,2)/2);
        }
        else if(funcion == 2) // f(x) = x
        {
            resultado = (Math.pow(b,3)/3) - (Math.pow(a,3)/3);
        }
        else if(funcion == 3) // f(x) = x
        {
            resultado = (Math.pow(b,4)/4) - (Math.pow(a,4)/4);
        }
        
        return resultado;
    }
}

