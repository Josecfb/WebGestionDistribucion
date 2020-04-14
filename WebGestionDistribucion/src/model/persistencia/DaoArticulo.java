package model.persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import model.Articulo;
import model.persistencia.AbreCierra;

public class DaoArticulo {
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Articulo> listado(String filtroNombre){
		List<Articulo> lista;
		AbreCierra ab=new AbreCierra();
		em=ab.abrirConexion();
		if (em==null)
			return null;
		else{
			if (filtroNombre=="")
				lista=em.createQuery("SELECT ar FROM Articulo ar").getResultList();
			else
				lista=em.createQuery("SELECT ar FROM Articulo ar where ar.nombre LIKE :filtroNombre").setParameter("filtroNombre","%"+filtroNombre+"%").getResultList();
			//ab.cerrarConexion();
			ab.cerrarConexion();
			return lista;
		}
	}

}
