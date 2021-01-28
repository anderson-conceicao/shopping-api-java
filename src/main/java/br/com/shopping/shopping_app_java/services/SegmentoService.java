package br.com.shopping.shopping_app_java.services;

import java.util.List;


import br.com.shopping.shopping_app_java.model.Segmento;

import br.com.shopping.shopping_app_java.repositories.SegmentoRepository;
import br.com.shopping.shopping_app_java.services.exceptions.DataIntegrityException;
import br.com.shopping.shopping_app_java.services.exceptions.ObjectNotFoundException;

public class SegmentoService {

	SegmentoRepository segmentoRepository = new SegmentoRepository();

	public List<Segmento> getAllSegmento() {
		return segmentoRepository.getAllSegmento();
	}

	public Segmento saveSegmento(Segmento segmento) {
		segmento.setId(null);
		return segmentoRepository.saveSegmento(segmento);

	}

	public String updateSegmento(Long id, Segmento newSegmento)   {
		getSegmento(id);
		Segmento segmento = segmentoRepository.getSegmento(id);
		segmento.setNome(newSegmento.getNome());

		return segmentoRepository.updateSegmento(segmento);
	}

	public void deleteSegmento(Long id) throws DataIntegrityException {

		getSegmento(id);
		try {
			segmentoRepository.deleteSegmento(id);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException("Não é possivel excluir porque há entidades relacionadas.");
		}

	}

	public Segmento getSegmento(Long id) throws ObjectNotFoundException {
		Segmento obj = new Segmento();

		try {
			obj = segmentoRepository.getSegmento(id);

		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Segmento não encontrado!!" + e.getMessage());
		}
		return obj;
	}

}
