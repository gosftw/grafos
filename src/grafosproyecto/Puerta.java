package grafosproyecto;

public class Puerta 
{
    public Cuarto cuarto1;
    public Cuarto cuarto2;
    public Boolean visitado = false;
    
    public Puerta (Cuarto cu1, Cuarto cu2)
    {
        this.cuarto1=cu1;
        this.cuarto2=cu2;
    }
    public String getCuarto1()
    {
        return this.cuarto1.getCuarto();
    }
    public String getCuarto2()
    {
        return this.cuarto2.getCuarto();
    }
    
}
