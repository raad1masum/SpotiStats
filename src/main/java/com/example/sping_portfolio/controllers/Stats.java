package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.json.JSONObject;

@Controller
public class Stats {
    public String getToken() throws Exception {
        URLConnection connection = new URL("https://accounts.spotify.com/api/token").openConnection();

        connection.setDoOutput(true);
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("Authorization", "Basic NzVhOGQzOTU3NmMyNDRhYmIzYmM1OWJiY2VhZTNiNzY6MjgxOWQwMThkNmUxNGEwNGIyMTJjODQxOGI0YTBlZjI=");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + "UTF-8");

        try (OutputStream output = connection.getOutputStream()) {
            output.write("grant_type=client_credentials".getBytes(StandardCharsets.UTF_8));
        }

        InputStream response = connection.getInputStream();
        String result = new BufferedReader(new InputStreamReader(response)) .lines().collect(Collectors.joining("\n"));

        JSONObject obj = new JSONObject(result);
        return obj.getString("access_token");
    }

    public String getInfo(String token) throws Exception {
        URL url = new URL("https://api.spotify.com/v1/playlists/5mmiPNxhTe9lS66KjakoXP");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoOutput(true);
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("Authorization", "Bearer " + token);

        InputStream response = connection.getInputStream();
        String result = new BufferedReader(new InputStreamReader(response)) .lines().collect(Collectors.joining("\n"));
        
        return result;
      }

    @GetMapping("/stats")
    public String stats(@RequestParam(required=false, defaultValue="") String link, Model model) throws Exception {

        System.out.println(getInfo(getToken()));

        model.addAttribute("link", link);
        return "stats";
    }
}
