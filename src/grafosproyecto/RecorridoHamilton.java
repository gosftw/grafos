
package grafosproyecto;

import java.util.ArrayList;

public class RecorridoHamilton {
    public Plano plano;
    
    public RecorridoHamilton(Plano pla){
        this.plano= pla;
    }

    void Hamilton() {
        for (int j = 0; j < plano.listaCuarto.size(); j++) {
            plano.listaCuarto.get(j).visitado=false;
        }
        System.out.println("El Grafo contiene caminos Hamiltonianos");
        for (int i = 0; i < plano.listaCuarto.size(); i++) {
            Cuarto cu= plano.listaCuarto.get(i);
            recorridosH(cu);
        }
        
    }

    private void recorridosH(Cuarto cu) {        
        for (int i = 0; i < cu.cantidadCuarto(); i++) {
            Cuarto cuAdy = cu.cuarto.get(i);
            String cadena = new String();
            cadena = cadena.concat(cu.dato);
            hamiltonRecursivo(cu,cuAdy);
        }
    }

    private void hamiltonRecursivo(Cuarto cu, Cuarto cuAdy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    