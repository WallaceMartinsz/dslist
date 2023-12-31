package br.com.wallace.dslist.controllers;

import br.com.wallace.dslist.dto.GameListDTO;
import br.com.wallace.dslist.dto.GameMinDTO;
import br.com.wallace.dslist.dto.ReplacementDTO;
import br.com.wallace.dslist.servicies.GameListService;
import br.com.wallace.dslist.servicies.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping("/{listId}/games")
    public List<GameMinDTO> findGames(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.sourceIndex(), body.destinationIndex());
    }

}
