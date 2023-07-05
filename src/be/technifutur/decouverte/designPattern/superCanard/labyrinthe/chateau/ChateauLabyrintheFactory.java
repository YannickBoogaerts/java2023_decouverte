package be.technifutur.decouverte.designPattern.superCanard.labyrinthe.chateau;

import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.*;

import java.util.List;

public class ChateauLabyrintheFactory implements ElementLabyrintheFactory {
    @Override
    public Mur createMur() {
        return new MurChateau();
        }

    @Override
    public Piece createPiece() {
        return new PieceChateau();
    }

    @Override
    public Porte createPorte() {
        return new PorteChateau();
    }
}
