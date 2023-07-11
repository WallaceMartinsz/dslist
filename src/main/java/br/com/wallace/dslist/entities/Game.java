package br.com.wallace.dslist.entities;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tb_game")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(name = "game_year")
    private Integer year;
    private String genre;
    private String plataform;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

}
