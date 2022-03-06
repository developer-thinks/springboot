package in.samsquare.springboot.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "players")
public class Player {

    public Player() {
    }

    public Player(Long jno, String firstName, String lastName, Integer runs) {
        this.jno = jno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.runs = runs;
    }

    @Id
    private Long jno;
    private String firstName;
    private String lastName;
    private Integer runs;


    public Long getJno() {
        return this.jno;
    }

    public void setJno(Long jno) {
        this.jno = jno;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getRuns() {
        return this.runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

}    
