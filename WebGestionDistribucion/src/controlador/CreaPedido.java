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

import model.Cliente;
import model.FilasPedidosCliente;
import model.PedidoCliente;
import model.negocio.GestorArticulo;
import model.negocio.GestorCliente;
import model.negocio.GestorPedidoCliente;

/**
 * Servlet implementation class CreaPedido
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
		for (int i=0;i<filasped.length;i++)
			System.out.println(filasped[i]);
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
			fila.setPrecio(Double.parseDouble(filaped.split(";")[1]));
			fila.setPedidosCliente(ped);
			filas.add(fila);
		}
		ped.setFilasPedidosClientes(filas);
		GestorPedidoCliente gpc=new GestorPedidoCliente();
		gpc.guardaPedido(ped);
	}
}
