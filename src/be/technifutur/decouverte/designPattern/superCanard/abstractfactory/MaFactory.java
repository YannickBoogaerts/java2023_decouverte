package be.technifutur.decouverte.designPattern.superCanard.abstractfactory;

import be.technifutur.decouverte.designPattern.superCanard.strategie.Canard;
import be.technifutur.decouverte.designPattern.superCanard.strategie.ComportementCancan;
import be.technifutur.decouverte.designPattern.superCanard.strategie.ComportementVol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaFactory extends AbstractCanardFactory{
    @Override
    public List<Canard> getListCanard() {
        return Collections.unmodifiableList(Arrays.asList(
                getCanardPlastique(),
                getColvert(),
                getColvert(),
                getCanardPlastique(),
                getLeurre(),
                getMandarin().setComportementCancan(getcriAlarme())
        ));
    }

    @Override
    public Canard getMandarin() {
        return null;
    }

    @Override
    public Canard getColvert() {
        return null;
    }

    @Override
    public Canard getCanardPlastique() {
        return null;
    }

    @Override
    public Canard getLeurre() {
        return null;
    }

    @Override
    public ComportementCancan getCancan() {
        return null;
    }

    @Override
    public ComportementCancan getCoincoin() {
        return null;
    }

    @Override
    public ComportementCancan getMuet() {
        return null;
    }

    @Override
    public ComportementCancan getcriAlarme() {
        return null;
    }

    @Override
    public ComportementVol getVolerAvecAile() {
        return null;
    }

    @Override
    public ComportementVol getNePasVoler() {
        return null;
    }
}
