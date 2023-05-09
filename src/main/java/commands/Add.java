package commands;

import model.Movie;

import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 * Элемент Pattern Command, описывающий конкретную команду add
 */
public class Add implements Command {

    private Movie movie;
    private ArrayList<Movie> collection;

    public void setCollection(ArrayList<Movie> collection){
        this.collection = collection;
    }

    /**
     * Реализация команды, добавляющей новый фильм в конец коллекции
     */
    private String add(){
        if(movie == null){
            return "Movie is empty, can't perform command";
        }

        movie.setId(collection.size() + 1);
        movie.setCreationDate(ZonedDateTime.now());
        collection.add(movie);
        return "The movie is successfully added";
    }

    /**
     * переопределённый метод, запускающий команду add
     */
    @Override
    public String runCommand() {
         return this.add();
    }

    /**
     * Конструктор экземпляра add
     **/
    public Add(Movie movie){
        this.movie = movie;
    }
}
