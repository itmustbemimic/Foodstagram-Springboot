package kr.ac.hansung.foodstagram.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    @GetMapping(value = "/img/{img_path}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("img_path") String img_path) throws IOException {
        InputStream in = new FileInputStream(img_path);
        byte[] imageByteArray = IOUtils.toByteArray(in);
        in.close();

        if (imageByteArray == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<byte[]>(imageByteArray, HttpStatus.OK);
    }
}
