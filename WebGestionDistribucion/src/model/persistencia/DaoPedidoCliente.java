package model.persistencia;

import javax.persistence.EntityManager;

import model.PedidoCliente;

public class DaoPedidoCliente {
	private EntityManager em;
	private AbreCierra ab;
	
	public DaoPedidoCliente() {
		ab=new AbreCierra();
	}
	
	public int guardaPedido(PedidoCliente ped) {
		em=ab.abrirConexion();
		if (em==null)
			return -1;
		System.out.println("guardando pedido");
		em.getTransaction().begin();
		em.persist(ped);
		em.getTransaction().commit();
		em.close();
		return 1;
	}
	
}
