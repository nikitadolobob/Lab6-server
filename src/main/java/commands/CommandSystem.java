package commands;

import model.Coordinates;
import model.Location;
import model.Movie;
import model.Person;

/**
 * Элемент Pattern Command, хранящий методы-реализации всех команд приложения
 */
public class CommandSystem {
    /**
     * Счетчик, показывающий, сколько раз выполнилась вложенная команда execute_script
     */
    public static int execute_cnt = 0;

    public static void printMovie(Movie movie){
        Coordinates coordinates = movie.getCoordinates();
        Person director = movie.getDirector();
        Location location = director.getLocation();

        System.out.println("The id: " + movie.getId());
        System.out.println("The name: " + movie.getName());
        System.out.println("Coordinates:");
        System.out.println("    " + coordinates.getX());
        System.out.println("    " + coordinates.getY());
        System.out.println("Created at: " + movie.getCreationDate());
        System.out.println("Got " + movie.getOscarsCount() + " oscar nominations");
        System.out.println("Movie genre is: " + movie.getGenre());
        System.out.println("MpaaRated: " + movie.getMpaaRating());
        System.out.println("Director:");
        System.out.println("    Name: " + director.getName());
        System.out.println("    Weight: " + director.getWeight());
        System.out.println("    eyeColor: " + director.getEyeColor());
        System.out.println("    Hair color: " + director.getHairColor());
        System.out.println("    Nationality: " + director.getNationality());
        System.out.println("    Location:");
        System.out.println("        X: " + location.getX());
        System.out.println("        Y: " + location.getY());
        System.out.println("        Z: " + location.getZ());
    }

}
