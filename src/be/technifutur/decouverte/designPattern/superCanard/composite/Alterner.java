package be.technifutur.decouverte.designPattern.superCanard.composite;

import be.technifutur.decouverte.designPattern.superCanard.strategie.ComportementCancan;

public class Alterner implements ComportementCancan {
    private final ComportementCancan cri1;
    private final ComportementCancan cri2;
    private boolean first = true;

    public Alterner(ComportementCancan cri1, ComportementCancan cri2) {
        this.cri1 = cri1;
        this.cri2 = cri2;
    }

    @Override
    public void cancanner() {
        if(this.first){
            cri1.cancanner();
        }else{
            cri2.cancanner();
        }
        first= ! first;
    }
}
