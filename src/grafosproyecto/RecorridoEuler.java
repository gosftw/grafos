
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
    void Euler(Plano plano) {
        ArrayList<String> arrayRes = new ArrayList<> ();
        if(plano.euleriano.size() == 2){
            for (int i = 0; i < 2; i++) {
                Cuarto cu= plano.euleriano.get(i);
                arrayRes= recorridosE(arrayRes, cu);
                for (int j = 0; j < arrayRes.size(); j++) {
                    System.out.println(arrayRes.get(j));            
                }
            }
        }else{
            for (int i = 0; i < plano.listaCuarto.size(); i++) {
                Cuarto cu1= plano.listaCuarto.get(i);
                arrayRes= recorridosE(arrayRes, cu1);
                for (int j = 0; j < arrayRes.size(); j++) {
                    System.out.println(arrayRes.get(j));            
                }
            }
        }
        
    }
    
    private ArrayList recorridosE(ArrayList res ,Cuarto cu) {
        String cadena = new String();
        for (int i = 0; i < cu.cuarto.size(); i++) {
            Cuarto cuartoAdyacente = cu.cuarto.get(i);
            Puerta pu = buscarPuerta(cu, cuartoAdyacente);
            if (pu!=null){
                cadena = cadena.concat(cu.dato);
                return eulerRecursivo(res, cadena, cu, cuartoAdyacente, pu);
            }
        }
        return res;
    }
    private ArrayList eulerRecursivo(ArrayList res,String cadena, Cuarto cu, Cuarto cuartoAdyacente, Puerta pu) {
        pu.visitado = true;
        cadena= cadena.concat(cuartoAdyacente.dato);
        if(puertasSinUsar(cuartoAdyacente)== 0){
            if(puertasSinUsar()==0){
                res.add(cadena);
            }
                
        }else{
            puSiguiente
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

    
    public String recorridoEureliano(String res, Plano p, Cuarto cu, Puerta pu){
        res = res.concat(cu.dato);
        pu.visitado = true;
        if(puertasSinUsar()==0 || puertasSinUsar(cu)== 0){
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
    }

    
    private int puertasSinUsar(){
        int res = 0;
        for (int i = 0; i < plano.listaPuerta.size(); i++) {
            if (plano.listaPuerta.get(i).visitado == false)
                res ++;            
        }
        return res;
    }
    private int puertasSinUsar(Cuarto cu){
        int res = 0;
        for (int i = 0; i < plano.listaPuerta.size(); i++) {
            Puerta pu = plano.listaPuerta.get(i);
            if (pu.getCuarto1().equals(cu.getCuarto()) || pu.getCuarto2().equals(cu.getCuarto()))
                if (plano.listaPuerta.get(i).visitado == false)
                    res ++;            
        }
        return res;
    }

    private Puerta getSigPuerta(Plano p, Cuarto cu) {
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
    }    

    
    
}
