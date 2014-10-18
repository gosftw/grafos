package grafosproyecto;

import java.util.ArrayList;

public class Plano 
{
    public ArrayList<Cuarto> listaCuarto;
    public ArrayList<Puerta> listaPuerta;
    
    public Plano()
    {
        listaCuarto=new ArrayList<Cuarto> ();
        listaPuerta=new ArrayList<Puerta> ();
    }
    
    public void crearCuarto(Cuarto cuarto)
    {
        this.listaCuarto.add(cuarto);
    }
    
    public void crearPuerta(String cu1, String cu2)
    {
        Cuarto cuarto1 = buscarPuerta(cu1);
        Cuarto cuarto2 = buscarPuerta(cu2);
        if(cu1 != null && cu2 != null)
        {
            cuarto1.addPuerta(cuarto2);
            cuarto2.addPuerta(cuarto1);
            Puerta pu = new Puerta(cuarto1,cuarto2);
            this.listaPuerta.add(pu);
        }
    }
    
    public Cuarto buscarPuerta(String cuarto)
    {
        Cuarto aux = null;
        for (int i = 0; i < listaCuarto.size(); i++) 
        {
            if((cuarto).equals(listaCuarto.get(i).getCuarto()))
            {
                return listaCuarto.get(i);
            }
        }
        return aux;
    }
}
