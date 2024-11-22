package br.com.fiap.tiagoalcan.globalsolution.mapper;

import br.com.fiap.tiagoalcan.globalsolution.dtos.MetalRequestCreateDto;
import br.com.fiap.tiagoalcan.globalsolution.dtos.MetalRequestUpdateDto;
import br.com.fiap.tiagoalcan.globalsolution.dtos.MetalResponseDto;
import br.com.fiap.tiagoalcan.globalsolution.model.Metal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

    @Component
    public class MetalMapper {

        public MetalResponseDto toResponseDto(Metal metal) {
            return new MetalResponseDto(
                    metal.getId(),
                    metal.getNome(),
                    metal.getDescricao(),
                    metal.getPropriedades(),
                    metal.getFuncao()
            );
        }

        public Metal toEntity(MetalRequestCreateDto dto) {
            Metal metal = new Metal();
            metal.setNome(dto.getNome());
            metal.setDescricao(dto.getDescricao());
            metal.setPropriedades(dto.getPropriedades());
            metal.setFuncao(dto.getFuncao());
            return metal;
        }

        public void updateEntityFromDto(Metal metal, MetalRequestUpdateDto dto) {
            if (dto.getNome() != null) {
                metal.setNome(dto.getNome());
            }
            if (dto.getDescricao() != null) {
                metal.setDescricao(dto.getDescricao());
            }
            if (dto.getPropriedades() != null) {
                metal.setPropriedades(dto.getPropriedades());
            }
            if (dto.getFuncao() != null) {
                metal.setFuncao(dto.getFuncao());
            }
        }
    }
