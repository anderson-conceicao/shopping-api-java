package br.com.shopping.shopping_app_java.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import br.com.shopping.shopping_app_java.model.Segmento;


 

 
 
public class SegmentoRepository {
 
	EntityManagerFactory emf;
	EntityManager em ;
	
	public String  saveSegmento(Segmento segmento){
		
		emf =  Persistence.createEntityManagerFactory("shopping");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(segmento);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		return segmento.toString();
	}
 

	public String updateSegmento(Segmento segmento){ 
		emf =  Persistence.createEntityManagerFactory("shopping");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(segmento);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return segmento.toString();
	}
 
	
	@SuppressWarnings("unchecked")
	@Transactional
		public List<Segmento> getAllSegmento(){
		emf =  Persistence.createEntityManagerFactory("shopping");
		em = emf.createEntityManager();
		
		List<Segmento> lista=em.createNativeQuery("select s.id, s.nome from segmento s order by s.nome").getResultList();
		
		em.close();
		emf.close();
		return lista ;
	}
 
	@Transactional
	public Segmento getSegmento(Long id){
		emf =  Persistence.createEntityManagerFactory("shopping");
		em = emf.createEntityManager();
		
		Segmento segmento=em.find(Segmento.class, id);
		
		em.close();
		emf.close();
		return segmento;
	}
 
	
	public void deleteSegmento(Long id){

		
		emf =  Persistence.createEntityManagerFactory("shopping");		
		em = emf.createEntityManager();
		em.getTransaction().begin();	
		em.remove(em.find(Segmento.class, id));
		em.getTransaction().commit();
		em.close();
		emf.close();
 
	}
}
