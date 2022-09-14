package cz.marianjanik.L13REST_JDBC;


import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class MainController {

    @GetMapping (path = "/movie/test1")
    public String test1() {
        return "Test1 je za námi";
    }

    @GetMapping (path = "/movie/test2")
    public String test2() {
        MainService service = new MainService();
        return service.test2();
    }

    @GetMapping (path = "/movie/test3")
    public Movie test3() {
        MainService service = new MainService();
        return service.test3();
    }

    @GetMapping(path = "/movie/id/{idMovie}")
    public Movie getMovieByIdController (@PathVariable int idMovie) throws SQLException {
        MainService service = new MainService();
        return service.getMovieById (idMovie);
    }

    @GetMapping(path = "/movie/all")
    public List<Movie> getAllMovieController() throws SQLException {
        MainService service = new MainService();
        return service.getAllMovie();
    }

    @PostMapping(path = "/movie/save")
    public String setMovie(@RequestBody Movie movie) throws SQLException {
        MainService service = new MainService();
        service.setMovie(movie);
        return "Hotovo. Film " + movie.getName() + " je zapsaný.";
    }

    @PutMapping(path = "/movie/update")
    public String updateMovieS(@RequestBody Movie updateMovie) throws SQLException {
        //System.out.println(updateMovie.getName() + ", " + updateMovie.getId());
        MainService service = new MainService();
        if (service.getMovieById(updateMovie.getId()).getName() != null) {
            service.updateMovieById(updateMovie);
            return "Hotovo - upravený.";
        }
        return "Film s 'id'=" + updateMovie.getId() + " nebyl nalezen.";
    }

    @DeleteMapping(path = "/movie/id/{idMovie}")
    public String deleteMovieById(@PathVariable int idMovie) throws SQLException {
        MainService service = new MainService();
        service.deleteMovieById(idMovie);
        return "Hotovo - vymazaný.";
    }

    @DeleteMapping(path = "/movie/name")
    public String deleteMovieByName(@RequestParam String name) throws SQLException {
        MainService service = new MainService();
        service.deleteMovieByName(name);
        return "Hotovo - vymazaný.";
    }
}
