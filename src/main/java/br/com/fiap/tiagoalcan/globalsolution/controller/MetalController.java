package br.com.fiap.tiagoalcan.globalsolution.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.tiagoalcan.globalsolution.dtos.MetalResponseDto;
import br.com.fiap.tiagoalcan.globalsolution.dtos.MetalRequestCreateDto;
import br.com.fiap.tiagoalcan.globalsolution.dtos.MetalRequestUpdateDto;
import br.com.fiap.tiagoalcan.globalsolution.service.MetalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metais")
@Tag(name = "Metais", description = "API para gerenciamento de metais")
public class MetalController {

    @Autowired
    private MetalService service;

    @GetMapping
    @Operation(summary = "Lista todos os metais")
    public ResponseEntity<List<MetalResponseDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um metal por ID")
    public ResponseEntity<MetalResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/search")
    @Operation(summary = "Busca metais por nome")
    public ResponseEntity<List<MetalResponseDto>> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok(service.findByNome(nome));
    }

    @PostMapping
    @Operation(summary = "Cria um novo metal")
    public ResponseEntity<MetalResponseDto> create(@RequestBody MetalRequestCreateDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um metal existente")
    public ResponseEntity<MetalResponseDto> update(@PathVariable Long id, @RequestBody MetalRequestUpdateDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um metal")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}