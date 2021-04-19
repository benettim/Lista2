package br.fbb.lista2ex.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fbb.lista2ex.Models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
}
