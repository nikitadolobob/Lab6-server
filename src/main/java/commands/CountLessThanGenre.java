package commands;

import model.Movie;
import model.MovieGenre;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Элемент Pattern Command, описывающий конкретную команду CountLessThanGenre.
 */
public class CountLessThanGenre implements Command {

    private ArrayList<Movie> collection;

    public void setCollection(ArrayList<Movie> collection){
        this.collection = collection;
    }

    /**
     * Реализация команды, выводящей на консоль количество фильмов коллекции, жанр которых, в соответствие с полем genreRating, строго меньше заданного жанра
     *
     * @param genre заданный жанр, с которым производится сравнение
     */
    private String countLessThanGenre(String genre){
        //java stream api
        MovieGenre eGenre = Arrays.stream(MovieGenre.values()).filter(genreEnum -> genreEnum.name().equals(genre))
                .findFirst()
                .orElse(null);
        if(eGenre == null){
            return "Incorrect genre";
        }

        long minGenreCount = collection.stream().filter(movie -> movie.getGenre().genreRating < eGenre.genreRating).count();
        return "Here you go, bro. There are: " + minGenreCount + " of the less genred movies in the collection!";
    }
    private final String genre;

    /**
     * переопределённый метод, запускающий команду countLessThanGenre
     */
    @Override
    public String runCommand() {
        return this.countLessThanGenre(genre);
    }

    /**
     * Конструктор экземпляра countLessThanGenre.
     *
     * @param genre вводимый пользователь жанр, по которому будет происходить необходимое сравнение
     */
    public CountLessThanGenre (String genre){
        this.genre = genre;
    }
}
