package in.samsquare.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.samsquare.springboot.model.Player;
import in.samsquare.springboot.repository.PlayerRepository;

@RestController
@RequestMapping("/icc/")
@CrossOrigin
public class PlayerController{


    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/")
    public String welcomeNote() {
        return "welcome to ICC";
    }

    @GetMapping("/allplayers")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

}