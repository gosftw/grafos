
package grafosproyecto;

import java.util.ArrayList;

public class RecorridoEuler {
    Plano plano;
    public RecorridoEuler(){
    }
    public int esEureliano(Plano plano) {
        int verticesGradoImpar = 0;
        for (int i = 0; i < plano.listaCuarto.size(); i++) {
            Cuarto cu = plano.listaCuarto.get(i);
            if (cu. cantidadCuarto()%2 != 0){
                verticesGradoImpar ++;
                plano.listaCuarto.get(i).gradoImpar = true;
            }            
        }
        if(verticesGradoImpar == 2){
            return 0;
        }
        else 
            if(verticesGradoImpar == 0){
                return 1;
            }
            else
                return -1;
    }
    public ArrayList generarCaminos(){
        ArrayList<String> res = new ArrayList<String> ();
            
        return res;
    }
    public String recorridoEureliano(String res, Plano p, Cuarto cu, Puerta pu){
        res = res.concat(cu.dato);
        pu.visitado = true;
        if(puertasSinUsar(p)==0 || puertasSinUsar(p, cu)== 0){
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

    
    private int puertasSinUsar(Plano p){
        int res = 0;
        for (int i = 0; i < p.listaPuerta.size(); i++) {
            if (p.listaPuerta.get(i).visitado == false)
                res ++;            
        }
        return res;
    }
    private int puertasSinUsar(Plano p, Cuarto cu){
        int res = 0;
        for (int i = 0; i < p.listaPuerta.size(); i++) {
            Puerta pu = p.listaPuerta.get(i);
            if (pu.getCuarto1().equals(cu.getCuarto()) || pu.getCuarto2().equals(cu.getCuarto()))
                if (p.listaPuerta.get(i).visitado == false)
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
