package br.com.valedosjarros.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.valedosjarros.domain.dtos.request.departamento.CadastrarDepartamentoRequestDto;
import br.com.valedosjarros.domain.dtos.response.departamento.CadastrarDepartamentoResponseDto;
import br.com.valedosjarros.domain.entities.Departamento;
import br.com.valedosjarros.infrastructure.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public CadastrarDepartamentoResponseDto cadastrarDepartamento(CadastrarDepartamentoRequestDto request) {
		
		String nomeDepartamentoMinusculo = request.getNomeDepartamento().toLowerCase();
		String nomeFormatado = nomeDepartamentoMinusculo.substring(0, 1).toUpperCase() + nomeDepartamentoMinusculo.substring(1);
		
		var departamentoNovo = new Departamento();
		departamentoNovo.setNomeDepartamento(nomeFormatado);
		departamentoRepository.save(departamentoNovo);
		

		var response = new CadastrarDepartamentoResponseDto();
		response.setId(departamentoNovo.getIdDepartamento());
		response.setNomeDepartamento(departamentoNovo.getNomeDepartamento());
		response.setResposta("Departamento de " + departamentoNovo.getNomeDepartamento() + " cadastrado.");
		return response;
	}

}
