package br.com.shopping.shopping_app_java.services;

import java.util.List;

import br.com.shopping.shopping_app_java.model.Situacao;
import br.com.shopping.shopping_app_java.repositories.SituacaoRepository;

public class SituacaoService {

	SituacaoRepository situacaoRepository = new SituacaoRepository();

	public List<Situacao> getAllSituacao() {
		List<Situacao> listaSituacao = situacaoRepository.getAllSituacao();		
		return listaSituacao;
	}
	
	public String saveSituacao(Situacao situacao) {
		String sit="";
					
			if(situacao!=null) {
				sit=situacaoRepository.saveSituacao(situacao);
				return sit;
			}else {
				return "Dados inválidos";
			}	
			
	
	}
	
	public String updateSituacao(Long id, Situacao newSituacao) {
	
		Situacao situacao=situacaoRepository.getSituacao(id);
		situacao.setNome(newSituacao.getNome());
		
		return situacaoRepository.updateSituacao(situacao);
	}
	
	public String deleteSituacao(Long id) {
		situacaoRepository.deleteSituacao(id);
		return "Cadastro excluido com sucesso!!";
	}
	


}
