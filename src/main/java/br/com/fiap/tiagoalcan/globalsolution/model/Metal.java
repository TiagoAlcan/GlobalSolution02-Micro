package br.com.fiap.tiagoalcan.globalsolution.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "metais")
@Entity
public class Metal {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 20)
    private String nome;

    @Column(nullable = false, length = 100)
    private String descricao;

    @Column(nullable = false, length = 100)
    private String propriedades;

    @Column(nullable = false, length = 100)
    private String funcao;
    
}
