package be.technifutur.decouverte.designPattern.superCanard.adaptateur;

import be.technifutur.decouverte.designPattern.superCanard.strategie.Canard;

public class CanardAnimalAdapteur implements Animal{
    private Canard canard;

    public CanardAnimalAdapteur(Canard canard) {
        this.canard = canard;
    }

    @Override
    public void print() {
        canard.affiche();
    }

    @Override
    public String cri() {
        return canard.getComportementCancan().cancanner();
    }
}
