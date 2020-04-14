package model.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbreCierra {
	private EntityManager em;
	
	/**
	 * 
	 * @return true->conexion abierta false->error al conectar
	 */
	public EntityManager abrirConexion() {
		try {
			EntityManagerFactory factoria=Persistence.createEntityManagerFactory("WebGestionDistribucio");
			em=factoria.createEntityManager();
			return em;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Cierra la conexi�n
	 * @return true->conexion cerrada false->error al cerrar la conexi�n 
	 */
	public boolean cerrarConexion() {
		try {
			em.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
