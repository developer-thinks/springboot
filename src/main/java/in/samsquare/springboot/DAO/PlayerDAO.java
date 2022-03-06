package in.samsquare.springboot.DAO;
import java.util.List;
import in.samsquare.springboot.model.Player;

public interface PlayerDAO {

    int save(List<Player> player);

    int update(Player player, int id);

    int delete(int id);

    List<Player> getAll();

    Player getPlayerById(int id);

}
