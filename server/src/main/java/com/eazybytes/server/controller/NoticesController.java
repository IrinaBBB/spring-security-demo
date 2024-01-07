package com.eazybytes.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("/notices")
    public String getAccountDialog() {
        return "Here are the notices details from the DB";
    }
}
