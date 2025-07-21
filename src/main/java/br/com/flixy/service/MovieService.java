package br.com.flixy.service;

import br.com.flixy.entity.Category;
import br.com.flixy.entity.Movie;
import br.com.flixy.entity.Streaming;
import br.com.flixy.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public Movie save(Movie movie){
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
        return repository.save(movie);
    }

    public List<Movie> findAll(){
        return repository.findAll();
    }

    public Optional<Movie> getById(Long id){
        return repository.findById(id);
    }

    public List<Movie> getByCategory(Long categoryId){
        return repository.findMovieByCategories(List.of(Category.builder().id(categoryId).build()));
    }

    public Optional<Movie> update(Long id, Movie updatedmovie){
         Optional<Movie> optionalMovie = repository.findById(id);
         if (optionalMovie.isPresent()) {

             List<Category> categories = this.findCategories(updatedmovie.getCategories());
             List<Streaming> streamings = this.findStreamings(updatedmovie.getStreamings());

             Movie movie = optionalMovie.get();
             movie.setTittle(updatedmovie.getTittle());
             movie.setDescription(updatedmovie.getDescription());
             movie.setReleaseDate(updatedmovie.getReleaseDate());
             movie.setRating(updatedmovie.getRating());

             movie.getCategories().clear();
             movie.getCategories().addAll(categories);
             movie.getStreamings().clear();
             movie.getStreamings().addAll(streamings);

             repository.save(movie);
             return Optional.of(movie);
         }
         return Optional.empty();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    private List<Category> findCategories(List<Category> categories){
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category -> categoryService.findById(category.getId()).ifPresent(categoriesFound::add));
        return categoriesFound;
    }

    private List<Streaming> findStreamings(List<Streaming> streamings){
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings.forEach(streaming -> streamingService.findById(streaming.getId()).ifPresent(streamingsFound::add));
        return streamingsFound;
    }

}
