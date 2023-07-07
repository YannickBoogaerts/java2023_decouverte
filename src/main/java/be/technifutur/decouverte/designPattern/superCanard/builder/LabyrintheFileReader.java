package be.technifutur.decouverte.designPattern.superCanard.builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LabyrintheFileReader {

    public void read(String fileName, LabyrintheBuilder builder){
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){
            int lig = 0;
            builder.start();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                for (int col = 0; col < line.length(); col++) {
                    switch (line.charAt(col)){
                        case 'x' -> builder.addMur(lig,col);
                        case '|' -> builder.addPorte(lig,col);
                        case '.' -> builder.addPiece(lig,col);
                        case 'e'->builder.setEntree(lig,col);
                        case 'a'->builder.addAnimal(lig,col);
                    }
                }
                lig++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
