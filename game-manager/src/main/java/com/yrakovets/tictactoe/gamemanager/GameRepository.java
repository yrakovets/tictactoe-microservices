package com.yrakovets.tictactoe.gamemanager;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findTop1ByOrderByIdDesc();
}
