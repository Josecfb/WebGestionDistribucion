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
import model.Familia;
import model.negocio.GestorArticulo;


@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Principal() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestorArticulo ga=new GestorArticulo();
		List<Articulo> artis=new ArrayList<Articulo>();
		List<Familia> fami = new ArrayList<Familia>();
		for (Familia familia:ga.listaFamilias())
			fami.add(familia);
		for (Articulo art:ga.listaArticulos()) 
			artis.add(art);
		request.setAttribute("familias", fami);
		request.setAttribute("articulos",artis);
		request.getRequestDispatcher("principal.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
