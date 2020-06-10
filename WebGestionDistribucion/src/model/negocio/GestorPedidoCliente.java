package model.negocio;

import entidades.PedidoCliente;
import model.persistencia.DaoPedidoCliente;
/**
 * Clase gestora de pedido de cliente
 * @author Jose Carlos
 *
 */
public class GestorPedidoCliente {
	DaoPedidoCliente dpc; 
	/**
	 * El constructor crea un objeto DaoPedidoCliente
	 */
	public GestorPedidoCliente() {
		dpc=new DaoPedidoCliente();
	}
	/**
	 * Llama al método guardaPedido de DaoPedidoCliente
	 * @param ped Objeto PedidoCliente
	 */
	public void guardaPedido(PedidoCliente ped) {
		dpc.guardaPedido(ped);
	}
}
