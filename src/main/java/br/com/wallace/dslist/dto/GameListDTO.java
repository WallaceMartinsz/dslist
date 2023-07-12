package br.com.wallace.dslist.dto;

import br.com.wallace.dslist.entities.GameList;

public record GameListDTO(Long id, String name) {
    public GameListDTO(GameList entity){
        this(entity.getId(), entity.getName());
    }

}
