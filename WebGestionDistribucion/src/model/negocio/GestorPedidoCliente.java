package model.negocio;

import model.PedidoCliente;
import model.persistencia.DaoPedidoCliente;

public class GestorPedidoCliente {
	DaoPedidoCliente dpc; 
	
	public GestorPedidoCliente() {
		dpc=new DaoPedidoCliente();
	}
	
	public void guardaPedido(PedidoCliente ped) {
		dpc.guardaPedido(ped);
	}
}
