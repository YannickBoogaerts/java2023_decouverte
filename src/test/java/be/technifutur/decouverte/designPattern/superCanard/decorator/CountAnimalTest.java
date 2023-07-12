package be.technifutur.decouverte.designPattern.superCanard.decorator;

import be.technifutur.decouverte.designPattern.superCanard.adaptateur.CanardAnimalAdapteur;
import be.technifutur.decouverte.designPattern.superCanard.builder.LabyrintheFileReader;
import be.technifutur.decouverte.designPattern.superCanard.builder.ObjectLabyrintheBuilder;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.Labyrinthe;
import be.technifutur.decouverte.designPattern.superCanard.labyrinthe.chateau.ChateauLabyrintheFactory;
import be.technifutur.decouverte.designPattern.superCanard.strategie.Colvert;
import org.junit.jupiter.api.*;

public class CountAnimalTest {

    private Labyrinthe labyTest;

    @BeforeEach
    void init(){
        ObjectLabyrintheBuilder builder = new ObjectLabyrintheBuilder(
                new ChateauLabyrintheFactory(),
                () -> new CanardAnimalAdapteur(new Colvert())
        );
        new LabyrintheFileReader().read("monLaby.txt",builder);
        labyTest = builder.getLabyrinthe();
    }

    @DisplayName("Un CountLabyrinthe à un labyrintheParent")
    @Test
    void testLabyrintheParent(TestInfo info){
        CountLabyrinthe labyrinthe = new CountLabyrinthe(labyTest);
        Assertions.assertSame(labyTest, labyrinthe.getParent(),()->info.getDisplayName());
    }

    @DisplayName("CountLabyrinthe.animalCount() retourne le nombre d'Aniamls du parent")
    @Test
    void testAnimalCount(TestInfo info){
        CountLabyrinthe labyrinthe = new CountLabyrinthe(labyTest);
        Assertions.assertEquals(4, labyrinthe.animalCount(),()->info.getDisplayName());
    }

}
