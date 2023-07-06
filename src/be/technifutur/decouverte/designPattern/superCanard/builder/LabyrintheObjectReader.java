package be.technifutur.decouverte.designPattern.superCanard.builder;

import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.*;

public class LabyrintheObjectReader {
    public void read(LabyrintheMap labyrintheMap, StringLabyrintheBuilder builder) {
        builder.start();
        for (Position pos: labyrintheMap.getSetPosition()){
            switch (labyrintheMap.getElement(pos)){
                case Mur m -> builder.addMur(pos.getLine(), pos.getColumn());
                case Piece p ->{
                    if(p.getAnimal().isPresent()){
                        builder.addAnimal(pos.getLine(), pos.getColumn());
                    }else {
                        builder.addPiece(pos.getLine(), pos.getColumn());
                    }
                }
                case Porte o -> builder.addPorte(pos.getLine(), pos.getColumn());
                default -> throw new IllegalStateException("Unexpected value: " + labyrintheMap.getElement(pos));
            }
        }
        Position entre = labyrintheMap.getEntre();
        builder.setEntree(entre.getLine(),entre.getColumn());
        builder.end();

    }
}
