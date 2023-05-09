package commands;

import model.Movie;
import model.MovieGenre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Элемент Pattern Command, описывающий конкретную команду filterGreaterThanGenre.
 */
public class FilterGreaterThanGenre implements Command {

    private ArrayList<Movie> collection;

    public void setCollection(ArrayList<Movie> collection){
        this.collection = collection;
    }

    /**
     * Реализация команды, выводящей на консоль фильмы коллекции, жанр которых, в соответствие с полем genreRating, строго больше заданного жанра
     *
     * @param genre заданный жанр, с которым производится сравнение
     */

    private String filterGreaterThanGenre(String genre){
        //java stream api
        MovieGenre eGenre = Arrays.stream(MovieGenre.values()).filter(genreEnum -> genreEnum.name().equals(genre))
                .findFirst()
                .orElse(null);
        if(eGenre == null){
            return "Incorrect genre";
        }
        String response = collection.stream()
                .filter(movie -> movie.getGenre().genreRating > eGenre.genreRating)
                .map(movie -> movie + "\n----------------------------------\n")
                .collect(Collectors.joining());

        if (response.isEmpty()) {
            return "There are no better genred movies in the collection";
        } else {
            return "Here is the list of better genred movies in the collection: \n" + response + "That's all of them!\n";
        }
    }
    private final String genre;

    /**
     * переопределённый метод, запускающий команду filterGreaterThanGenre
     */
    @Override
    public String runCommand() {
        return this.filterGreaterThanGenre(genre);
    }

    /**
     * Конструктор экземпляра filterGreaterThanGenre.
     *
     * @param genre вводимый пользователь жанр, по которому будет происходить необходимое сравнение
     */
    public FilterGreaterThanGenre (String genre){
        this.genre = genre;
    }
}
