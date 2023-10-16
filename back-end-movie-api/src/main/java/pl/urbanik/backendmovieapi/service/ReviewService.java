package pl.urbanik.backendmovieapi.service;

import org.springframework.stereotype.Service;
import pl.urbanik.backendmovieapi.model.Review;

@Service
public interface ReviewService {
    Review createReview(String reviewBody, String imdbId);
}
