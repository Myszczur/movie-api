package pl.urbanik.backendmovieapi.service;

import org.springframework.stereotype.Service;
import pl.urbanik.backendmovieapi.model.Movie;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {
    List<Movie> getAllMovies();
    Optional<Movie> getMovieByImdb(String imdbId);
}
