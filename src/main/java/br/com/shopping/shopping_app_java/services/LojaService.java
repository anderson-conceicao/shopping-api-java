package br.com.shopping.shopping_app_java.services;

import java.util.List;

import br.com.shopping.shopping_app_java.model.Loja;
import br.com.shopping.shopping_app_java.repositories.LojaRepository;
import br.com.shopping.shopping_app_java.repositories.SegmentoRepository;
import br.com.shopping.shopping_app_java.services.exceptions.DataIntegrityException;
import br.com.shopping.shopping_app_java.services.exceptions.ObjectNotFoundException;


public class LojaService {

	LojaRepository lojaRepository = new LojaRepository();
	SegmentoRepository segmentoRepository = new SegmentoRepository();

	public List<Loja> getAllLoja() {				
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
		loja.setTipoSituacao(newLoja.getTipoSituacao());
		return lojaRepository.updateLoja(loja);
	}

	public void deleteLoja(Long id) throws DataIntegrityException {
		
		 getLoja(id);
		try {
			lojaRepository.deleteLoja(id);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException("Não é possivel excluir porque há entidades relacionadas.");
		}
		
	}
	
	public Loja getLoja(Long id) throws ObjectNotFoundException {
		Loja obj=new Loja();
	    
	  try {
		   obj= lojaRepository.getLoja(id);
		
	} catch (ObjectNotFoundException e) {	
		throw new ObjectNotFoundException("Loja não encontrada!!"+e.getMessage());
	}
		return 	obj;	
	}
	

}
