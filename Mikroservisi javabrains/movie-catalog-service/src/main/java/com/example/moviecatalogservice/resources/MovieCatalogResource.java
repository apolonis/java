package com.example.moviecatalogservice.resources;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired //@BEAN IS PRODUCER @AUTOWIRED IS CUNSUMER
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/asd" + userId,
                UserRating.class);

        return ratings.getUserRating().stream().map(rating -> {

            //For each movie ID, call movie info service and get details
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/asd" +
                    rating.getMovieId(), Movie.class);

            //Put them all together
            return new CatalogItem(movie.getName(), "Description", rating.getRating());

        }).collect(Collectors.toList());

    }

}
