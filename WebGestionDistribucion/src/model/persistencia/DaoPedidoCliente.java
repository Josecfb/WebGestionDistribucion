package model.persistencia;

import javax.persistence.EntityManager;

import entidades.PedidoCliente;
/**
 * Gestiona la persistencia de PedidoCliente 
 * @author Jose Carlos
 *
 */
public class DaoPedidoCliente {
	private EntityManager em;
	private AbreCierra ab;
	/**
	 * El constructor crea un objeto AbreCierra
	 */
	public DaoPedidoCliente() {
		ab=new AbreCierra();
	}
	/**
	 * Persiste el PedidoCliente en la base de datos
	 * @param ped Objeto PedidoCliente
	 * @return -1 error 0 correcto
	 */
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
