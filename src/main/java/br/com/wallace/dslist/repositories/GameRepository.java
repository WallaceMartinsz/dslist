package br.com.wallace.dslist.repositories;

import br.com.wallace.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
