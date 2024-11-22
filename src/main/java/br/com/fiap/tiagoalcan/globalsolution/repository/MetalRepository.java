package br.com.fiap.tiagoalcan.globalsolution.repository;

import br.com.fiap.tiagoalcan.globalsolution.model.Metal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MetalRepository extends JpaRepository<Metal, Long> {
    List<Metal> findByNomeContainingIgnoreCase(String nome);
}