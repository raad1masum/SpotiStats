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

import org.json.JSONArray;
import org.json.JSONObject;

@Controller
public class Stats {
    public String getId(String link) {
        String output = link;

        output = output.replaceAll("https://open.spotify.com/playlist/", "");
        output = output.substring(0, output.indexOf("?"));

        return output;
    }

    public String getToken() throws Exception {
        URLConnection connection = new URL("https://accounts.spotify.com/api/token").openConnection();

        connection.setDoOutput(true);
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("Authorization", "Basic NDQ5ZGM3NjJiZDg0NDBjMzkwOWQyZGZiMThkYzZmMjI6ZTQwMjFjMTk1Nzc2NDM2YTg0MzQxZDM5ZGQyMzBkN2M=");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + "UTF-8");

        try (OutputStream output = connection.getOutputStream()) {
            output.write("grant_type=client_credentials".getBytes(StandardCharsets.UTF_8));
        }

        InputStream response = connection.getInputStream();
        String result = new BufferedReader(new InputStreamReader(response)) .lines().collect(Collectors.joining("\n"));

        JSONObject obj = new JSONObject(result);
        return obj.getString("access_token");
    }

    public String getData(String token, String id) throws Exception {
        URL url = new URL("https://api.spotify.com/v1/playlists/" + id);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoOutput(true);
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("Authorization", "Bearer " + token);

        InputStream response = connection.getInputStream();
        String result = new BufferedReader(new InputStreamReader(response)) .lines().collect(Collectors.joining("\n"));
        
        return result;
    }

    public String getInfo(String info, String data) {
        JSONObject obj = new JSONObject(data);

        return obj.getString(info);
    }

    public double getExplicitPercent(JSONObject obj) {
        JSONArray tracks = obj.getJSONObject("tracks").getJSONArray("items");

        double count = 0;
        double total = tracks.length();

        for (int i = 0; i < tracks.length(); i++) {
            if (tracks.getJSONObject(i).getJSONObject("track").getBoolean("explicit"))
                ++count;
        }

        double percent = count / total * 100;

        return Math.round(percent * 100.0) / 100.0;
    }

    @GetMapping("/stats")
    public String stats(@RequestParam(required=false, defaultValue="") String link,
        @RequestParam(required=false, defaultValue="") String name,
        @RequestParam(required=false, defaultValue="") String image,
        @RequestParam(required=false, defaultValue="") String description,
        @RequestParam(required=false, defaultValue="") String followers,
        @RequestParam(required=false, defaultValue="") String owner,
        @RequestParam(required=false, defaultValue="") String songCount,
        @RequestParam(required=false, defaultValue="") String explicitPercentage,
        Model model) throws Exception {

        System.out.println(getId("https://open.spotify.com/playlist/6u6L0UwiSB3fZjuABeMTlW?si=cc5cf848fe7243f2"));

        String id = getId(link);
        String token = getToken();
        String data = getData(token, id);

        System.out.println(data);

        JSONObject obj = new JSONObject(data);

        name = getInfo("name", data);
        image = obj.getJSONArray("images").getJSONObject(0).getString("url");
        description = getInfo("description", data);
        followers = Integer.toString(obj.getJSONObject("followers").getInt("total"));
        owner = obj.getJSONObject("owner").getString("display_name");
        songCount = Integer.toString(obj.getJSONObject("tracks").getInt("total"));
        explicitPercentage = Double.toString(getExplicitPercent(obj)) + "%";

        System.out.println("Name: " + name);
        System.out.println("Image: " + image);
        System.out.println("Description: " + description);
        System.out.println("Followers: " + followers);
        System.out.println("Owner: " + owner);
        System.out.println("Song Count: " + songCount);
        System.out.println("Explicit Percentage: " + explicitPercentage);

        model.addAttribute("link", link);
        model.addAttribute("name", name);
        model.addAttribute("image", image);
        model.addAttribute("description", description);
        model.addAttribute("followers", followers);
        model.addAttribute("owner", owner);
        model.addAttribute("songCount", songCount);
        model.addAttribute("explicitPercentage", explicitPercentage);
        return "stats";
    }
}
