package model.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import model.Cliente;
import model.Familia;
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

	@SuppressWarnings("unchecked")
	public boolean confirmado(int hash) {
		List<Cliente> lista;
		em=ab.abrirConexion();
		if (em==null)
			return false;
		lista=em.createQuery("SELECT cli FROM Cliente cli").getResultList();
		ab.cerrarConexion();
		for (Cliente cli:lista) {
			System.out.println(((cli.getNumero())+cli.getEmail()).hashCode()+" comparado con "+hash);
			if((String.valueOf(cli.getNumero())+cli.getEmail()).hashCode()==hash){
					confirma(cli.getNumero());
					return true;
			}
		}
		return false;
	}
	private void confirma(int num) {
		em=ab.abrirConexion();
		em.getTransaction().begin();
		Cliente cli=em.find(Cliente.class, num);
		cli.setConfirmado(true);
		em.merge(cli);
		em.getTransaction().commit();
		em.close();
	}

}
