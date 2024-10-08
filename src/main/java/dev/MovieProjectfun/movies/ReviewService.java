package dev.MovieProjectfun.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    // NOTE: template

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) { // NOTE: pushes the reviewBody(as a string) through with the imdbId to the func
        Review review = reviewRepository.insert(new Review(reviewBody)); // NOTE: creates a new review in the reviewRepository

        mongoTemplate.update(Movie.class) // NOTE: use the Movie Class from Movie.java
            .matching(Criteria.where("imdbId").is(imdbId)) // NOTE: Looks for movies matching imdbID
            .apply(new Update().push("reviewIds").value(review)) // NOTE: pushes the review into the open array
            .first();
            
        return review; // NOTE: Returns the review's array
    }
}
