package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ByteArrayInputStream;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

@Controller 
public class Ascii {

    public String ascii(String path, String file) throws IOException {
        StringBuilder out = new StringBuilder();
        char[] charList = {' ', '`', '\'', '.', '-', '_', ',', '"', ':', '!', '=', '~', ';', '>', '+', '<', '^', '*', 'r', ')', '(', '?', '|', '/', '\\', 'v', 'x', ']', '[', 'i', 'L', '7', 'Y', '}', '{', 'T', 'l', '1', 'u', 'n', 'c', 'V', 'y', 'w', 'J', '2', 'k', 'z', 't', 'C', 'j', 'o', 'X', 'F', 'I', 'h', '4', 'U', 's', 'e', 'm', 'f', 'K', 'a', '3', 'P', 'H', 'G', 'W', 'A', 'q', 'p', 'S', '%', '5', 'M', 'Z', 'b', 'd', 'O', 'N', '6', '9', 'R', 'E', 'D', '0', '&', '$', 'g', '8', 'Q', 'B', '#', '@'};

        ImageInfo imageinfo = new ImageInfo(path, "http://localhost:8080/" + path, 1);
        String imagedata = imageinfo.grayscale();

        String base64Image = imagedata.split(",")[1];
        byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64Image);
        BufferedImage grayscaleImg = ImageIO.read(new ByteArrayInputStream(imageBytes));

        // save image
        // File outputfile = new File("saved.png");
        // ImageIO.write(grayscaleImg, "png", outputfile);

        int adjust = 2;

        for (int i = 0; i < grayscaleImg.getWidth(); i += adjust) {
            for (int j = 0; j < grayscaleImg.getHeight(); j += adjust) {
                int avgGray = 0;
                int cnt = 1;

                for (int k = i; k < i + adjust; k++) {
                    for (int l = j; l < j + adjust; l++) {
                        cnt++;

                        int p = grayscaleImg.getRGB(k, l);

                        int r = (p>>16)&0xff;
                        int g = (p>>8)&0xff;
                        int b = p&0xff;

                        double graylevel = 0.2126 * Double.valueOf(r) + 0.7152 * Double.valueOf(g) + 0.0722 * Double.valueOf(b);
                    
                        avgGray += graylevel * 0.5;
                    }

                    avgGray /= cnt;
                    out.append(charList[avgGray]);
                }
            }
            out.append("\n");
        }

        return out.toString();
    }

    @GetMapping("/ascii")
    public String ascii(@RequestParam(required=false, defaultValue="") String asciiart,
    Model model) throws IOException {

        asciiart = ascii("/images/cbscam.png", "C:\\Users\\piraa\\Documents\\Github\\AP-CSA-Tri-1-Project\\src\\main\\resources\\static\\images\\cbscam.png");
        // asciiart = ascii("/images/ursinus.png", "C:\\Users\\piraa\\Documents\\Github\\AP-CSA-Tri-1-Project\\src\\main\\resources\\static\\images\\ursinus.png");

        model.addAttribute("asciiart", asciiart);
        return "ascii";
    }
}