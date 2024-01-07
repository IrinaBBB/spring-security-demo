
package com.eazybytes.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/myCards")
    public String getAccountDialog() {
        return "Here are the cards details from the DB";
    }
}
