package in.samsquare.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.samsquare.springboot.dto.PlayerDTO;
import in.samsquare.springboot.model.Player;
import in.samsquare.springboot.service.PlayerService;

@CrossOrigin
@RestController
@RequestMapping("/icc/")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/getall")
    public List<PlayerDTO> getAll() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/get/{jno}")
    public PlayerDTO getPlayerbyJno(@PathVariable("jno") Long jno) {
        return playerService.getPlayerByJno(jno);
    }

    @GetMapping("/getbyname/{firstName}")
    public Player getPlayerByFirstName(@PathVariable("firstName") String firstName) {
        return playerService.getPlayerByFirstName(firstName);
    }

    @PostMapping("/new/player")
    public String registerPlayer(@RequestBody Player player) {
        return playerService.registerPlayer(player);
    }

    @PostMapping("/new/players")
    public List<Player> registerMultiplePlayers(@RequestBody List<Player> players) {
        return playerService.registerMultiplePlayers(players);
    }

    @PutMapping("/update/{jno}")
    public Player updatePlayer(@PathVariable Long jno, @RequestBody Player player) {
        return playerService.updatePlayer(jno, player);
    }

    @DeleteMapping("/delete/{jno}")
    public String deleteByJno(@PathVariable("jno") Long jno) {
        return playerService.deletePlayer(jno);
    }

}
