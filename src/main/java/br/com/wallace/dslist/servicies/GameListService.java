package br.com.wallace.dslist.servicies;

import br.com.wallace.dslist.dto.GameListDTO;
import br.com.wallace.dslist.entities.GameList;
import br.com.wallace.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> games = gameListRepository.findAll();
        return games.stream().map(GameListDTO::new).toList();
    }
}
