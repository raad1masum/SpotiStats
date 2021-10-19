package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

@Controller 
public class Ascii {

    public String ascii(String path, String file) throws IOException {
        File f = new File("C:\\Users\\piraa\\Documents\\Github\\AP-CSA-Tri-1-Project\\src\\main\\resources\\static\\images\\cbscam.png");

        BufferedImage img = ImageIO.read(f);
        ImageInfo imageinfo = new ImageInfo(path, "http://localhost:8080/" + path, 1);
        String imagedata = imageinfo.grayscale();

        System.out.println(imagedata);

        String base64Image = imagedata.split(",")[1];
        byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64Image);
        BufferedImage grayscaleImg = ImageIO.read(new ByteArrayInputStream(imageBytes));

        File outputfile = new File("saved.png");
        ImageIO.write(grayscaleImg, "png", outputfile);

        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
            }
        }

        return "asdf";
    }


    @GetMapping("/ascii")
    public String greeting(@RequestParam(required=false, defaultValue="World") String name,
    @RequestParam(required=false, defaultValue="1") String number, 
    Model model) throws IOException {

        ascii("/images/cbscam.png", "C:\\Users\\piraa\\Documents\\Github\\AP-CSA-Tri-1-Project\\src\\main\\resources\\static\\images\\cbscam.png");

        model.addAttribute("name", name); 
        model.addAttribute("number", number);
        return "ascii";
    }
}