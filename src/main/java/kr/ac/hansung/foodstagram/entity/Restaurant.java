package kr.ac.hansung.foodstagram.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity(name = "restaurant")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    //private Point location;


}
