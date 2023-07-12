package be.technifutur.decouverte.designPattern.superCanard.decorator;

import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.ElementLabyrinthe;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.Labyrinthe;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.Piece;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.Position;

import java.util.Set;

public class CountLabyrinthe implements Labyrinthe {
    private final Labyrinthe parent;

    public CountLabyrinthe(Labyrinthe parent) {
        this.parent = parent;
    }

    @Override
    public ElementLabyrinthe getElement(Position pos) {
        return parent.getElement(pos);
    }

    @Override
    public Set<Position> getSetPosition() {
        return parent.getSetPosition();
    }

    @Override
    public Position getEntre() {
        return parent.getEntre();
    }

    public Labyrinthe getParent() {
        return parent;
    }

    public long animalCount() {
        return parent.getSetPosition().stream()
                .map(p->parent.getElement(p))
                .filter(e-> e instanceof Piece)
                .map(e -> (Piece)e)
                .filter(p->p.getAnimal().isPresent())
                .count();
    }
}
