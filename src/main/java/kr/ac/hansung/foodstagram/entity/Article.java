package kr.ac.hansung.foodstagram.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@AllArgsConstructor
@Entity(name = "articles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String text;
    private double rating;
    private double calorie;
    private String img_path;
    private Long restaurant_id;
    private String date;
}
