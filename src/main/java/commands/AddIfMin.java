package commands;

import model.Movie;


import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Элемент Pattern Command, описывающий конкретную команду addIfMin
 */
public class AddIfMin implements Command {

    private final Movie movie;
    private ArrayList<Movie> collection;

    public void setCollection(ArrayList<Movie> collection){
        this.collection = collection;
    }


    /**
     * Реализация команды, добавляющей новый фильм в конец коллекции, если этот элемент, в соотвествие с переопределённым для класса Movie методом compareTo, окажется строго меньше минимального элемента коллекции
     */
    private String addIfMin(){
        //java Stream API (find min)
        Movie minMovie = collection.stream().min(Comparator.naturalOrder()).orElse(null);

        if(minMovie == null){
            return "Impossible to run command: collection is empty, no minimal element exists.";
        }
        if(movie == null){
            return "Movie is empty, can't perform command";
        }
        if(movie.compareTo(minMovie) < 0){
            movie.setId(collection.size() + 1);
            movie.setCreationDate(ZonedDateTime.now());
            collection.add(movie);
            return "The movie is in the collection now";
        }
        else {
            return "The movie was not a minimum, so it is not in the collection";
        }
    }
    /**
     * переопределённый метод, запускающий команду addIfMin
     */
    @Override
    public String runCommand() {
        return this.addIfMin();
    }

    /**
     * Конструктор экземпляра addIfMin
     *
     */
    public AddIfMin(Movie movie){
        this.movie = movie;
    }
}
