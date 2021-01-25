package br.com.shopping.shopping_app_java.services;


import java.util.List;

import br.com.shopping.shopping_app_java.model.Loja;
import br.com.shopping.shopping_app_java.repositories.LojaRepository;
import br.com.shopping.shopping_app_java.repositories.SegmentoRepository;

public class LojaService {

	LojaRepository lojaRepository = new LojaRepository();
	SegmentoRepository segmentoRepository= new SegmentoRepository();

	public List<Loja> getAllLoja() {
		
		List<Loja> listaLoja = lojaRepository.getAllLoja();
		if(listaLoja!=null) {
			return listaLoja;	
		}else {
			return null;
		}
		
	}

	public String saveLoja(Loja loja) {
		String sit = "";
		String seg="";
		if (loja != null) {
			
			sit = lojaRepository.saveLoja(loja);
			return sit +seg;
		} else {
			return "Dados inválidos";
		}

	}

	public String updateLoja(Long id, Loja newLoja) {

		Loja loja = lojaRepository.getLoja(id);
		loja.setNome(newLoja.getNome());
		loja.setCnpj(newLoja.getCnpj());
		loja.setPiso(newLoja.getPiso());
		loja.setNumero(newLoja.getNumero());
//		loja.setSegmento(newLoja.getSegmento());
//		loja.setSituacao(newLoja.getSituacao());

		return lojaRepository.updateLoja(loja);
	}

	public String deleteLoja(Long id) {
		lojaRepository.deleteLoja(id);
		return "Cadastro excluido com sucesso!!";
	}

}
