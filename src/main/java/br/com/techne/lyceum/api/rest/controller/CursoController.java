package br.com.techne.lyceum.api.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.techne.lyceum.api.rest.Curso;
import techne.data.DataMap;
import techne.lyceum.aonline.wap.servico.ServicoWAP;
import techne.lyceum.nucleo.modelo.Aluno;

@RestController
public class CursoController {

	@Autowired
	ServicoWAP servicoWAP;

	private List<Curso> lista = new ArrayList<Curso>();

	@RequestMapping(value = "/cursos", method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> listar() {

		return new ResponseEntity<List<Curso>>(lista, HttpStatus.OK);
	}

	@RequestMapping(value = "/cursos/add", method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> add() {

		Curso curso1 = new Curso(1, "Curso 1");
		Curso curso2 = new Curso(2, "Curso 2");
		Curso curso3 = new Curso(3, "Curso 3");

		lista.add(curso1);
		lista.add(curso2);
		lista.add(curso3);

		return new ResponseEntity<List<Curso>>(lista, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/cursos/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") int id) {

		Curso greeting = lista.remove(id);

		if (greeting == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/alunos", method = RequestMethod.GET)
	public List<Aluno> alunos() {

		List<DataMap> listaAlunosMap = servicoWAP.buscarAlunosRelacionados((long) 1);

		if (listaAlunosMap == null || listaAlunosMap.isEmpty()) {
			return new ArrayList<Aluno>();
		} else {
			List<Aluno> listaAlunos = new ArrayList<Aluno>();
			for (DataMap alunoMap : listaAlunosMap) {
				listaAlunos.add(mapearAlunoMapParaAluno(alunoMap));
			}
			return listaAlunos;
		}
	}

	private static Aluno mapearAlunoMapParaAluno(DataMap alunoMap) {
		if (alunoMap == null)
			return null;
		Aluno aluno = new Aluno();
		aluno.setCodAluno(alunoMap.getString("codigoAluno"));
		return aluno;
	}

}