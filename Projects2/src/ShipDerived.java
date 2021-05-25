package Java;

import com.google.common.collect.ArrayListMultimap;

import java.util.ArrayList;

public class ShipDerived extends Ship{

    private String type;
    private int length;
    private ArrayListMultimap<Integer, Integer> coordinates = ArrayListMultimap.create();
    private ArrayList<Integer> c2 = new ArrayList<>();

    public ShipDerived(){
        this.type = type;
        this.length = length;
        this.coordinates = coordinates;
        this.c2 = c2;
    }

    public ShipDerived(String t, int l){
        this.type = t;
        this.length = l;
        this.coordinates = coordinates;
        this.c2 = getCoordinatesList();
    }

    @Override
    void setType(String t) {
        type = t;
    }

    @Override
    void setLength(int l) {
        length = l;
    }

    @Override
    String getType() {
        return type;
    }

    @Override
    int getLength() {
        return length;
    }

    @Override
    ArrayListMultimap<Integer, Integer> getCoordinates() {
        return this.coordinates;
    }

    ArrayList<Integer> getCoordinatesList() {
        return this.c2;
    }

    @Override
    void setCoordinates(int i, int j) {
        //coordinates.putAll(i, Collections.singleton(j));
        this.coordinates.put(i,j);
        this.c2.add(i);
        this.c2.add(j);
    }


}
