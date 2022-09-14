package cz.marianjanik.L13REST_JDBC;

public class Movie {
    private int idMovie;
    private String name;
    private int yearOfProduction;
    private String genre;
    private int myScore;

    public Movie(int idMovie, String name, int yearOfProduction, String genre, int myScore) {
        this.idMovie = idMovie;
        this.name = name;
        this.yearOfProduction = yearOfProduction;
        this.genre = genre;
        this.myScore = myScore;
    }

    public Movie(){
    }

    public int getId() {
        return idMovie;
    }

    public void setId(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMyScore() {
        return myScore;
    }

    public void setMyScore(int myScore) {
        this.myScore = myScore;
    }
}
