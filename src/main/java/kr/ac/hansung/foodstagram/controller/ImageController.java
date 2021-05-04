package kr.ac.hansung.foodstagram.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {



    @GetMapping(value = "/img/{img_filename}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("img_filename") String img_filename) throws IOException {
        InputStream in = new FileInputStream("C:\\img\\" + img_filename);
        byte[] imageByteArray = IOUtils.toByteArray(in);
        in.close();

        if (imageByteArray == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<byte[]>(imageByteArray, HttpStatus.OK);
    }


    @PostMapping("/img")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //이거 맞음?

        File dest = new File("/img/" + file.getOriginalFilename());
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(dest.getPath().toString());

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
