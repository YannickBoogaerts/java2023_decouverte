package be.technifutur.decouverte.designPattern.superCanard.strategie;

public class NePasVoler implements ComportementVol {
    @Override
    public void voler() {
        System.out.println("je ne vole pas");
    }
}
