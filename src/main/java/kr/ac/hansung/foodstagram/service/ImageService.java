package kr.ac.hansung.foodstagram.service;


import org.springframework.stereotype.Service;
import org.tensorflow.Graph;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;


import java.io.*;

@Service
public class ImageService {




    public String imgTensor(File imgFile) {
        Graph graph = new Graph();
        Session session = SavedModelBundle.load("static/train.csv").session();

        //session.runner().feed().fetch().run().get().copyTo();

        return "caviar";
    }
}
