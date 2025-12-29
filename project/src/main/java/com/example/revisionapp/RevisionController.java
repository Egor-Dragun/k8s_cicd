package com.example.revisionapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RevisionController {

    @GetMapping("/revision")
    public String getRevision() {
        return "ПРИВЕТ!!!";
    }
}
