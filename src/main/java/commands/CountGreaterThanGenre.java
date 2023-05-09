package commands;

import model.Movie;
import model.MovieGenre;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Элемент Pattern Command, описывающий конкретную команду CountGreaterThanGenre.
 */
public class CountGreaterThanGenre implements Command {

    private ArrayList<Movie> collection;

    public void setCollection(ArrayList<Movie> collection){
        this.collection = collection;
    }

    /**
     * Реализация команды, выводящей на консоль количество фильмов коллекции, жанр которых, в соответствие с полем genreRating, строго больше заданного жанра
     *
     * @param genre Заданный жанр, с которым производится сравнение
     */


    private String countGreaterThanGenre(String genre){
        //java stream api
        MovieGenre eGenre = Arrays.stream(MovieGenre.values()).filter(genreEnum -> genreEnum.name().equals(genre))
                .findFirst()
                .orElse(null);
        if(eGenre == null){
            return "Incorrect genre";
        }
        long maxGenreCount = collection.stream()
                .filter(movie -> movie.getGenre().genreRating > eGenre.genreRating)
                .count();
        return "Here you go, bro. There are: " + maxGenreCount + " of the more genred movies in the collection!";
    }
    private final String genre;

    /**
     * переопределённый метод, запускающий команду countGreaterThanGenre
     */
    @Override
    public String runCommand() {
        return this.countGreaterThanGenre(genre);
    }

    /**
     * Конструктор экземпляра countGreaterThanGenre.
     *
     * @param genre  вводимый пользователь жанр, по которому будет происходить необходимое сравнение
     */
    public CountGreaterThanGenre (String genre){
        this.genre = genre;
    }
}
