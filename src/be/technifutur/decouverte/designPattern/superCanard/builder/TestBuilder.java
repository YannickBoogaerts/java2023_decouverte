package be.technifutur.decouverte.designPattern.superCanard.builder;

import be.technifutur.decouverte.designPattern.superCanard.abstractfactory.CanardFactory;
import be.technifutur.decouverte.designPattern.superCanard.abstractfactory.MaFactory;
import be.technifutur.decouverte.designPattern.superCanard.adaptateur.Animal;
import be.technifutur.decouverte.designPattern.superCanard.adaptateur.CanardAnimalAdapteur;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.ElementLabyrintheFactory;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.LabyrintheMap;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.Position;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.chateau.ChateauLabyrintheFactory;
import be.technifutur.decouverte.designPattern.superCanard.strategie.Canard;
import be.technifutur.decouverte.designPattern.superCanard.strategie.Colvert;

import java.util.Random;

public class TestBuilder {

    public static void main(String[] args) {
        ElementLabyrintheFactory factory = new ChateauLabyrintheFactory();
        CanardFactory canardFactory = new MaFactory();

        ObjectLabyrintheBuilder builder = new ObjectLabyrintheBuilder(factory,TestBuilder::getAnimal);
        LabyrintheFileReader reader = new LabyrintheFileReader();
        reader.read("monLaby.txt",builder);
        LabyrintheMap labyrintheMap = builder.getLabyrinthe();

        for (Position p : labyrintheMap.getSetPosition()) {
            affichevoisin(labyrintheMap, p);
        }

        StringLabyrintheBuilder builder1 = new StringLabyrintheBuilder();
        new LabyrintheObjectReader().read(labyrintheMap,builder1);
        System.out.println(builder1.getTexte());
    }
    private static void affichevoisin(LabyrintheMap labyrintheMap, Position entre) {
        System.out.println(entre + " " + labyrintheMap.getElement(entre).getDescription());
        for (Position p : entre.getVoisin()) {
            System.out.print(p);
            System.out.println(labyrintheMap.getElement(p).getDescription());
        }
        System.out.println("------------------");
    }

    static CanardFactory canardFactory = new MaFactory();
    private static Animal getAnimal(){
        Random rand = new Random();
        Canard canard = switch(rand.nextInt(4)){
            case 0 -> canardFactory.getCanardPlastique();
            case 1 -> canardFactory.getColvert();
            case 2 -> canardFactory.getLeurre();
            case 3 -> canardFactory.getMandarin();
            default -> throw new IllegalStateException("Unexpected value: " + rand.nextInt(4));
        };
        return new CanardAnimalAdapteur(canard);
    }
}
