package br.com.shopping.shopping_app_java.services;

import java.util.List;


import br.com.shopping.shopping_app_java.model.Situacao;

import br.com.shopping.shopping_app_java.repositories.SituacaoRepository;
import br.com.shopping.shopping_app_java.services.exceptions.DataIntegrityException;
import br.com.shopping.shopping_app_java.services.exceptions.ObjectNotFoundException;

public class SituacaoService {

	SituacaoRepository situacaoRepository = new SituacaoRepository();

	public List<Situacao> getAllSituacao() {
		return situacaoRepository.getAllSituacao();
	}

	public Situacao saveSituacao(Situacao situacao) {
		situacao.setId(null);
		return situacaoRepository.saveSituacao(situacao);

	}

	public String updateSituacao(Long id, Situacao newSituacao)  {
		getSituacao(id);
		Situacao situacao = situacaoRepository.getSituacao(id);
		situacao.setNome(newSituacao.getNome());

		return situacaoRepository.updateSituacao(situacao);
	}

	public void deleteSituacao(Long id)  {

		getSituacao(id);
		try {
			situacaoRepository.deleteSituacao(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Não é possivel excluir porque há entidades relacionadas.");
		}

	}

	public Situacao getSituacao(Long id)  {
		Situacao obj =  situacaoRepository.getSituacao(id);

		if (obj == null) {
			throw new ObjectNotFoundException("Situacao com id " + id + " não encontrada");
		}
		return obj;
	}

}
