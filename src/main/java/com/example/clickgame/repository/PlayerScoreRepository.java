package com.example.clickgame.repository;

import com.example.clickgame.model.PlayerScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerScoreRepository extends JpaRepository<PlayerScore, Long> {

    // Custom query to get top 5 by score descending
    @Query("SELECT p FROM PlayerScore p ORDER BY p.score DESC LIMIT 5")
    List<PlayerScore> findTop5ByOrderByScoreDesc();
}
