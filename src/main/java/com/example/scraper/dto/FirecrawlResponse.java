package com.example.scraper.dto;


import lombok.Data;

import java.util.Map;

@Data
public class FirecrawlResponse {
    private String id;

    private String status;
    private Map<String, Object> data;
}
