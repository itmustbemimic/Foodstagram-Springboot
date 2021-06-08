package kr.ac.hansung.foodstagram.controller;

import kr.ac.hansung.foodstagram.entity.Article;
import kr.ac.hansung.foodstagram.entity.Restaurant;
import kr.ac.hansung.foodstagram.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/restaurant")
    public ResponseEntity<?> getAllRestaurant() {
        final List<Restaurant> restaurantList = restaurantService.getAllRestaurant();

        return new ResponseEntity<>(restaurantList, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{name}")
    public ResponseEntity<?> searchRestaurant(@PathVariable String name) {
        List<Restaurant> restaurantList = restaurantService.searchRestaurant(name);

        return new ResponseEntity<>(restaurantList, HttpStatus.OK);
    }

    @PostMapping("/restaurant")
    public ResponseEntity<Restaurant> createFeed(@RequestBody Restaurant request) {
        Restaurant restaurant = restaurantService.createRestaurant(request);

        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

}
