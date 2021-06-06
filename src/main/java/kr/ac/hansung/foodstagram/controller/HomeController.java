package kr.ac.hansung.foodstagram.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public ResponseEntity<String> rootPage() {
        String ss = "hi";
        return ResponseEntity.ok(ss);
    }


}
