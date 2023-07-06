package be.technifutur.decouverte.designPattern.superCanard.builder;

import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.ElementLabyrintheFactory;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.LabyrintheMap;

public class ObjectLabyrintheBuilder implements LabyrintheBuilder{
    private final ElementLabyrintheFactory factory;


    public ObjectLabyrintheBuilder(ElementLabyrintheFactory factory) {
        this.factory = factory;
    }

    @Override
    public void start() {

    }

    @Override
    public void addMur(int lig, int col) {

    }

    @Override
    public void addPiece(int lig, int col) {

    }

    @Override
    public void addPorte(int lig, int col) {

    }

    @Override
    public void end() {

    }

    public LabyrintheMap getLabyrinthe() {
        return null;
    }
}
