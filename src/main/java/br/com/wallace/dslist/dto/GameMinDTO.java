package br.com.wallace.dslist.dto;

import br.com.wallace.dslist.entities.Game;
import br.com.wallace.dslist.projections.GameMinProjection;

public record GameMinDTO(Long id, String title, Integer year, String imgUrl, String shortDescription) {
    public GameMinDTO(Game entity){
        this(entity.getId(), entity.getTitle(), entity.getYear(), entity.getImgUrl(), entity.getShortDescription());
    }

    public GameMinDTO(GameMinProjection entity){
        this(entity.getId(), entity.getTitle(), entity.getGameYear(), entity.getImgUrl(), entity.getShortDescription());
    }

}
