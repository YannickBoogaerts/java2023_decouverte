package be.technifutur.decouverte.designPattern.heritageComposition.estUn;

import be.technifutur.decouverte.texte.Main;

public class TestHeritage {

    public static void main(String[] args) {
        Options op = new Options("toto","dédé","louis");
        Multilication mult = new Multilication();

        op.affiche();
        System.out.println();
        mult.affiche();
    }
}

class IdGenerator{
    private int cpt = 0;

    public int getId(){
        return cpt++;
    }
}

class Options extends IdGenerator{
    private String[] options;

    public Options(String... options){
        this.options = options;
    }

    public void affiche(){
        for(String opt:options){
            System.out.printf(" %s : %s%n",getId(),opt);
        }
    }
}

class Multilication extends IdGenerator{

    public void affiche(){
        int val = getId();
        System.out.printf(" %s x 5 = %s%n",val, val*5);
    }
}
