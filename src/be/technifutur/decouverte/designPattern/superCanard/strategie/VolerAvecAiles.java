package be.technifutur.decouverte.designPattern.superCanard.strategie;

public class VolerAvecAiles implements ComportementVol {
    @Override
    public void voler() {
        System.out.println("je vole avec des ailes");
    }
}
