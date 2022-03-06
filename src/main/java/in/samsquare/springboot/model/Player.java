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
public class Player {
    private int id;
    private String name;
    private String city;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", city='" + getCity() + "'" +
            "}";
    }

    public Player() {
    }

    public Player(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

}