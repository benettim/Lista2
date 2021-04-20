package br.fbb.lista2ex.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fbb.lista2ex.Models.Aluno;
import br.fbb.lista2ex.Models.Disciplina;
import br.fbb.lista2ex.Models.Matricula;
import br.fbb.lista2ex.Repositories.AlunoRepository;
import br.fbb.lista2ex.Repositories.DisciplinaRepository;
import br.fbb.lista2ex.Repositories.MatriculaRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/matricula")
public class Controller 
{
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	MatriculaRepository matriculaRepository;
	
	@GetMapping("/alunos")
	public List<Aluno> listaAlunos(){
		return alunoRepository.findAll();
	}
	
	@GetMapping("/disciplinas")
	public List<Disciplina> listaDisciplinas(){
		return disciplinaRepository.findAll();
	}
	
	@GetMapping("/matriculas")
	public List<Matricula> listaMatriculas(){
		return matriculaRepository.findAll();
	}
	
	@PostMapping("/cadastraraluno")
	public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@PostMapping("/cadastrardisciplina")
	public Disciplina cadastrarDisciplina(@RequestBody Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	@PostMapping("/cadastrarmatricula")
	public Matricula cadastrarMatricula(@RequestBody Matricula matricula) {
		return matriculaRepository.save(matricula);
	}
	
	@PutMapping("/alteraraluno/{id}")
	public Aluno alterarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
		Aluno a = alunoRepository.getOne(id);
		if(a == null) return null;
		a.setNome(aluno.getNome());
		return alunoRepository.save(a);
	}
	
	@PutMapping("/alterardisciplina/{id}")
	public Disciplina alterarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplina) {
		Disciplina d = disciplinaRepository.getOne(id);
		if(d == null) return null;
		d.setNome(disciplina.getNome());
		d.setQtd(disciplina.getQtd());
		return disciplinaRepository.save(d);
	}
	
	@PutMapping("/alterarmatricula/{id}")
	public Matricula alterarMatricula(@PathVariable Long id, @RequestBody Matricula matricula) {
		Matricula m = matriculaRepository.getOne(id);
		if(m == null) return null;
		m.setAluno(matricula.getAluno());
		m.setDisciplina(matricula.getDisciplina());
		return matriculaRepository.save(m);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletar(@PathVariable Long id) {
		matriculaRepository.deleteById(id);
	}
	
	
}

