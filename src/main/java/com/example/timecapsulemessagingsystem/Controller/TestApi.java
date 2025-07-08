package com.example.timecapsulemessagingsystem.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestApi {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/languages")
    public Map<String, Double> getRepoLanguages(@RequestParam String repoUrl) {
        String[] parts = repoUrl.replace("https://github.com/", "").split("/");
        String owner = parts[0];
        String repo = parts[1];

        String apiUrl = "https://api.github.com/repos/" + owner + "/" + repo + "/languages";
        Map<String, Integer> response = restTemplate.getForObject(apiUrl, Map.class);

        if (response == null || response.isEmpty()) {
            throw new RuntimeException("No language data found");
        }

        int totalBytes = response.values().stream().mapToInt(Integer::intValue).sum();

        return response.entrySet().stream()
                .collect(java.util.stream.Collectors.toMap(
                        Map.Entry::getKey,
                        e -> (e.getValue() * 100.0) / totalBytes
                ));
    }
}
