package com.example.clickgame.controller;

import com.example.clickgame.model.PlayerScore;
import com.example.clickgame.repository.PlayerScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend
public class PlayerScoreController {

    @Autowired
    private PlayerScoreRepository repository;

    @PostMapping
    public PlayerScore saveScore(@RequestBody PlayerScore playerScore) {
        return repository.save(playerScore);
    }

    @GetMapping("/top5")
    public List<PlayerScore> getTop5Scores() {
        return repository.findTop5ByOrderByScoreDesc();
    }
}
