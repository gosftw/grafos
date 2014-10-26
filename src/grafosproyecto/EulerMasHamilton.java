
package grafosproyecto;

class EulerMasHamilton {
    Plano plano;
    
    public EulerMasHamilton(Plano pla){
        this.plano=pla;
    }
    public void cumpleEyH(){
        int contadorGrado1 = 0;
        int contadorGradoMayor = 0;
        for (int i = 0; i < plano.listaCuarto.size(); i++) {
            Cuarto cu = plano.listaCuarto.get(i);
            if(cu.cuarto.size()==1){
                contadorGrado1++;
            }else if(cu.cuarto.size()>2){
                contadorGradoMayor++;
            }
        }
        if ((contadorGrado1 == 2 && contadorGradoMayor == 0) || (contadorGrado1 == 0 && contadorGradoMayor == 0))
            System.out.println("El grafo es Eureliano y Hamiltoniano a la vez, no se realizaran modificaciones");
        else System.out.println("El grafo no es Eureliano y Hamiltoniano a la vez, se realizaran modificaciones");        
    }
    public void modificarGrafo(){
        Plano planoAux=plano;
        
    }
}
