package br.com.fiap.tiagoalcan.globalsolution.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Metal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, length = 8)
    private String descricao;

    @Column(nullable = false, length = 60)
    private String propriedades;

    @Column(nullable = false, length = 10)
    private String funcao;
    
}
