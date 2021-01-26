package br.com.shopping.shopping_app_java.repositories;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import br.com.shopping.shopping_app_java.model.Loja;
import br.com.shopping.shopping_app_java.model.Segmento;

 

 
 
public class LojaRepository {
 
	EntityManagerFactory emf;
	EntityManager em ;
	
	public String  saveLoja(Loja loja){
		
		emf =  Persistence.createEntityManagerFactory("shopping");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(loja);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		return loja.toString();
	}
 

	public String updateLoja(Loja loja){ 
		emf =  Persistence.createEntityManagerFactory("shopping");
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(loja);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return loja.toString();
	}
 
	
	@SuppressWarnings("unchecked")
	@Transactional
		public List<Loja> getAllLoja(){
		emf =  Persistence.createEntityManagerFactory("shopping");
		em = emf.createEntityManager();
//		
		String sql1="select id , nome,cnpj,numero,piso,CASE WHEN situacao = 1 THEN 'ativa' when situacao=0 then 'inativa' end as situacao from loja;";
		List<Loja> lista=em.createNativeQuery(sql1,Loja.class).getResultList();
		
		for (Loja loja : lista) {
			String sql2="select s.id,s.nome from segmento s ,loja_segmento ls where ls.segmento_id=s.id and ls.loja_id="+loja.getId()+"";
			List<Segmento> listaSeg=em.createNativeQuery(sql2,Segmento.class).getResultList();
			loja.setSegmentos(listaSeg);
			
		}
		
		em.close();
		emf.close();
		return lista ;
	}
 
	@Transactional
	public Loja getLoja(Long id){
		emf =  Persistence.createEntityManagerFactory("shopping");
		em = emf.createEntityManager();
		
		Loja loja=em.find(Loja.class, id);
		
		em.close();
		emf.close();
	
		return loja;
	}
 
	
	public String deleteLoja(Long id){
		

		emf =  Persistence.createEntityManagerFactory("shopping");		
		em = emf.createEntityManager();
		em.getTransaction().begin();	
		em.remove(em.find(Loja.class, id));
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "excluido com sucesso!!";
 
	}
}
