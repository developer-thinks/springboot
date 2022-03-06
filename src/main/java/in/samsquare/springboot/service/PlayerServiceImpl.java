package in.samsquare.springboot.service;

import in.samsquare.springboot.dto.PlayerDTO;
import in.samsquare.springboot.exceptions.EmptyTransaction;
import in.samsquare.springboot.exceptions.MissingParameters;
import in.samsquare.springboot.model.Player;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public List<PlayerDTO> getAllPlayers() {
        try {
            List<Player> players = (List<Player>) entityManager.createNativeQuery("Select * From players",Player.class)
                    .getResultList();
            return players.stream()
                    .map(this::convertEntityToDTO)
                    .collect(Collectors.toList());
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
//    private PlayerDTO convertEntityToDTO(Player player){
//        PlayerDTO playerDTO = new PlayerDTO();
//        playerDTO.setJno(player.getJno());
//        playerDTO.setFirstName(player.getFirstName());
//        return playerDTO;
//    }

    private PlayerDTO convertEntityToDTO(Player player){
//        modelMapper.getConfiguration()
//                .setMatchingStrategy(MatchingStrategies.LOOSE);
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO = modelMapper.map(player, PlayerDTO.class);
        return playerDTO;
    }

    //converting DTO to Entity.
//    private Player convertDTOToEntity(PlayerDTO playerDTO){
//        Player player = new Player();
//        player = modelMapper.map(playerDTO,Player.class);
//        return player;
//    }

    @Transactional
    @Override
    public PlayerDTO getPlayerByJno(Long jno){
        try {
            Player player = new Player();
            player = (Player) entityManager.createNativeQuery("SELECT * from players  where jno=?",Player.class)
                    .setParameter(1,jno)
                    .getSingleResult();
            return mapperToDTO(player);
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    private PlayerDTO mapperToDTO(Player player){

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        PlayerDTO playerDTO = new PlayerDTO();
        modelMapper.map(player, PlayerDTO.class);
//        playerDTO.setJno(player.getJno());
//        playerDTO.setFirstName(player.getFirstName());
//        System.out.println("From Mapper");
        return  playerDTO;
    }

    @Transactional
    @Override
    public Player getPlayerByFirstName(String firstName){
        try {
            Query query = entityManager.createNativeQuery("SELECT * FROM players WHERE first_name=?",Player.class);
            query.setParameter(1,firstName);
            Player result = (Player) query.getSingleResult();
            return result;
        } catch (Exception emp){
            System.out.println(emp.getMessage());
            return new Player();
        }
    }

    @Transactional
    @Override
    public String deletePlayer(Long jno) {
        try {
            return entityManager.createNativeQuery("DELETE FROM players where jno=?")
                    .setParameter(1,jno)
                    .executeUpdate() == 1 ? "Deleted" : "Not found";
        } catch (Exception e){
            System.out.println(e);
            return "Not deleted";
        }
    }


    @Transactional
    @Override
    public String registerPlayer(Player player) {
        String message="";
        try {
            if(player.getFirstName() == null || player.getLastName() == null || player.getJno() == null ){
                throw new MissingParameters("Missing fields in request body");
            }
            Query query = entityManager.createNativeQuery("INSERT INTO players VALUES(?,?, ?, ?) ")
                    .setParameter(1,player.getJno())
                    .setParameter(2,player.getFirstName())
                    .setParameter(3,player.getLastName())
                    .setParameter(4,player.getRuns());
            query.executeUpdate();
            message="Successfully inserted";
            return message;
        } catch (IllegalArgumentException e){
            throw new MissingParameters("Missing parameters in request body");
        }
    }

    @Transactional
    @Override
    public List<Player> registerMultiplePlayers(List<Player> players) {
        try {
            List<Player> resultList = new ArrayList<>();
            for (Player player : players){
                if(player.getFirstName() == null || player.getLastName() == null || player.getJno() == null )
                    throw new EmptyTransaction("601", "Provide all fields");
                Query query = entityManager.createNativeQuery("INSERT INTO players VALUES(?,?, ?, ?) ")
                        .setParameter(1,player.getJno())
                        .setParameter(2,player.getFirstName())
                        .setParameter(3,player.getLastName())
                        .setParameter(4,player.getRuns());
                query.executeUpdate();
                resultList.add(player);
            }
            return resultList;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Transactional
    @Override
    public Player updatePlayer(Long jno, Player player) {
        try {
            if(jno == null) throw new MissingParameters("Invalid id");
            try {
//                Player pl = getPlayerByJno(jno);
//                if(pl == null) throw new MissingParameters("Player dosen't exist");
            } catch (IllegalArgumentException e){
                System.out.println(e);
            }
            Query query = entityManager.createNativeQuery("UPDATE players SET first_name=?, last_name=?, runs=? WHERE jno=? ", Player.class)
                    .setParameter(1,player.getFirstName())
                    .setParameter(2,player.getLastName())
                    .setParameter(3,player.getRuns())
                    .setParameter(4,jno);
            query.executeUpdate();
            player.setJno(jno);
            return player;
        } catch (IllegalArgumentException e){
            throw new MissingParameters("Something went wrong");
        }
    }
}