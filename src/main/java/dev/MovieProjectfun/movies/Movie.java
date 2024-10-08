package dev.MovieProjectfun.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

// This lets the framework know this class represents each doc in movies collection
@Document(collection = "movies")

@Data // NOTE: Annotation from lomboc project that handles Getter/Setters/& 2-string
      // methods
@AllArgsConstructor // NOTE: Annotation for adding a constructor taking all private fields as
                    // arguements
@NoArgsConstructor // NOTE: This takes no params what-so-ever

public class Movie {
    @Id // This lets it know this acts as the UNIQUE id for each movie in the database
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> backdrops;
    private List<String> genres;

    @DocumentReference // this causes the db to store only the IDs of the review and the reviews are
                       // stored in a separate collection => MANUAL RELATIONSHIP
    private List<Review> reviewIds; // If written like this it will be an imbedded relationship such as a 1 to many
                                    // relationship meaning one movie has many reviews.

    // public Movie(String imdbId, String title, String releaseDate, String trailerLink, String poster,
    //         List<String> backdrops, List<String> genres) {
    //     this.imdbId = imdbId;
    //     this.title = title;
    //     this.releaseDate = releaseDate;
    //     this.trailerLink = trailerLink;
    //     this.poster = poster;
    //     this.backdrops = backdrops;
    //     this.genres = genres;
    // }
}
