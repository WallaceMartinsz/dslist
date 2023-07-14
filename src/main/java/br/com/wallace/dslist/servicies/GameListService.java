package br.com.wallace.dslist.servicies;

import br.com.wallace.dslist.dto.GameListDTO;
import br.com.wallace.dslist.entities.GameList;
import br.com.wallace.dslist.projections.GameMinProjection;
import br.com.wallace.dslist.repositories.GameListRepository;
import br.com.wallace.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> games = gameListRepository.findAll();
        return games.stream().map(GameListDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }


}
