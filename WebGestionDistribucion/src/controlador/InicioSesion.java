package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import model.negocio.GestorCliente;

/**
 * Servlet implementation class InicioSesion
 */
@WebServlet("/InicioSesion")
public class InicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cli=new Cliente();
		boolean[] ok=new boolean[3];
		for (int i=0;i<ok.length-1;i++) ok[i]=false;
		ok[2]=true;
		ok[0]=!request.getParameter("email").trim().equals("");
		ok[1]=!request.getParameter("password").trim().equals("");
		System.out.println(ok[0]+" "+ok[1]);
		GestorCliente gc=new GestorCliente();
		if (ok[0] && ok[1]) {
			cli=gc.buscaEmailPassword(request.getParameter("email").trim(), request.getParameter("password"));
			if (cli!=null) {
				request.setAttribute("cli", cli);
				request.getRequestDispatcher("Pedidos").forward(request, response);
			}
			else 
				ok[2]=false;
		}
		if(!ok[0] || !ok[1] || !ok[2]) {
			String[] error= {"Email vacío","contraseña vacía","La contraseña o el correo de usuario no son corectos"};
			for (int i=0;i<ok.length;i++) {
				if (ok[i]) error[i]="";
				System.out.println(error[i]);
			}
			request.setAttribute("error", error);
			request.getRequestDispatcher("iniciosesion.jsp").forward(request, response);
		}
	}

}
