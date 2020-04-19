package model.persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import model.Articulo;
import model.Familia;
import model.persistencia.AbreCierra;

public class DaoArticulo {
	private EntityManager em;
	private AbreCierra ab;
	
	public DaoArticulo() {
		ab=new AbreCierra();
	}
	
	@SuppressWarnings("unchecked")
	public List<Articulo> listaArticulos(){
		List<Articulo> lista;
		em=ab.abrirConexion();
		if (em==null)
			return null;
		lista=em.createQuery("SELECT ar FROM Articulo ar").getResultList();
		ab.cerrarConexion();
		return lista;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Familia> listaFamilias(){
		List<Familia> lista;
		em=ab.abrirConexion();
		if (em==null)
			return null;
		lista=em.createQuery("SELECT fam FROM Familia fam").getResultList();
		ab.cerrarConexion();
		return lista;
	}

}
