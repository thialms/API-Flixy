package br.com.flixy.mapper;

import br.com.flixy.controller.request.MovieRequest;
import br.com.flixy.controller.response.CategoryResponse;
import br.com.flixy.controller.response.MovieResponse;
import br.com.flixy.controller.response.StreamingResponse;
import br.com.flixy.entity.Category;
import br.com.flixy.entity.Movie;
import br.com.flixy.entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest request) {

        List<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> streamings = request.streamings().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();

        return Movie.builder()
                .tittle(request.tittle())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rating(request.rating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie) {

        List<CategoryResponse> categories = movie.getCategories().stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();

        List<StreamingResponse> streamings = movie.getStreamings().stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList();


        return MovieResponse.builder()
                .id(movie.getId())
                .tittle(movie.getTittle())
                .description(movie.getDescription())
                .realeaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }
}
