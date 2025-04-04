package com.example.scraper.service;


import com.example.scraper.dto.AlaiResponse;
import com.example.scraper.dto.FirecrawlResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ScrapeService {
    private final RestTemplate restTemplate = new RestTemplate();

    public FirecrawlResponse scrapeWebsite(String url) {
        String endpoint = "https://api.firecrawl.dev/v1/scrape";
        Map<String, String> body = Map.of("url", url);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(body);
        return restTemplate.postForObject(endpoint, request, FirecrawlResponse.class);
    }

    public AlaiResponse createPresentation(String title, String content) {
        String endpoint = "https://alai-standalone-backend.getalai.com/create-new-presentation";
        Map<String, String> body = Map.of("title", title, "content", content);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(body);
        return restTemplate.postForObject(endpoint, request, AlaiResponse.class);
    }

}
