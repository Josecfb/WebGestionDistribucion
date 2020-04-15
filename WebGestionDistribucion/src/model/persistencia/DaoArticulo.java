package model.persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import model.Articulo;
import model.persistencia.AbreCierra;

public class DaoArticulo {
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Articulo> listado(int familia){
		List<Articulo> lista;
		AbreCierra ab=new AbreCierra();
		em=ab.abrirConexion();
		if (em==null)
			return null;
		lista=em.createQuery("SELECT ar FROM Articulo ar where ar.familiaBean.num=:familia").setParameter("familia", familia).getResultList();
		ab.cerrarConexion();
		return lista;
		
	}

}
