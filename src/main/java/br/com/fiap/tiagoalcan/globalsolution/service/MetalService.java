package br.com.fiap.tiagoalcan.globalsolution.service;

import br.com.fiap.tiagoalcan.globalsolution.dtos.MetalResponseDto;
import br.com.fiap.tiagoalcan.globalsolution.dtos.MetalRequestCreateDto;
import br.com.fiap.tiagoalcan.globalsolution.dtos.MetalRequestUpdateDto;
import br.com.fiap.tiagoalcan.globalsolution.mapper.MetalMapper;
import br.com.fiap.tiagoalcan.globalsolution.model.Metal;
import br.com.fiap.tiagoalcan.globalsolution.repository.MetalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetalService {

    @Autowired
    private MetalRepository repository;

    @Autowired
    private MetalMapper mapper;

    @Transactional(readOnly = true)
    public List<MetalResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MetalResponseDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Metal não encontrado com ID: " + id));
    }

    @Transactional(readOnly = true)
    public List<MetalResponseDto> findByNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public MetalResponseDto save(MetalRequestCreateDto createDto) {
        Metal metal = mapper.toEntity(createDto);
        Metal savedMetal = repository.save(metal);
        return mapper.toResponseDto(savedMetal);
    }

    @Transactional
    public MetalResponseDto update(Long id, MetalRequestUpdateDto updateDto) {
        Metal metal = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Metal não encontrado com ID: " + id));

        mapper.updateEntityFromDto(metal, updateDto);
        Metal updatedMetal = repository.save(metal);
        return mapper.toResponseDto(updatedMetal);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Metal não encontrado com ID: " + id);
        }
        repository.deleteById(id);
    }
}