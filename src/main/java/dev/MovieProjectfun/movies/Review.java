package dev.MovieProjectfun.movies;

import org.bson.types.ObjectId;
// import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    // @Id
    private ObjectId id;
    private String body;

    // NOTE: custom constructor that takes only the body
    public Review(String body) {
        this.body = body;
    }
}
