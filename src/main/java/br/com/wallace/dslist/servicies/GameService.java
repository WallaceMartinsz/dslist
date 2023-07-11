package br.com.wallace.dslist.servicies;

import br.com.wallace.dslist.dto.GameMinDTO;
import br.com.wallace.dslist.entities.Game;
import br.com.wallace.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> games = gameRepository.findAll();
        return games.stream().map(GameMinDTO::new).toList();
    }
}
