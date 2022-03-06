package in.samsquare.springboot.repository;

import org.springframework.stereotype.Repository;

import in.samsquare.springboot.model.Player;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}