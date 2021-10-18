package com.example.sping_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.stream.Collectors;

@Controller
public class Stats {
    public String getInfo() throws Exception {
        URL url = new URL("https://api.spotify.com/v1/playlists/5mmiPNxhTe9lS66KjakoXP");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setDoOutput(true);
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        connection.setRequestProperty("Authorization", "Bearer " + "BQDhJoWu1KpU6JPV4F3cioARklRb4rUpgeflnLErL0eFZ7GSKKxBT_LeE2boVH9BXoDGrpGRtVrkRPSafeTrB3JjQQ4grHhytEXBjzLa6FyF6GJOig_TwOnUr6efaizXk2s-LsIqnSLnASJ96L25VDXTY-IFfKjRv7wxa6obi0i1lTS-4UPczQhjlIHiEskSicfjijEF6C_2rJpgWs4NkMCIW8-S2XS4vj1f-tWUAfaF6KG_wKcNDMah9eeWtl2JcN2hysdq50LCmUSImuF17eazaDkuH1tfMg5Dc_g0hz1x");

        InputStream response = connection.getInputStream();
        String result = new BufferedReader(new InputStreamReader(response)) .lines().collect(Collectors.joining("\n"));
        
        return result;
      }

    @GetMapping("/stats")
    public String stats(@RequestParam(required=false, defaultValue="") String link, Model model) throws Exception {

        System.out.println(getInfo());

        model.addAttribute("link", link);
        return "stats";
    }
}
