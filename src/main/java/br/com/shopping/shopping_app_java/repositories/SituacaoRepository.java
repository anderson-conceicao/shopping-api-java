package br.com.shopping.shopping_app_java.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import br.com.shopping.shopping_app_java.model.Situacao;
 

 
 
public class SituacaoRepository {
	

 
	EntityManagerFactory emf;
	EntityManager em ;
	
	public String  saveSituacao(Situacao situacao){
		
		emf =  Persistence.createEntityManagerFactory("shopping");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(situacao);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		return situacao.toString();
	}
 

	public String updateSituacao(Situacao situacao){ 
		emf =  Persistence.createEntityManagerFactory("shopping");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(situacao);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return situacao.toString();
	}
 
	
	@SuppressWarnings("unchecked")
	@Transactional
		public List<Situacao> getAllSituacao(){
		emf =  Persistence.createEntityManagerFactory("shopping");
		em = emf.createEntityManager();
		
		List<Situacao> lista=em.createNativeQuery("select s.id, s.nome from situacao s order by s.nome").getResultList();
		
		em.close();
		emf.close();
		return lista ;
	}
 
	@Transactional
	public Situacao getSituacao(Long id){
		emf =  Persistence.createEntityManagerFactory("shopping");
		em = emf.createEntityManager();
		
		Situacao situacao=em.find(Situacao.class, id);
		
		em.close();
		emf.close();
	
		return situacao;
	}
 
	
	public String deleteSituacao(Long id){
		

		emf =  Persistence.createEntityManagerFactory("shopping");		
		em = emf.createEntityManager();
		em.getTransaction().begin();	
		em.remove(em.find(Situacao.class, id));
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "excluido com sucesso!!";
 
	}
}
