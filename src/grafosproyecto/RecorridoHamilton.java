
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
            cu.visitado=true;
            hamiltonRecursivo(cadena, cu,cuAdy);
            cu.visitado=false;
        }
    }

    private void hamiltonRecursivo(String cadena, Cuarto cu, Cuarto cuAdy) {
        cadena=cadena.concat(cuAdy.dato);
        cuAdy.visitado=true;
        if(cuartosPorVisitar(cuAdy).isEmpty()){
            //System.out.println(cuartosPorVisitar(cuAdy).size());
            if(cuartosPorVisitar().isEmpty()){
                //System.out.println(cuartosPorVisitar().size());
                if(esCicloHamiltoniano(cadena,cuAdy))
                System.out.println(cadena);
                System.out.println(cadena.charAt(0));
            }
        }else{
            ArrayList<Cuarto> cuartosSig = cuartosPorVisitar(cuAdy);
            for (int i = 0; i < cuartosSig.size(); i++) {
                Cuarto cuSig= cuartosSig.get(i);
                hamiltonRecursivo(cadena, cuAdy, cuSig);
            }
        }
        cuAdy.visitado=false;
        
    }

    private ArrayList<Cuarto> cuartosPorVisitar() {
        ArrayList<Cuarto> res = new ArrayList<>();
        for (int i = 0; i < plano.listaCuarto.size(); i++) {
            if(plano.listaCuarto.get(i).visitado == false)
                res.add(plano.listaCuarto.get(i));
            //System.out.println(plano.listaCuarto.get(i).visitado + plano.listaCuarto.get(i).dato);
        }
        return res;
    }

    private ArrayList<Cuarto> cuartosPorVisitar(Cuarto cuAdy) {
        ArrayList<Cuarto> res = new ArrayList<>();
        for (int i = 0; i < cuAdy.cuarto.size(); i++) {
            if(cuAdy.cuarto.get(i).visitado==false)
                res.add(cuAdy.cuarto.get(i));
            //System.out.println(plano.listaCuarto.get(i).visitado);
        }
        return res;
    }

    private boolean esCicloHamiltoniano(String cadena, Cuarto cuAdy) {
        boolean res = false;
        char inicio = (cadena.charAt(0));
        for (int i = 0; i < cuAdy.cuarto.size(); i++) {
            if(cuAdy.cuarto.get(i).dato.equals(String(inicio)))
        }
    }

}