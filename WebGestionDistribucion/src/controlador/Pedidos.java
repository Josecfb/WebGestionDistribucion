package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.negocio.GestorArticulo;

/**
 * Servlet implementation class Pedidos
 */
@WebServlet("/Pedidos")
public class Pedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pedidos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestorArticulo ga=new GestorArticulo();
		List<Object[]> artis=new ArrayList<Object[]>();
		Cliente cli=null;
		try {
		cli=(Cliente) request.getAttribute("cli");
		}catch (NullPointerException e) {
			request.getRequestDispatcher("iniciosesion.jsp").forward(request, response);
			return;
		}

		if (cli==null) request.getRequestDispatcher("iniciosesion.jsp").forward(request, response);
		artis=ga.preciosArticulos(cli);
		List<String> artPedido=new ArrayList<String>();
		for (Object[] arti:artis) {
			if (arti[2]==null) arti[2]=arti[3];
			if (arti[2].toString().split("\\.")[1].length()==1) arti[2]+="0";
			artPedido.add(arti[0]+";"+arti[1]+";"+arti[2]+";"+arti[4]+";"+arti[5]);
		}
		System.out.println("Númenro de artículos="+artis.size());
		for (Object[] arti:artis) {
			System.out.println(arti[0]+";"+arti[1]+";"+arti[2]+";"+arti[4]+"; sumaped"+arti[5]);
		}
		request.setAttribute("cli", cli);
		request.setAttribute("artpedido", artPedido);
		request.getRequestDispatcher("pedido.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
