package br.com.shopping.shopping_app_java.services;

import java.util.List;

import br.com.shopping.shopping_app_java.model.Loja;
import br.com.shopping.shopping_app_java.model.dtos.LojaDTO;
import br.com.shopping.shopping_app_java.repositories.LojaRepository;
import br.com.shopping.shopping_app_java.repositories.SegmentoRepository;
import br.com.shopping.shopping_app_java.services.exceptions.DataIntegrityException;
import br.com.shopping.shopping_app_java.services.exceptions.ObjectNotFoundException;

public class LojaService {

	LojaRepository lojaRepository = new LojaRepository();
	SegmentoRepository segmentoRepository = new SegmentoRepository();

	public List<LojaDTO> getAllLoja() {
		return lojaRepository.getAllLoja();
	}

	public Loja saveLoja(Loja loja) {
		loja.setId(null);
		lojaRepository.saveLoja(loja);
		return loja;

	}

	public String updateLoja(Long id, Loja newLoja) {

		getLoja(id);

		Loja loja = lojaRepository.getLoja(id);
		loja.setNome(newLoja.getNome());
		loja.setCnpj(newLoja.getCnpj());
		loja.setPiso(newLoja.getPiso());
		loja.setNumero(newLoja.getNumero());
		loja.setSegmentos(newLoja.getSegmentos());
		loja.setSituacao(newLoja.getSituacao());
		return lojaRepository.updateLoja(loja);
	}

	public void deleteLoja(Long id) {

		getLoja(id);
		try {
			lojaRepository.deleteLoja(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Não é possivel excluir porque há entidades relacionadas.");
		}

	}

	public Loja getLoja(Long id) {
		Loja obj = lojaRepository.getLoja(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Loja com id " + id + " não encontrada");
		}

		return obj;
	}

}
