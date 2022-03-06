package in.samsquare.springboot.DAO;
import in.samsquare.springboot.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class playerDAOImpl implements PlayerDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int save(List<Player> player) {
        int i=0;
        for(Player pl : player){
            i++;
            jdbcTemplate.update("INSERT INTO player (name, city) VALUES (?,?)", new Object[]{pl.getName(), pl.getCity()});
        }
        return i;
    }

    @Override
    public int update(Player player, int id) {
        return jdbcTemplate.update("UPDATE player set name=? , city=? WHERE id = ? ", new Object[]{player.getName(), player.getCity(), id});
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from player where id= ?", id);
    }

    @Override
    public List<Player> getAll() {
        return jdbcTemplate.query("SELECT * FROM player", new BeanPropertyRowMapper<Player>(Player.class));
    }

    @Override
    public Player getPlayerById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM player where id = ?",new BeanPropertyRowMapper<Player>(Player.class), id);
    }
}
