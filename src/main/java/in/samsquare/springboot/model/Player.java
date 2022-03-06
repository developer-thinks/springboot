package in.samsquare.springboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "players")
@AllArgsConstructor
@NoArgsConstructor
public class Player{

    @Id
    private Long jno;
    private String first_name;
    private String last_name;
    private Integer total_runs;
}