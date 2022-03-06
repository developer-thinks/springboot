package in.samsquare.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.samsquare.springboot.DAO.PlayerDAO;
import in.samsquare.springboot.model.Player;

@RestController
public class PlayerController {

    @Autowired
    private PlayerDAO pdao;

    @GetMapping("/players")
    public List<Player> getPlayers() {
        return pdao.getAll();
    }

    @DeleteMapping("/players/{id}")
    public String deletePlayer(@PathVariable int id) {
        return pdao.delete(id) + " row Deleted";
    }

    @PostMapping("/players")
    public int savePlayer(@RequestBody List<Player> player) {
        return pdao.save(player);
    }

    @PutMapping("/players/{id}")
    public String update(@RequestBody Player player, @PathVariable int id) {
        return pdao.update(player, id) + " row updated";
    }

    @GetMapping("/players/{id}")
    public Player getPlayer(@PathVariable int id) {
        return pdao.getPlayerById(id);
    }

}
