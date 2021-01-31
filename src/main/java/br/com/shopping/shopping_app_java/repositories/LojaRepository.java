package br.com.shopping.shopping_app_java.repositories;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import br.com.shopping.shopping_app_java.model.Loja;
import br.com.shopping.shopping_app_java.model.dtos.LojaDTO;

 
 
public class LojaRepository {
 
	EntityManagerFactory emf;
	EntityManager em ;
	private String persistenceUnity="shopping";
	
	public Loja  saveLoja(Loja loja){
		
		emf =  Persistence.createEntityManagerFactory(persistenceUnity);
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(loja);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		return loja;
	}
 

	public String updateLoja(Loja loja){ 
		emf =  Persistence.createEntityManagerFactory(persistenceUnity);
		em = emf.createEntityManager();
		
		em.getTransaction().begin();		
		em.merge(loja);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return loja.toString();
	}
 
	

		@SuppressWarnings("unchecked")
		public List<LojaDTO> getAllLoja(){
		emf =  Persistence.createEntityManagerFactory(persistenceUnity);
		em = emf.createEntityManager();	
		
		String sql1="select id , nome,cnpj,numero,piso,situacao_id from loja;";		

		List<Loja> lista=em.createNativeQuery(sql1,Loja.class).getResultList();
		
		List<LojaDTO> listaDTO=new ArrayList<>();
		
		
		for (Loja loja : lista) {
			LojaDTO lojaDTO= new LojaDTO();
			lojaDTO.setId(loja.getId());
			lojaDTO.setNome(loja.getNome());
			listaDTO.add(lojaDTO);
			
			
		}
		
		em.close();
		emf.close();
		return listaDTO ;
	}
 

	public Loja getLoja(Long id){
		emf =  Persistence.createEntityManagerFactory(persistenceUnity);
		em = emf.createEntityManager();		
		
		Loja loja=em.find(Loja.class, id);		
		
		em.close();
		emf.close();
	
		return loja;
	}
 
	
	public void deleteLoja(Long id){
		
		emf =  Persistence.createEntityManagerFactory(persistenceUnity);		
		em = emf.createEntityManager();
		
		em.getTransaction().begin();		
		em.remove(em.find(Loja.class, id));		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
				 
	}
}
