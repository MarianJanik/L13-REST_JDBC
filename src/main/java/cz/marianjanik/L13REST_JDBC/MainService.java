package cz.marianjanik.L13REST_JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainService implements MovieMapper {

    public String test2() {
        return "Ahoj, test2 je ok. ";
    }

    public Movie test3() {
        Movie movie = new Movie(7,"test3",2000,"test3333",8);
        return movie;
    }

    @Override
    public Movie getMovieById(int idMovie) throws SQLException {
        final String SELECT_BY_ID = "SELECT * FROM movie WHERE id=" + idMovie + ";";
        Connection connection = callSqlDatabase();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_BY_ID);
        Movie movie = new Movie();
        if (resultSet.next()) {
            movie.setId(resultSet.getInt("id"));
            movie.setName(resultSet.getString("name"));
            movie.setYearOfProduction(resultSet.getInt("year_of_production"));
            movie.setGenre(resultSet.getString("genre"));
            movie.setMyScore(resultSet.getInt("my_score"));
        }
        resultSet.close();
        statement.close();
        connection.close();
        return movie;
    }

    @Override
    public List<Movie> getAllMovie() throws SQLException {
        final String SELECT_ALL = "SELECT * FROM movie";
        Connection connection = callSqlDatabase();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL);

        List<Movie> movieList =new ArrayList<>();
        while (resultSet.next()) {
            Movie movie = new Movie();
            movie.setId(resultSet.getInt("id"));
            movie.setName(resultSet.getString("name"));
            movie.setYearOfProduction(resultSet.getInt("year_of_production"));
            movie.setGenre(resultSet.getString("genre"));
            movie.setMyScore(resultSet.getInt("my_score"));
            movieList.add(movie);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return movieList;
    }

    @Override
    public void setMovie(Movie movie) throws SQLException {
        final String INSERT_MOVIE = "INSERT INTO movie (name, year_of_production, genre, my_score) " +
        "VALUES ('" + movie.getName() + "'," + movie.getYearOfProduction() + ",'"
                + movie.getGenre() + "'," + movie.getMyScore() + ");";
        Connection connection = callSqlDatabase();
        Statement statement = connection.createStatement();

        statement.executeUpdate(INSERT_MOVIE);

        statement.close();
        connection.close();
    }

    @Override
    public void updateMovieById(Movie movie) throws SQLException {
        final String UPDATE_MOVIE = "UPDATE movie " +
                "SET name='" + movie.getName()
                + "',year_of_production=" + movie.getYearOfProduction()
                + ",genre='" + movie.getGenre()
                + "',my_score=" + movie.getMyScore()
                + " WHERE id=" + movie.getId() + ";";
        Connection connection = callSqlDatabase();
        Statement statement = connection.createStatement();

        statement.executeUpdate(UPDATE_MOVIE);

        statement.close();
        connection.close();

    }

    @Override
    public void deleteMovieByName(String name) throws SQLException {
        final String DELETE_BY_NAME = "DELETE FROM movie WHERE name='" + name + "';";
        Connection connection = callSqlDatabase();
        Statement statement = connection.createStatement();

        statement.executeUpdate(DELETE_BY_NAME);

        statement.close();
        connection.close();
    }

    @Override
    public void deleteMovieById(int idMovie) throws SQLException {
        final String DELETE_BY_ID = "DELETE FROM movie WHERE id=" + idMovie;
        Connection connection = callSqlDatabase();
        Statement statement = connection.createStatement();

        statement.executeUpdate(DELETE_BY_ID);

        statement.close();
        connection.close();
    }

    private Connection callSqlDatabase() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jpa2",
                "jpauser",
                "abcd123456789");
    }
}
