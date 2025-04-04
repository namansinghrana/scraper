package com.example.scraper.controller;


import com.example.scraper.dto.AlaiResponse;
import com.example.scraper.dto.FirecrawlResponse;
import com.example.scraper.service.ScrapeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ScrapeController {
    private final ScrapeService scrapeService;

    @PostMapping("/scrape-and-present")
    public ResponseEntity<?> scrapeAndPresent(@RequestParam String url) {
        FirecrawlResponse response = scrapeService.scrapeWebsite(url);

        if (response == null || response.getData() == null || !response.getData().containsKey("text")) {
            return ResponseEntity.badRequest().body("No text found in scraped data.");
        }

        String content = response.getData().get("text").toString();
        AlaiResponse presentation = scrapeService.createPresentation("Generated Presentation", content);
        return ResponseEntity.ok(presentation);
    }


}
