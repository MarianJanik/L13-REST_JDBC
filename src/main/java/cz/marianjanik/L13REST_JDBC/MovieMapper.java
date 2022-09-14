package cz.marianjanik.L13REST_JDBC;

import java.sql.SQLException;
import java.util.List;

public interface MovieMapper {

    Movie getMovieById(int idMovie) throws SQLException;

    List<Movie> getAllMovie() throws SQLException;

    void setMovie(Movie movie) throws SQLException;

    void updateMovieById(Movie movie) throws SQLException;

    void deleteMovieByName(String name) throws SQLException;

    void deleteMovieById(int idMovie) throws SQLException;
}
