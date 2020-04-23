package model.persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import model.Cliente;
import model.persistencia.AbreCierra;

public class DaoCliente {
	private EntityManager em;
	private AbreCierra ab;
	
	public DaoCliente() {
		ab=new AbreCierra();
	}

	/**
	 * 
	 * @param cli Cliente
	 * @return -1 sin conexión -2 existe correo 0 ok
	 */
	public int nuevo(Cliente cli) {
		em=ab.abrirConexion();
		em.getTransaction().begin();
		if (em==null) return -1;
		if (!existeEmail(cli.getEmail()))
			em.persist(cli);
		else 
			return -2;
		em.getTransaction().commit();
		em.close();
		return 0;
	}
	/**
	 * 
	 * @param eMail
	 * @return true correo ya existe false correo no existe
	 */
	public boolean existeEmail(String eMail) {
		Long num=em.createQuery("SELECT count(cli) FROM Cliente cli where cli.email=:eMail",Long.class).setParameter("eMail", eMail).getSingleResult();
		if (num==0)
			return false;
		else return true;
	}


}
