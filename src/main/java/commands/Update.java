package commands;

import model.Movie;

import java.util.ArrayList;

/**
 * Элемент Pattern Command, описывающий конкретную команду update.
 */
public class Update implements Command {

    private Movie movie;
    private ArrayList<Movie> collection;

    public void setCollection(ArrayList<Movie> collection){
        this.collection = collection;
    }

    /**
     * Реализация команды, позволяющая пользователю поочередно изменить каждое поле фильма коллекции с заданным id
     *
     * @param id - значения поля id фильма, поля которого пользователь будет менять
     */
    private String update(int id){
        if(id <= 0 || id > collection.size()) {
            return "Id is incorrect. Can not update element. Try again or enter another command.\n";
        }
        if(movie == null){
            return "Movie is empty, can't perform the command\n";
        }
        movie.setId(id);
        movie.setCreationDate(collection.get(id - 1).getCreationDate());
        collection.remove(id - 1);
        collection.add(id - 1, movie);
        return "The movie is successfully updgared\n";
    }

    private final int id;

    /**
     * переопределённый метод, запускающий команду update
     */
    @Override
    public String  runCommand() {
        return this.update(id);
    }

    /**
     * Конструктор экземпляра update.
     *
     * @param id вводимое пользователем поле, по значению которого будет вычислен изменяемый элемент
     */
    public Update (int id, Movie movie){
        this.id = id;
        this.movie = movie;
    }
}
