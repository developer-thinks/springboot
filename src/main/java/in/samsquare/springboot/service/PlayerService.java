package in.samsquare.springboot.service;


import java.util.List;

import in.samsquare.springboot.dto.PlayerDTO;
import in.samsquare.springboot.model.Player;

public interface PlayerService {
    List<PlayerDTO> getAllPlayers();
    PlayerDTO getPlayerByJno(Long jno);
    Player getPlayerByFirstName(String firstName);
    String registerPlayer(Player player);
    List<Player> registerMultiplePlayers(List<Player> players);
    Player updatePlayer(Long jno, Player player);

    String deletePlayer(Long jno);
}
