package model.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import model.Cliente;
import model.persistencia.AbreCierra;
/**
 * Gestiona la persistencia de Cliente
 * @author Jose Carlos
 *
 */
public class DaoCliente {
	private EntityManager em;
	private AbreCierra ab;
	/** 
	 * El constructor crea un objeto AbreCierra
	 */
	public DaoCliente() {
		ab=new AbreCierra();
	}

	/**
	 * Persiste un cliente nuevo si no está con el mismo email
	 * @param cli Cliente Objeto Cliente
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
	 * Comprueba si existe cliente con el mismo email
	 * @param eMail Cadena con el email
	 * @return true correo ya existe false correo no existe
	 */
	public boolean existeEmail(String eMail) {
		Long num=em.createQuery("SELECT count(cli) FROM Cliente cli where cli.email=:eMail",Long.class).setParameter("eMail", eMail).getSingleResult();
		if (num==0)
			return false;
		else return true;
	}
	/**
	 * Busca cliente con un email y password
	 * @param email cadena con el email
	 * @param password  Cadena con el password
	 * @return Objeto Cliente
	 */
	public Cliente buscaEmailPassword(String email,String password) {
		int pass=password.hashCode();
		em=ab.abrirConexion();
		Cliente cli;
		try {
		cli=(Cliente) em.createQuery("SELECT cli from Cliente cli where cli.email=:email and cli.contrasena=:pass").setParameter("email", email).setParameter("pass", pass).getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
		ab.cerrarConexion();
		return cli;
	}
	/**
	 * Retorna si el cliente ha sido confirmado su correo
	 * @param hash hashcode del numero de cliente + correo
	 * @return true o false
	 */
	@SuppressWarnings("unchecked")
	public boolean confirmado(int hash) {
		List<Cliente> lista;
		em=ab.abrirConexion();
		if (em==null)
			return false;
		lista=em.createQuery("SELECT cli FROM Cliente cli").getResultList();
		ab.cerrarConexion();
		for (Cliente cli:lista) 
			if((String.valueOf(cli.getNumero())+cli.getEmail()).hashCode()==hash){
					confirma(cli.getNumero());
					return true;
			}
		return false;
	}
	/**
	 * Actualiza el campo confirmado del cliente a verdadero
	 * @param num número de cliente
	 */
	private void confirma(int num) {
		em=ab.abrirConexion();
		em.getTransaction().begin();
		Cliente cli=em.find(Cliente.class, num);
		cli.setConfirmado(true);
		em.merge(cli);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * Busca un cliente por su número
	 * @param numero número de cliente
	 * @return Objeto Cliente
	 */
	public Cliente buscaCliente(int numero) {
		em=ab.abrirConexion();
		if (em==null)
			return null;
		Cliente cli=em.find(Cliente.class, numero);
		em.close();
		return cli;
	}
}
