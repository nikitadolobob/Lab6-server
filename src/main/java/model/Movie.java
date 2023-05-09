package model;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class Movie implements Comparable<Movie>, Serializable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int oscarsCount; //Значение поля должно быть больше 0
    private MovieGenre genre; //Поле не может быть null
    private MpaaRating mpaaRating; //Поле может быть null
    private Person director; //Поле не может быть null

    public Movie(int id, String name, Coordinates coordinates, ZonedDateTime creationDate, int oscarsCount, MovieGenre genre, MpaaRating mpaaRating, Person director) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.oscarsCount = oscarsCount;
        this.genre = genre;
        this.mpaaRating = mpaaRating;
        this.director = director;
    }

    public Movie(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public int getOscarsCount() {
        return oscarsCount;
    }

    public void setOscarsCount(int oscarsCount) {
        this.oscarsCount = oscarsCount;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public MpaaRating getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(MpaaRating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    @Override
    public String toString(){
        return "\nThe id: " + this.getId() + "\nThe name: " + this.getName() + "\nCoordinates:" + "    " + coordinates.getX() + "    " + coordinates.getY() + "\nCreated at: " + this.getCreationDate() + "\nGot " + this.getOscarsCount() + " oscar nominations" + "\nMovie genre is: " + this.getGenre() + "\nMpaaRated: " + this.getMpaaRating() + "\nDirector:" + "\n    Name: " + director.getName() + "\n    Weight: " + director.getWeight() + "\n    eyeColor: " + director.getEyeColor() + "\n    Hair color: " + director.getHairColor() + "\n    Nationality: " + director.getNationality();// + "    Location:" + "        X: " + director.getLocation().getX() + "        Y: " + director.getLocation().getY() + "        Z: " + director.getLocation().getZ();
    }

    @Override
    public int compareTo(Movie movie) {
        if(this.genre.genreRating + this.oscarsCount == movie.genre.genreRating + movie.oscarsCount){
            return this.name.compareTo(movie.name);
        }
        else{
            if(this.genre.genreRating + this.oscarsCount > movie.genre.genreRating + movie.oscarsCount){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}
