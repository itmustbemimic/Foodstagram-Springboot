package kr.ac.hansung.foodstagram.controller;

import kr.ac.hansung.foodstagram.service.ImageService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;



    @GetMapping(value = "/img/{img_filename}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("img_filename") String img_filename) throws IOException {
        InputStream in = new FileInputStream("/img/" + img_filename);
        byte[] imageByteArray = IOUtils.toByteArray(in);
        in.close();

        if (imageByteArray == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<byte[]>(imageByteArray, HttpStatus.OK);
    }


    @PostMapping("/img")
    public ResponseEntity<?> uploadImage(@RequestPart("data") MultipartFile file) throws IOException {

        String foodName;

        if (file.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //이거 맞음?

        //Linux
        File dest = new File("/img/" + file.getOriginalFilename());

        //Windows
        //File dest = new File("C:\\img\\" + file.getOriginalFilename());

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("IMG Path = " + dest.getPath());

        foodName = imageService.imgTensor(dest);

        return new ResponseEntity<>(foodName, HttpStatus.OK);

    }

}
