/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafosproyecto;

import java.util.ArrayList;

/**
 *
 * @author HP CORE i3
 */
public class Grafosproyecto {

    static Plano plano;
    
    public static void llenadoPlano()
    {
        plano = new Plano();
        
        plano.crearCuarto(new Cuarto("1"));
        plano.crearCuarto(new Cuarto("2"));
        plano.crearCuarto(new Cuarto("3"));
        plano.crearCuarto(new Cuarto("4"));
        plano.crearCuarto(new Cuarto("5"));
        
        plano.crearPuerta("1", "2");
        plano.crearPuerta("1", "5");
        
        plano.crearPuerta("2", "3");
        plano.crearPuerta("2", "5");
        
        plano.crearPuerta("3", "4");
        plano.crearPuerta("3", "5");
        
    }
    public static void main(String[] args) {
        llenadoPlano();
        
        if (esEureliano(plano)){
            System.out.println("Si es Eureliano");;
        }
        else System.out.println("No es Eureliano");
    }

    private static boolean esEureliano(Plano plano) {
        int verticesGradoImpar = 0;
        for (int i = 0; i < plano.listaCuarto.size(); i++) {
            Cuarto cu = plano.listaCuarto.get(i);
            if (cu.cantidadCuarto()%2 != 0){
                verticesGradoImpar ++;
            }            
        }
        if(verticesGradoImpar > 2){
            return false;
        }
        else
        return true;
    }
    private static boolean esConexo(Plano plano){
        boolean res = false;
        Plano auxPlano = plano;
        Cuarto cu = auxPlano.listaCuarto.get(1);
        ArrayList listaCuarto = cu.cuarto;           
        //res = dfs(auxPlano, cu);
        return res;
    }
    
    private static boolean todosCuartosVisitados (ArrayList<Cuarto> cuarto){
        boolean res = true;
        for (int i = 0; i < cuarto.size(); i++) {
            Cuarto cu = cuarto.get(i);
            if (cu.visitado == false){
                return false;
            }
        }
        return res;
    }
    /*private static boolean dfs(Plano plano ,Cuarto cuarto){
        cuarto.visitado = true;
        if(todosCuartosVisitados(listaCuarto)){
            return true;
        }else 
        return false;
    }*/
}
