
package grafosproyecto;

import java.util.ArrayList;

public class RecorridoEuler {
    public Plano plano;
    public RecorridoEuler(Plano p){
        this.plano= p;
    }
    public ArrayList esEureliano(Plano plano) {
        ArrayList<Cuarto> verticesGradoImpar = new ArrayList<> ();
        for (int i = 0; i < plano.listaCuarto.size(); i++) {
            Cuarto cu = plano.listaCuarto.get(i);
            if (cu. cantidadCuarto()%2 != 0){
                verticesGradoImpar.add(cu);
                cu.gradoImpar = true;
            }
        }
        if(verticesGradoImpar.size() == 2){
            System.out.println("El grafo contiene Caminos eurelianos");
        }
        else 
            if(verticesGradoImpar.isEmpty()){
                System.out.println("El grafo contiene Ciclos eurelianos");
            }
            else
                System.out.println("El grafo no es Eureliano");
        return verticesGradoImpar;
    }
    void Euler() {
        
        if(plano.euleriano.size() == 2){
            for (int i = 0; i < 2; i++) {
                Cuarto cu= plano.euleriano.get(i);
                recorridosE(cu);                
            }
        }else{
            for (int i = 0; i < plano.listaCuarto.size(); i++) {
                Cuarto cu1= plano.listaCuarto.get(i);
                recorridosE(cu1);                
            }
        }        
    }    
    private void recorridosE(Cuarto cu){
        
        for (int i = 0; i < cu.cuarto.size(); i++) {
            Cuarto cuartoAdyacente = cu.cuarto.get(i);
            Puerta pu = buscarPuerta(cu, cuartoAdyacente);
            if (pu!=null){
                String cadena = new String();
                cadena = cadena.concat(cu.dato);
                eulerRecursivo(cadena, cu, cuartoAdyacente, pu);
            }
        }
    }
    private void eulerRecursivo(String cadena, Cuarto cu, Cuarto cuAdy, Puerta pu) {
        
        cadena= cadena.concat(cuAdy.dato);
        pu.visitado=true;
        if(puertasSinUsar(cuAdy).isEmpty()){
            if(puertasSinUsar().isEmpty()){
                System.out.println(cadena);
                pu.visitado=false;
            }
                
        }else{
            if(puertasSinUsar(cuAdy).size() == 1){
                Cuarto cuSiguiente=buscarCuarto(cuAdy);
                Puerta puSiguiente=buscarPuerta(cuAdy,cuSiguiente);
                eulerRecursivo(cadena, cuAdy, cuSiguiente, puSiguiente);
                //pu.visitado=false;
            }else{
                ArrayList<Cuarto> cuartosSig = llenarCuartosAdyacentes(puertasSinUsar(cuAdy),cuAdy);
                for (int i = 0; i < cuartosSig.size(); i++) {
                    Cuarto cuSig = cuartosSig.get(i);
                    Puerta puSig = buscarPuerta(cuAdy, cuSig);
                    eulerRecursivo(cadena, cuAdy, cuSig, puSig);
                    //pu.visitado=false;
                }
            }
            
        }
        pu.visitado=false;
        //return;
    }
    private ArrayList<Cuarto> llenarCuartosAdyacentes(ArrayList<Puerta> puertasSinUsar, Cuarto cu) {
        ArrayList<Cuarto> res= new ArrayList<> ();
            for (int i = 0; i < puertasSinUsar.size(); i++) {
                Puerta pu = puertasSinUsar.get(i);
                if (pu.cuarto1.equals(cu)){
                    res.add(pu.cuarto2);
                }else res.add(pu.cuarto1);
            
        }
        return res;
    }
    private Cuarto buscarCuarto(Cuarto cu) {
        Cuarto res = null;
        for (int i = 0; i < cu.cuarto.size(); i++) {
            Cuarto cu2 = cu.cuarto.get(i);
            for (int j = 0; j < plano.listaPuerta.size(); j++) {
                Puerta pu = plano.listaPuerta.get(j);
                if((pu.cuarto1.equals(cu) && pu.cuarto2.equals(cu2))||(pu.cuarto1.equals(cu2) && pu.cuarto2.equals(cu))){
                    if(pu.visitado == false) return cu2;
                }
                
            }
        }
        return res;
    }
    
    private Puerta buscarPuerta(Cuarto cu, Cuarto c) {
        Puerta res = null;
        for (int i = 0; i < plano.listaPuerta.size(); i++) {
            Cuarto cu1 = plano.listaPuerta.get(i).cuarto1;
            Cuarto cu2 = plano.listaPuerta.get(i).cuarto2;
            if(cu1.equals(cu)&&cu2.equals(c) || cu2.equals(cu)&&cu1.equals(c)){
                if(plano.listaPuerta.get(i).visitado == false)
                    return plano.listaPuerta.get(i);
            }
        }
        return res;
    }

    
   /* public String recorridoEureliano(String res, Plano p, Cuarto cu, Puerta pu){
        res = res.concat(cu.dato);
        pu.visitado = true;
        if(puertasSinUsar().size()==0 || puertasSinUsar(cu).size()== 0){
            pu.visitado =false;
            System.out.println(res);
            return res;
        }else
        {
            Puerta puSig = getSigPuerta(p, cu);
            Cuarto cuSig = getSigCuarto(cu, puSig);
            if (puSig!=null){
                recorridoEureliano(res, p, cuSig, puSig);
            }
            pu.visitado =false;
        }
        
        
        return res;
    }*/

    
    private ArrayList<Puerta> puertasSinUsar(){
        ArrayList<Puerta> res = new ArrayList<> ();
        for (int i = 0; i < plano.listaPuerta.size(); i++) {
            if (plano.listaPuerta.get(i).visitado == false)
                res.add(plano.listaPuerta.get(i));            
        }
        return res;
    }
    private ArrayList<Puerta> puertasSinUsar(Cuarto cu){
        ArrayList<Puerta> res = new ArrayList<> ();
        for (int i = 0; i < plano.listaPuerta.size(); i++) {
            Puerta pu = plano.listaPuerta.get(i);
            if (pu.getCuarto1().equals(cu.getCuarto()) || pu.getCuarto2().equals(cu.getCuarto()))
                if (plano.listaPuerta.get(i).visitado == false)
                    res.add(pu);            
        }
        return res;
    }

    /*private Puerta getSigPuerta(Plano p, Cuarto cu) {
        Puerta res= null;
            for (int i = 0; i < p.listaPuerta.size(); i++) {
            Puerta pu = p.listaPuerta.get(i);
            if (pu.getCuarto1().equals(cu.getCuarto())){
                if (p.listaPuerta.get(i).visitado == false)
                    return pu;
            }else 
                if (pu.getCuarto2().equals(cu.getCuarto())){
                    if (p.listaPuerta.get(i).visitado == false)
                        return pu;
                }
        }
        return res;
    }

    private Cuarto getSigCuarto(Cuarto cu, Puerta puSig) {
            if (puSig.cuarto1.equals(cu)){
                return puSig.cuarto2;
            }else return puSig.cuarto1;
    }  */  

    

    

    
    
}
