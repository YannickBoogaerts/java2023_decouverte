package be.technifutur.decouverte.designPattern.superCanard.builder;

import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.*;

public class LabyrintheObjectReader {
    public void read(LabyrintheMap labyrintheMap, StringLabyrintheBuilder builder) {
        builder.start();
        for (Position pos: labyrintheMap.getSetPosition()){

            ElementLabyrinthe element = labyrintheMap.getElement(pos);
            if (element instanceof Mur) {
                builder.addMur(pos.getLine(), pos.getColumn());
            }else if (element instanceof Porte) {
                builder.addPorte(pos.getLine(), pos.getColumn());
            }else if (element instanceof Piece p) {
                if(p.getAnimal().isPresent()){
                    builder.addAnimal(pos.getLine(), pos.getColumn());
                }else {
                    builder.addPiece(pos.getLine(), pos.getColumn());
                }
            }
        }
        Position entre = labyrintheMap.getEntre();
        builder.setEntree(entre.getLine(),entre.getColumn());
        builder.end();

    }
}
