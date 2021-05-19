package kr.ac.hansung.foodstagram.service;

import kr.ac.hansung.foodstagram.dao.RestaurantRepository;
import kr.ac.hansung.foodstagram.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurant() {
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantRepository.findAll().forEach(e -> restaurantList.add(e));

        return restaurantList;
    }


    public List<Restaurant> searchRestaurant(String keyword) {
        return restaurantRepository.findByNameContaining(keyword);
    }
}

