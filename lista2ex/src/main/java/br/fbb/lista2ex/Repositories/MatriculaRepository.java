package br.fbb.lista2ex.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fbb.lista2ex.Models.Aluno;
import br.fbb.lista2ex.Models.Disciplina;
import br.fbb.lista2ex.Models.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
	public long countByDisciplina(Disciplina disciplina);
	
	public long countByDisciplinaAndAluno(Disciplina disciplina, Aluno aluno);
}
