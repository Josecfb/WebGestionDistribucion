package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import entidades.FilasPedidosCliente;
import entidades.PedidoCliente;
import model.negocio.GestorArticulo;
import model.negocio.GestorCliente;
import model.negocio.GestorPedidoCliente;
import vista.correo.EnviarCorreoConfirmacionPedido;

/**
 * Gestiona el pedido del cliente recibiendo los datos desde pedido.jsp
 */
@WebServlet("/CreaPedido")
public class CreaPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("numcli"));
		System.out.println(request.getParameter("filaspedido"));
		String[] filasped=request.getParameter("filaspedido").split("#");
		System.out.println("num filas "+filasped.length);
		GestorCliente gc=new GestorCliente();
		Cliente cli=gc.buscaCliente(Integer.parseInt(request.getParameter("numcli")));
		PedidoCliente ped=new PedidoCliente();
		ped.setClienteBean(cli);
		Date fecha = new Date();
		ped.setFecha(fecha);
		List<FilasPedidosCliente> filas=new ArrayList<FilasPedidosCliente>();
		FilasPedidosCliente fila;
		GestorArticulo ga=new GestorArticulo();
		for (String filaped:filasped) {
			fila=new FilasPedidosCliente();
			fila.setArticuloBean(ga.buscaArticulo(Integer.parseInt(filaped.split(";")[0])));
			fila.setCantidad(Integer.parseInt(filaped.split(";")[1]));
			fila.getArticuloBean().setReservados(fila.getArticuloBean().getReservados()+fila.getCantidad());
			ga.actualizarArticulo(fila.getArticuloBean());
			fila.setPrecio(Double.parseDouble(filaped.split(";")[2]));
			fila.setPedidosCliente(ped);
			filas.add(fila);
		}
		ped.setFilasPedidosClientes(filas);
		GestorPedidoCliente gpc=new GestorPedidoCliente();
		gpc.guardaPedido(ped);
		new EnviarCorreoConfirmacionPedido(ped);
		request.setAttribute("mensaje", "Enhorabuena Su pedido ha sido enviado correctamente.");
		request.getRequestDispatcher("Principal").forward(request, response);
	}
}
