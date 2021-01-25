package br.com.shopping.shopping_app_java.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import br.com.shopping.shopping_app_java.model.Loja;

 

 
 
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
		String sql="select l.id,l.cnpj,l.nome loja,l.numero, l.piso, l.segmento_id,sg.nome segmento,l.situacao_id,st.nome situacao from loja l, situacao st, segmento sg where l.segmento_id=sg.id and l.situacao_id=st.id";
	List<Loja> lista=em.createNativeQuery(sql).getResultList();
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
