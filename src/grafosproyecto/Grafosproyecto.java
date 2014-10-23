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

    static Plano plano = new  Plano();
    static Plano planoConEx = new Plano();
    public static void llenadoPlano(Plano pla,boolean conExterior)
    {
        pla.crearCuarto(new Cuarto("1"));
        pla.crearCuarto(new Cuarto("2"));
        pla.crearCuarto(new Cuarto("3"));
        pla.crearCuarto(new Cuarto("4"));
        pla.crearCuarto(new Cuarto("5"));
        
        pla.crearPuerta("1", "2");
        pla.crearPuerta("1", "5");
        
        pla.crearPuerta("2", "3");
        pla.crearPuerta("2", "5");
        
        pla.crearPuerta("3", "4");
        pla.crearPuerta("3", "5");
        
        pla.crearPuerta("4", "5");
        
        if(conExterior){
            pla.crearCuarto(new Cuarto("0"));
            pla.crearPuerta("0", "5");
            pla.crearPuerta("0", "2");
            pla.crearPuerta("0", "4");
        
        }
        
    }
    public static void main(String[] args) {
        llenadoPlano(plano, false);
        llenadoPlano(planoConEx, true);
        plano.mostrarPlano();
        RecorridoEuler euler = new RecorridoEuler();
        RecorridoEuler eulerConEx = new RecorridoEuler();
        euler.recorridoEureliano(" ", plano, plano.listaCuarto.get(0), plano.listaPuerta.get(0));
        CantidadComponentes planoSinExterior= new CantidadComponentes();
        planoConEx.mostrarPlano();
        plano.euleriano = euler.esEureliano(plano);
        plano.cantidadComponentes = planoSinExterior.calcularCantidad(plano);
        plano.conexo= planoSinExterior.esConexo(plano.cantidadComponentes);
        eulerConEx.esEureliano(planoConEx);
        System.out.println(plano.euleriano);
        System.out.println(plano.cantidadComponentes);
        System.out.println(plano.conexo);
    }
}