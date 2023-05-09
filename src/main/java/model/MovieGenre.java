package model;

import java.io.Serializable;

public enum MovieGenre {
    DRAMA(4),
    HORROR(1),
    SCIENCE_FICTION(5);

    public int genreRating;
    MovieGenre(int genreRating){
        this.genreRating = genreRating;
    }
}
