package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Articulo;
import model.negocio.GestorArticulo;


@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Principal() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestorArticulo ga=new GestorArticulo();
		List<String> nombres=new ArrayList<String>();
		List<String> fotos=new ArrayList<String>();
		for (Articulo art:ga.listado(1)) {
			nombres.add(art.getNombre());
			fotos.add(String.valueOf(art.getCod()));
		}
		request.setAttribute("listaNombres1",nombres);
		request.setAttribute("listaFotos1", fotos);
		request.setAttribute("largo", nombres.size());
		request.getRequestDispatcher("principal.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
