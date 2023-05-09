package commands;

import model.Movie;

import java.util.ArrayList;

/**
 * Элемент Pattern Command, описывающий конкретную команду removeById.
 */
public class RemoveById implements Command {

    private ArrayList<Movie> collection;

    public void setCollection(ArrayList<Movie> collection){
        this.collection = collection;
    }
    /**
     * Реализация команды, удаляющей из коллекции фильм с заданным id
     *
     * @param id - значение поля id удаляемого фильма
     */
    private String removeById(int id){
        //java Stream API
        return collection.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst()
                .map(movie -> {
                    collection.remove(movie);
                    collection.forEach(m -> {
                        if (m.getId() > movie.getId()) {
                            m.setId(m.getId() - 1);
                        }
                    });
                    return "Element is deleted";
                })
                .orElse("Id is incorrect. Can not remove element. Try again or enter another command.\n");
    }

    private final int id;

    /**
     * переопределённый метод, запускающий команду removeById
     */
    @Override
    public String runCommand() {
        return this.removeById(id);
    }

    /**
     * Конструктор экземпляра removeById.
     *
     * @param id вводимое пользователем поле, по значению которого будет вычислен удаляемый элемент
     */
    public RemoveById (int id){
        this.id = id;
    }
}
