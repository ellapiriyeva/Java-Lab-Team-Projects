package JavaLabProject1;

public class Movie {
    public String name;
    public double rating;

    public Movie(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "MovieApp{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}