package pl.urbanik.backendmovieapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.urbanik.backendmovieapi.model.Movie;
import pl.urbanik.backendmovieapi.repository.MovieRepository;
import pl.urbanik.backendmovieapi.service.MovieService;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;

    @Override
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    @Override
    public Optional<Movie> getMovieByImdb(String imdbId) {
        return repository.findMovieByImdbId(imdbId);
    }
}