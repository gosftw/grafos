package grafosproyecto;
import java.util.ArrayList;

public class Cuarto 
{
    public String dato;
    public ArrayList<Cuarto> cuarto;
    public Boolean visitado = false;
    public Boolean gradoImpar = false;
    public int nroComponente;
        
    public Cuarto (String da)
    {
        this.dato=da;
        cuarto = new ArrayList<Cuarto> ();
    }
    
    public String getCuarto()
    {
       return this.dato; 
    }
    
    public void addPuerta(Cuarto cu)
    {
        this.cuarto.add(cu);
    }
    
    public ArrayList getCuartos()
    {
        return cuarto;
    }
    public int cantidadCuarto()
    {
        return cuarto.size();
    }
}
