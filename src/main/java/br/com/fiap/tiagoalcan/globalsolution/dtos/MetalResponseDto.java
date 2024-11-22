package br.com.fiap.tiagoalcan.globalsolution.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetalResponseDto {
    private Long id;
    private String nome;
    private String descricao;
    private String propriedades;
    private String funcao;
}
