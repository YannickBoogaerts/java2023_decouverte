package be.technifutur.decouverte.designPattern.superCanard.builder;

import be.technifutur.decouverte.designPattern.superCanard.adaptateur.Animal;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.*;

import java.util.Optional;
import java.util.function.Supplier;

public class ObjectLabyrintheBuilder implements LabyrintheBuilder {
    private final ElementLabyrintheFactory factory;
    private final Supplier<Animal> animalSupplier;
    private LabyrintheMap labyrinthe;


    public ObjectLabyrintheBuilder(ElementLabyrintheFactory factory, Supplier<Animal> animalSupplier) {
        this.factory = factory;
        this.animalSupplier = animalSupplier;
    }


    @Override
    public void start() {
        this.labyrinthe = new LabyrintheMap();
    }

    @Override
    public void addMur(int lig, int col) {
        this.labyrinthe.addElement(new Position2D(lig,col),factory.createMur());
    }

    @Override
    public void addPiece(int lig, int col) {
        this.labyrinthe.addElement(new Position2D(lig,col),factory.createPiece());
    }

    @Override
    public void addPorte(int lig, int col) {
        this.labyrinthe.addElement(new Position2D(lig,col),factory.createPorte());
    }

    @Override
    public void addAnimal(int lig, int col) {
        Piece piece = factory.createPiece();
        piece.setAnimal(Optional.of(animalSupplier.get()));
        this.labyrinthe.addElement(new Position2D(lig,col), piece);
    }

    @Override
    public void setEntree(int lig, int col) {
        Porte porte = factory.createPorte();
        Position2D pos = new Position2D(lig, col);
        this.labyrinthe.addElement(pos, porte);
        porte.open();
        labyrinthe.setEntree(pos);
    }

    @Override
    public void end() {

    }

    public LabyrintheMap getLabyrinthe() {
        return this.labyrinthe;
    }
}
