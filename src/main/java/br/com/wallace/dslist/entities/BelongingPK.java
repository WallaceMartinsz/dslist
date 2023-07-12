package br.com.wallace.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    @EqualsAndHashCode.Include
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    @EqualsAndHashCode.Include
    private GameList list;

}
