package be.technifutur.decouverte.designPattern.superCanard.builder;

import java.util.SortedMap;
import java.util.TreeMap;

public class StringLabyrintheBuilder implements LabyrintheBuilder{

    private SortedMap<Integer,SortedMap<Integer,Character>> charMap;
    private String result;

    @Override
    public void start() {
        charMap = new TreeMap<>();
    }

    @Override
    public void addMur(int lig, int col) {
        this.add('x',lig,col);
    }

    private void add(char c, int lig, int col) {
        SortedMap<Integer, Character> map = charMap.get(lig);
        if(map == null){
            map = new TreeMap<>();
            charMap.put(lig,map);
        }
        map.put(col,c);

    }

    @Override
    public void addPiece(int lig, int col) {
        this.add('.',lig,col);
    }

    @Override
    public void addPorte(int lig, int col) {
        this.add('|',lig,col);
    }

    @Override
    public void addAnimal(int lig, int col) {
        this.add('a',lig,col);
    }

    @Override
    public void setEntree(int lig, int col) {
        this.add('e',lig,col);
    }

    @Override
    public void end() {
        StringBuilder stringBuilder = new StringBuilder();
        for(SortedMap<Integer,Character> map: charMap.values()){
            for(char c: map.values()){
                stringBuilder.append(c);
            }
            stringBuilder.append('\n');
        }
        this.result = stringBuilder.toString();
    }

    public String getTexte() {
        return this.result;
    }
}
