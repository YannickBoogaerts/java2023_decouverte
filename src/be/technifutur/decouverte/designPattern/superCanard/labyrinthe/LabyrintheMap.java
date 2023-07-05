package be.technifutur.decouverte.designPattern.superCanard.labyrinthe;

import java.util.*;
import java.util.stream.Collectors;

public class LabyrintheMap implements Labyrinthe{

    private Map<PositionMap,ElementLabyrinthe> map = new HashMap<>();
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
        this.entree = new PositionMap(entree);
        return this;
    }

    public ElementLabyrinthe addElement(Position pos, ElementLabyrinthe element){
        return map.put(new PositionMap(pos),element);
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
                    .map(PositionMap::new)
                    .filter(map::containsKey)
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
