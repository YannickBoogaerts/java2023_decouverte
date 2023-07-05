package be.technifutur.decouverte.designPattern.superCanard.labyrinthe;

import java.util.*;

public class LabyrintheMap implements Labyrinthe{

    private Map<PositionMap,ElementLabyrinthe> map = new HashMap<>();
    private Map<Position,PositionMap> positionDico = new HashMap<>();
    private PositionMap entree;

    @Override
    public ElementLabyrinthe getElement(Position pos) {
        return map.get(pos);
    }

    @Override
    public Set<Position> getSetPosition() {
        return Collections.unmodifiableSet(map.keySet());
    }

    @Override
    public Position getEntre() {
        return this.entree;
    }

    public LabyrintheMap setEntree(Position entree) {
        this.entree = this.positionDico.get(entree);
        return this;
    }

    public ElementLabyrinthe addElement(Position pos, ElementLabyrinthe element){
        LabyrintheMap.PositionMap key = new PositionMap(pos);
        this.positionDico.put(pos,key);
        return map.put(key,element);
    }

    private class PositionMap implements Position{

        private Position position;

        public PositionMap(Position position) {
            this.position = position;
        }

        @Override
        public List<PositionMap> getVoisin() {
            return position.getVoisin()
                    .stream()
                    .map(positionDico::get)
                    .filter(p->p!=null)
                    .toList();
        }

        @Override
        public String toString() {
            return "PositionMap{" +
                    "position=" + position +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PositionMap that = (PositionMap) o;

            return Objects.equals(position, that.position);
        }

        @Override
        public int hashCode() {
            return position != null ? position.hashCode() : 0;
        }
    }
}
