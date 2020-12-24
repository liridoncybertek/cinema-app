package com.cybertek.orm.cinemaapp.bootstrap;

import com.cybertek.orm.cinemaapp.model.*;
import com.cybertek.orm.cinemaapp.model.enums.MovieState;
import com.cybertek.orm.cinemaapp.model.enums.MovieType;
import com.cybertek.orm.cinemaapp.model.enums.UserRole;
import com.cybertek.orm.cinemaapp.repository.*;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

//@Component
public class DataGenerator implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;
    private final UserRepository userRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final TicketRepository ticketRepository;

    /**
     * User objects.
     */
    public User u1 = new User("josie_story@email.com", "123123123", "josieStory");
    public User u2 = new User("bernard@email.com", "123123123", "bernard");
    public User u3 = new User("faith.p@email.com", "123123123", "faith");
    public User u4 = new User("johnnie@email.com", "123123123", "johnnie");
    public User u5 = new User("lawrence.f@email.com", "123123123", "lawrence.f");

    /**
     * Cinema objects
     */
    public Cinema c1 = new Cinema("Hall 1 - EMPIRE", "McDonald");
    public Cinema c2 = new Cinema("Hall 2 - EMPIRE", "Kodak");
    public Cinema c3 = new Cinema("Hall 3 - EMPIRE", "Act Vision");
    public Cinema c4 = new Cinema("Hall 4 - EMPIRE", "Quick Vision");
    public Cinema c5 = new Cinema("Hall 1 - STREET 14", "Du Pont");
    public Cinema c6 = new Cinema("Hall 2 - STREET 14", "HBO");
    public Cinema c7 = new Cinema("Hall 3 - STREET 14", "MySpace");
    public Cinema c8 = new Cinema("Hall 4 - STREET 14", "PlayStation");
    public Cinema c9 = new Cinema("Hall 1 - SQUARE 13", "Walt Disney");
    public Cinema c10 = new Cinema("Hall 2 - SQUARE 13", "Sony Corporation");
    public Cinema c11 = new Cinema("Hall 3 - SQUARE 13", "Warner Bros");
    public Cinema c12 = new Cinema("Hall 4 - SQUARE 13", "PlayStation");
    public Cinema c13 = new Cinema("Hall 1 - VILLAGE 7", "Du Pont");
    public Cinema c14 = new Cinema("Hall 2 - VILLAGE 7", "Kodak");
    public Cinema c15 = new Cinema("Hall 3 - VILLAGE 7", "MySpace");
    public Cinema c16 = new Cinema("Hall 4 - VILLAGE 7", "Channel 4");

    /**
     * Movie Objects.
     */
    public Movie m1 = new Movie("The Gentleman", new BigDecimal("20.00"), parseDateFromString("2020-01-24 00:00"), 113, MovieType.REGULAR, MovieState.ACTIVE);
    public Movie m2 = new Movie("A Beautiful Mind", new BigDecimal("15.00"), parseDateFromString("2002-01-04 00:00"), 135, MovieType.REGULAR, MovieState.DRAFT);
    public Movie m3 = new Movie("The Shawshank Redemption", new BigDecimal("35.00"), parseDateFromString("1994-10-14 00:00"), 142, MovieType.REGULAR, MovieState.DRAFT);
    public Movie m4 = new Movie("The Godfather", new BigDecimal("35.00"), parseDateFromString("1972-03-24 00:00"), 175, MovieType.REGULAR, MovieState.DRAFT);
    public Movie m5 = new Movie("Tenet", new BigDecimal("35.00"), parseDateFromString("2020-09-03 00:00"), 150, MovieType.PREMIER, MovieState.ACTIVE);
    public Movie m6 = new Movie("The Loss Adjuster", new BigDecimal("35.00"), parseDateFromString("2020-12-29 00:00"), 100, MovieType.PREMIER, MovieState.DRAFT);
    public Movie m7 = new Movie("The Nights Before Christmas", new BigDecimal("28.00"), parseDateFromString("2020-11-19 00:00"), 100, MovieType.REGULAR, MovieState.ACTIVE);
    public Movie m8 = new Movie("Spider-Man: Miles Morales", new BigDecimal("28.00"), parseDateFromString("2020-12-12 00:00"), 130, MovieType.REGULAR, MovieState.DRAFT);
    public Movie m9 = new Movie("Avengers: Endgame", new BigDecimal("48.00"), parseDateFromString("2019-04-26 00:00"), 181, MovieType.REGULAR, MovieState.DRAFT);

    /**
     * Movie Cinema objects.
     */
    public MovieCinema mc1 = new MovieCinema(m1, c1, parseDateFromString("2020-12-05 20:00"));
    public MovieCinema mc2 = new MovieCinema(m1, c7, parseDateFromString("2020-12-05 19:00"));
    public MovieCinema mc3 = new MovieCinema(m1, c10, parseDateFromString("2020-12-05 18:45"));
    public MovieCinema mc4 = new MovieCinema(m1, c12, parseDateFromString("2020-12-05 18:45"));
    public MovieCinema mc5 = new MovieCinema(m1, c14, parseDateFromString("2020-12-05 21:30"));

    public MovieCinema mc6 = new MovieCinema(m5, c1, parseDateFromString("2020-12-06 20:00"));
    public MovieCinema mc7 = new MovieCinema(m5, c7, parseDateFromString("2020-12-06 19:00"));
    public MovieCinema mc8 = new MovieCinema(m5,c12, parseDateFromString("2020-12-06 18:00"));
    public MovieCinema mc9 = new MovieCinema(m5,c12, parseDateFromString("2020-12-06 20:45"));
    public MovieCinema mc10 = new MovieCinema(m5, c14, parseDateFromString("2020-12-06 21:30"));

    public MovieCinema mc11 = new MovieCinema(m7, c1, parseDateFromString("2020-12-06 20:00"));
    public MovieCinema mc12 = new MovieCinema(m7, c7, parseDateFromString("2020-12-06 19:00"));
    public MovieCinema mc13 = new MovieCinema(m7,c12, parseDateFromString("2020-12-06 18:00"));
    public MovieCinema mc14 = new MovieCinema(m7,c12, parseDateFromString("2020-12-06 20:45"));
    public MovieCinema mc15 = new MovieCinema(m7, c14, parseDateFromString("2020-12-06 21:30"));

    public MovieCinema mc16 = new MovieCinema(m2, c1, parseDateFromString("2020-12-06 20:00"));
    public MovieCinema mc17 = new MovieCinema(m3, c7, parseDateFromString("2020-12-06 19:00"));
    public MovieCinema mc18 = new MovieCinema(m4, c12, parseDateFromString("2020-12-06 18:00"));
    public MovieCinema mc19 = new MovieCinema(m8, c12, parseDateFromString("2020-12-06 20:45"));
    public MovieCinema mc20 = new MovieCinema(m9, c14, parseDateFromString("2020-12-06 21:30"));

    public MovieCinema mc21 = new MovieCinema(m6, c1, parseDateFromString("2020-12-26 18:00"));
    public MovieCinema mc22 = new MovieCinema(m6, c1, parseDateFromString("2020-12-26 20:00"));
    public MovieCinema mc23 = new MovieCinema(m6,c2, parseDateFromString("2020-12-26 20:30"));
    public MovieCinema mc24 = new MovieCinema(m6, c2, parseDateFromString("2020-12-26 18:30"));
    public MovieCinema mc25 = new MovieCinema(m6, c3, parseDateFromString("2020-12-26 21:30"));
    public MovieCinema mc26 = new MovieCinema(m6, c3, parseDateFromString("2020-12-26 19:00"));
    public MovieCinema mc27 = new MovieCinema(m6,c4, parseDateFromString("2020-12-26 19:45"));
    public MovieCinema mc28 = new MovieCinema(m6, c4, parseDateFromString("2020-12-26 22:00"));


    public DataGenerator(MovieRepository movieRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, UserRepository userRepository, MovieCinemaRepository movieCinemaRepository, TicketRepository ticketRepository) {
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.userRepository = userRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        createUsers();
//        createCinemasAndLocations();
//        createMoviesAndGenres();
//        scheduleMovies();
//        bookAMovie();
    }

    /**
     * Create users.
     */
    private void createUsers() {
        AccountDetails a1 = new AccountDetails("Josie D Story", "262  Lochmere Lane", "Europe", "Kentucky", "LOUISVILLE", 35, "40289", UserRole.USER);
        AccountDetails a2 = new AccountDetails("Bernard P Fendley", "2903  Jarvis Street", "United States", "New York", "Buffalo", 28, "14211", UserRole.USER);
        AccountDetails a3 = new AccountDetails("Faith R Parsons", "4161  Alfred Drive", "United States", "New York", "Brooklyn", 47, "11226", UserRole.USER);
        AccountDetails a4 = new AccountDetails("Johnnie J Cannon", "2587  Logan Lane", "United States", "New York", "HOLTSVILLE", 47, "00544", UserRole.USER);
        AccountDetails a5 = new AccountDetails("Lawrence E Folkerts", "698  Clark Street", "United States", "New York", "Brentwood", 47, "11717", UserRole.USER);

        u1.setAccountDetails(a1);
        u2.setAccountDetails(a2);
        u3.setAccountDetails(a3);
        u4.setAccountDetails(a4);
        u5.setAccountDetails(a5);

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
    }

    /**
     * create cinemas and locations.
     */
    private void createCinemasAndLocations() {
        Location l1 = new Location("AMC Empire 25", "234 W 42nd St", 10036, "United States", "New York", "New York");
        Location l2 = new Location("AMC 34th Street 14", "312 W 34th St", 10001, "United States", "New York", "New York");
        Location l3 = new Location("AMC Lincoln Square 13", "1998 Broadway", 10023, "United States", "New York", "New York");
        Location l4 = new Location("AMC Village 7", "66 3rd Ave", 10003, "United States", "New York", "New York");
        
        c1.setLocation(l1);
        c2.setLocation(l1);
        c3.setLocation(l1);
        c4.setLocation(l1);

        c5.setLocation(l2);
        c6.setLocation(l2);
        c7.setLocation(l2);
        c8.setLocation(l2);

        c9.setLocation(l3);
        c10.setLocation(l3);
        c11.setLocation(l3);
        c12.setLocation(l3);

        c13.setLocation(l4);
        c14.setLocation(l4);
        c15.setLocation(l4);
        c16.setLocation(l4);

        List<Cinema> cinemas = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16);
        cinemaRepository.saveAll(cinemas);
    }

    /**
     * Create movies and genres.
     */
    private void createMoviesAndGenres() {
        Genre g1 = new Genre("Comedy");
        Genre g2 = new Genre("Sci-Fi");
        Genre g3 = new Genre("Action");
        Genre g4 = new Genre("Horror");
        Genre g5 = new Genre("Thriller");
        Genre g6 = new Genre("Drama");
        Genre g7 = new Genre("Mystery");
        Genre g8 = new Genre("Crime");
        Genre g9 = new Genre("Animation");
        Genre g10 = new Genre("Adventure");
        Genre g11 = new Genre("History");
        Genre g12 = new Genre("Fantasy");
        Genre g13 = new Genre("Biography");

        List<Genre> genre = Arrays.asList(g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13);
        genreRepository.saveAll(genre);

        
        m1.setSummary("An American expat tries to sell off his highly profitable marijuana empire in London, triggering plots, schemes, bribery and blackmail in an attempt to steal his domain out from under him.");
        m1.setGenreList(Arrays.asList(g3, g1, g8));

        m2.setSummary("After John Nash, a brilliant but asocial mathematician, accepts secret work in cryptography, his life takes a turn for the nightmarish.");
        m2.setGenreList(Arrays.asList(g13, g6));

        m3.setSummary("Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency");
        m3.setGenreList(Arrays.asList(g6));

        m4.setSummary("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son");
        m4.setGenreList(Arrays.asList(g6, g8));

        m5.setSummary("Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time");
        m5.setGenreList(Arrays.asList(g2, g3));

        m6.setSummary("Hapless Insurance Loss Adjuster - Martin Dyer - feels his life is spiralling out of control but discovers that even when you reach rock bottom, that some clouds really do have a silver lining");
        m6.setGenreList(Arrays.asList(g1));

        m7.setSummary("A murderous Santa and Mrs Claus play a cat and mouse game with the FBI.");
        m7.setGenreList(Arrays.asList(g4));

        m8.setSummary("In this sequel of Marvel's Spider-Man (2018), you can play as Miles Morales as a new and different Spider-Man while he learns some stories about his will of fighting crime and serving justice by his mentor and former hero, Peter Parker.");
        m8.setGenreList(Arrays.asList(g3, g8, g10));

        m9.setSummary("After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.");
        m9.setGenreList(Arrays.asList(g3, g10));

        List<Movie> movies = Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9);

        movieRepository.saveAll(movies);

    }

    /**
     * Shcedule a movie.
     */
    private void scheduleMovies() {
        List<MovieCinema> movieCinemas = Arrays.asList(mc1, mc2, mc3, mc4, mc5, mc5, mc6, mc7, mc8, mc9, mc10, mc11, mc12, mc13, mc14, mc15, mc16, mc17, mc18, mc19, mc20,mc21, mc22, mc23, mc24, mc25, mc26, mc27, mc28 );
        movieCinemaRepository.saveAll(movieCinemas);
    }

    /**
     * Book a movie.
     */
    private void bookAMovie() {
        Ticket t1 = new Ticket(15, 14, parseDateFromString("2020-12-05 20:00"), u1, mc1);
        Ticket t2 = new Ticket(7, 18, parseDateFromString("2020-12-05 20:00"),u2, mc1);
        Ticket t3 = new Ticket(9, 9, parseDateFromString("2020-12-05 20:00"), u3, mc1);
        Ticket t4 = new Ticket(18, 12, parseDateFromString("2020-12-05 20:00"), u4, mc1);
        Ticket t5 = new Ticket(5, 11, parseDateFromString("2020-12-05 20:00"),u5, mc1);

        Ticket t6 = new Ticket(15, 14, parseDateFromString("2020-12-06 20:45"), u1, mc8);
        Ticket t7 = new Ticket(7, 18, parseDateFromString("2020-12-06 20:45"),u2, mc8);
        Ticket t8 = new Ticket(9, 9, parseDateFromString("2020-12-06 20:45"), u3, mc8);
        Ticket t9 = new Ticket(18, 12, parseDateFromString("2020-12-06 20:45"), u4, mc8);
        Ticket t10 = new Ticket(5, 11, parseDateFromString("2020-12-06 20:45"),u5, mc8);

        Ticket t11 = new Ticket(15, 14, parseDateFromString("2020-12-07 21:30"), u1, mc15);
        Ticket t12 = new Ticket(7, 18, parseDateFromString("2020-12-07 21:30"),u2, mc15);
        Ticket t13 = new Ticket(9, 9, parseDateFromString("2020-12-07 21:30"), u3, mc15);
        Ticket t14 = new Ticket(18, 12, parseDateFromString("2020-12-07 21:30"), u4, mc15);
        Ticket t15 = new Ticket(5, 11, parseDateFromString("2020-12-07 21:30"),u5, mc15);

        Ticket t16 = new Ticket(15, 14, parseDateFromString("2020-12-08 19:00"), u1, mc17);
        Ticket t17 = new Ticket(7, 18, parseDateFromString("2020-12-08 19:00"),u2, mc17);
        Ticket t18 = new Ticket(9, 9, parseDateFromString("2020-12-08 19:00"), u3, mc17);
        Ticket t19 = new Ticket(18, 12, parseDateFromString("2020-12-08 19:00"), u4, mc17);
        Ticket t20 = new Ticket(5, 11, parseDateFromString("2020-12-08 19:00"),u5, mc17);

        List<Ticket> tickets = Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20);
        ticketRepository.saveAll(tickets);
    }

    private LocalDateTime parseDateFromString(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return  LocalDateTime.parse(date, formatter);
    }
}
