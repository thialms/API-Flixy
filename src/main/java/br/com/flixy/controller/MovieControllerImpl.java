package br.com.flixy.controller;

import br.com.flixy.controller.request.MovieRequest;
import br.com.flixy.controller.response.MovieResponse;
import br.com.flixy.entity.Movie;
import br.com.flixy.mapper.MovieMapper;
import br.com.flixy.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flixy/movie")
@RequiredArgsConstructor
public class MovieControllerImpl implements MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> save(@Valid @RequestBody MovieRequest request){
        Movie savedMovie = movieService.save(MovieMapper.toMovie(request));
        return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAll(){
        List<MovieResponse> movies = movieService.findAll()
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getById(@PathVariable Long id){
        return movieService.getById(id)
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @Valid @RequestBody MovieRequest request){
        return movieService.update(id, MovieMapper.toMovie(request))
                .map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> getByCategory(@RequestParam Long category){
        return ResponseEntity.ok(movieService.getByCategory(category).stream()
                .map(MovieMapper::toMovieResponse)
                .toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Optional<Movie> optionalMovie = movieService.getById(id);
        if(optionalMovie.isPresent()){
            movieService.delete(id);
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
