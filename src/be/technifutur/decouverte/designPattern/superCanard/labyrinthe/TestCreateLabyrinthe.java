package be.technifutur.decouverte.designPattern.superCanard.labyrinthe;

import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.chateau.ChateauLabyrintheFactory;

public class TestCreateLabyrinthe {

    public static void main(String[] args) {
        LabyrintheMap labyrintheMap = new LabyrintheMap();
        ChateauLabyrintheFactory factory = new ChateauLabyrintheFactory();
        labyrintheMap.setEntree(new Position2D(2, 1));
        Position pos = new Position2D(1, 1);
        ElementLabyrinthe elem = factory.createMur();
        labyrintheMap.addElement(pos, elem);
        labyrintheMap.addElement(new Position2D(1, 2), factory.createMur());
        labyrintheMap.addElement(new Position2D(1, 3), factory.createMur());
        labyrintheMap.addElement(new Position2D(2, 1), factory.createPiece());
        labyrintheMap.addElement(new Position2D(2, 2), factory.createPiece());
        labyrintheMap.addElement(new Position2D(2, 3), factory.createPorte());
        labyrintheMap.addElement(new Position2D(3, 1), factory.createMur());
        labyrintheMap.addElement(new Position2D(3, 2), factory.createMur());
        labyrintheMap.addElement(new Position2D(3, 3), factory.createMur());

        for (Position p : labyrintheMap.getEntre().getVoisin()){
            System.out.println("position d'entrée");
            affichevoisin(labyrintheMap,p);
        }
        for (Position p : labyrintheMap.getSetPosition()) {
            affichevoisin(labyrintheMap, p);
        }

    }

    private static void affichevoisin(LabyrintheMap labyrintheMap, Position entre) {
        System.out.println(entre + " " + labyrintheMap.getElement(entre).getDescription());
        for (Position p : entre.getVoisin()) {
            System.out.print(p);
            System.out.println(labyrintheMap.getElement(p).getDescription());
        }
        System.out.println("------------------");
    }
}
