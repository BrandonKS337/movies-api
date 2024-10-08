package dev.MovieProjectfun.movies;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This lets the framework know this class represents each doc in movies collection
@Document(collation = "movies")

@Data // NOTE: Annotation from lomboc project that handles Getter/Setters/& 2-string methods
@AllArgsConstructor // NOTE: Annotation for adding a constructor taking all private fields as arguements
@NoArgsConstructor //NOTE: This takes no params what-so-ever

public class Movie {
    @Id //This lets it know this acts as the UNIQUE id for each movie in the database
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    @DocumentReference //this causes the db to store only the IDs of the review and the reviews are stored in a separate collection => MANUAL RELATIONSHIP
    private List<Review> reviewIds; //If written like this it will be an imbedded relationship such as a 1 to many relationship meaning one movie has many reviews.
}
