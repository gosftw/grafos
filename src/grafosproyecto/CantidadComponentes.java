
package grafosproyecto;

import java.util.ArrayList;

public class CantidadComponentes {
    
    public CantidadComponentes(){
    }
    
    public int calcularCantidad(Plano plano){
        ArrayList num = new ArrayList();
        for (int k = 0; k < plano.listaCuarto.size(); k++) {
            plano.listaCuarto.get(k).nroComponente=k;
        }
        for (int i = 0; i < plano.listaCuarto.size(); i++) {
            Cuarto cu = plano.listaCuarto.get(i);            
            for (int j = 0; j < cu.cuarto.size(); j++) {
                if (cu.nroComponente < cu.cuarto.get(j).nroComponente){
                    cu.cuarto.get(j).nroComponente = cu.nroComponente;                    
                }            
            }
        }
        for (int l = 0; l < plano.listaCuarto.size(); l++) {
            num.add(plano.listaCuarto.get(l).nroComponente);
        }
        for (int m=0; m< num.size(); m++){
                for (int n=0; n<num.size(); n++){
                    if(n!=m){
                        if(num.get(m)==num.get(n)){
                            num.remove(n);
                            n--;
                        }
                    }
                }
            }
        if(num.size()==1) System.out.println("El grafo es Conexo");
        else System.out.println("El grafo no es Conexo");
        return num.size();
    }
}
