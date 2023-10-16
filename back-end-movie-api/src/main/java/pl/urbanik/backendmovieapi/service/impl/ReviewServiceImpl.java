package pl.urbanik.backendmovieapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import pl.urbanik.backendmovieapi.model.Movie;
import pl.urbanik.backendmovieapi.model.Review;
import pl.urbanik.backendmovieapi.repository.ReviewRepository;
import pl.urbanik.backendmovieapi.service.ReviewService;

import java.time.LocalDateTime;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Review createReview(String reviewBody, String imdbId) {
        Review review = repository.insert(new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now()));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviews").value(review))
                .first();

        return review;
    }
}