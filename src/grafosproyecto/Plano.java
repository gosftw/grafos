package grafosproyecto;

import java.util.ArrayList;

public class Plano 
{
    public ArrayList<Cuarto> listaCuarto;
    public ArrayList<Puerta> listaPuerta;
    public ArrayList<Cuarto> euleriano;
    public int cantidadComponentes;
    public boolean conexo = false;
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
        Cuarto cuarto1 = buscarCuarto(cu1);
        Cuarto cuarto2 = buscarCuarto(cu2);
        if(cu1 != null && cu2 != null)
        {
            cuarto1.addPuerta(cuarto2);
            cuarto2.addPuerta(cuarto1);
            Puerta pu = new Puerta(cuarto1,cuarto2);
            this.listaPuerta.add(pu);
        }
    }
    
    public Cuarto buscarCuarto(String cuarto)
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
    
    public void eliminarCuarto(String cuarto)
    {
        eliminarPuertas(cuarto);
        for (int i = 0; i < listaCuarto.size(); i++) {
            Cuarto cu=listaCuarto.get(i);
            if ((cuarto.equals(cu.getCuarto())))
            {
                listaCuarto.remove(i);
            }else{
                for (int j = 0; j < cu.cuarto.size(); j++) {
                    if((cuarto.equals(cu.cuarto.get(j).getCuarto()))){
                        cu.cuarto.remove(j);
                    }
                }
            }
        }
    }
    
    private void eliminarPuertas(String cuarto)
    {
        for (int j = 0; j<listaPuerta.size(); j++)
        {
            if((cuarto). equals(listaPuerta.get(j).getCuarto1()))
            {
                listaPuerta.remove(j);
            }else
                if((cuarto).equals(listaPuerta.get(j).getCuarto2()))
                {
                    listaPuerta.remove(j);
                }
        }
    }
    
    public void mostrarPlano ()
    {
        for (int i = 0; i < listaCuarto.size(); i++) 
        {
            Cuarto aux = listaCuarto.get(i);
            System.out.print("["+aux.getCuarto()+"]");
            for (int j = 0; j < aux.cuarto.size(); j++) 
            {
                Cuarto enlace = aux.cuarto.get(j);
                System.out.print(enlace.getCuarto());                
            }
            System.out.println("");
        }
    }
}
