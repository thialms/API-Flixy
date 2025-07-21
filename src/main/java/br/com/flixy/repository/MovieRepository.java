package br.com.flixy.repository;

import br.com.flixy.entity.Category;
import br.com.flixy.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMovieByCategories(List<Category> categories);

}
