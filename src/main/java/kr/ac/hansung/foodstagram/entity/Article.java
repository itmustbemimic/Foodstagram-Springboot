package kr.ac.hansung.foodstagram.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;



@Data
@AllArgsConstructor
@Entity(name = "articles")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String text;
    private double rating;
    private double calorie;
    private String img_path;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


}
