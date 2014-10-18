package grafosproyecto;

public class Puerta 
{
    private Cuarto cuarto1;
    private Cuarto cuarto2;
    private Boolean visitado = false;
    
    public Puerta (Cuarto cu1, Cuarto cu2)
    {
        this.cuarto1=cu1;
        this.cuarto2=cu2;
    }
    
}
