package model;

import java.util.Comparator;

public class MyOscarComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        if(o1.getOscarsCount() == o2.getOscarsCount()) return 0;
        else if(o1.getOscarsCount() > o2.getOscarsCount()) return 1;
        else return -1;
    }
}
