package be.technifutur.decouverte.designPattern.superCanard.builder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LabyrintheFileReader {

    public void read(String fileName, LabyrintheBuilder builder){
        File file = new File(fileName);
        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
