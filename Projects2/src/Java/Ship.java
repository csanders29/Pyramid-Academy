package Java;

import com.google.common.collect.ArrayListMultimap;

public abstract class Ship {
    private int length;
    private String type;
    private ArrayListMultimap<Integer, Integer> coordinates;

    Ship(){
        this.length = length;
        this.type = type;
    }

    abstract void setType(String t);

    abstract void setLength(int l);

    abstract String getType();

    abstract int getLength();

    abstract ArrayListMultimap<Integer, Integer> getCoordinates();

    abstract void setCoordinates(int i, int j);
}
