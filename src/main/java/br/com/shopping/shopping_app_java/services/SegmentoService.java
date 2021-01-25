package br.com.shopping.shopping_app_java.services;


import java.util.List;

import br.com.shopping.shopping_app_java.model.Segmento;

import br.com.shopping.shopping_app_java.repositories.SegmentoRepository;


public class SegmentoService {
	
	SegmentoRepository segmentoRepository=new SegmentoRepository();

	

	public List<Segmento> getAllSegmento() {
		List<Segmento> listaSegmento = segmentoRepository.getAllSegmento();		
		return listaSegmento;
	}
	
	public String saveSegmento(Segmento segmento) {
		String sit="";
					
			if(segmento!=null) {
				sit=segmentoRepository.saveSegmento(segmento);
				return sit;
			}else {
				return "Dados inválidos";
			}	
			
	
	}
	
	public String updateSegmento(Long id, Segmento newSegmento) {
	
		Segmento segmento=segmentoRepository.getSegmento(id);
		segmento.setNome(newSegmento.getNome());
		
		return segmentoRepository.updateSegmento(segmento);
	}
	
	public String deleteSegmento(Long id) {
		try {
			segmentoRepository.deleteSegmento(id);
			return "Cadastro excluido com sucesso!!";
		}catch (Exception e) {
			return "Erro ao excluir!!"+e.getMessage();
		}
		
	}

}
