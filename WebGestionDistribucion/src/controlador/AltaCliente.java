package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Cliente;
import model.negocio.GestorCliente;
import vista.correo.EnviarCorreoSolicitudConfirmacion;

/**
 * Controla el alta de cliente, recibe los datos desde el formulario de registro.jsp
 */
@WebServlet("/AltaCliente")
public class AltaCliente extends HttpServlet {
	private static final String ENBLANCO = " no puede estar en blanco";
	private static final long serialVersionUID = 1L;
	GestorCliente gc;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCliente() {
        gc=new GestorCliente();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cli=new Cliente();
		boolean[] caso=new boolean[12];
		request.setCharacterEncoding("UTF-8");
		cli.setNombre(request.getParameter("nombre").trim());
		cli.setApellidos(request.getParameter("apellidos").trim());
		cli.setNifCif(request.getParameter("nif").trim());
		cli.setEmail(request.getParameter("email").trim());
		String pass1=request.getParameter("pass1");
		String pass2=request.getParameter("pass2");
		cli.setDireccion(request.getParameter("direccion").trim());
		cli.setCodPost(request.getParameter("codpost").trim());
		cli.setPoblacion(request.getParameter("poblacion").trim());
		cli.setTelefonoFijo(request.getParameter("fijo").trim());
		cli.setTelefonoMovil(request.getParameter("movil").trim());
		cli.setTipo(0);
		caso=gc.nuevo(cli,pass1,pass2);
		System.out.println("Número de cliente "+cli.getNumero());
		String[] error= {"El nombre"+ENBLANCO,"Los apellidos"+ENBLANCO,"El nif"+ENBLANCO,"El Email"+ENBLANCO,"La direccion"+ENBLANCO,
			"La Población"+ENBLANCO,"El código postal"+ENBLANCO,"Las contraseñas son diferentes","La contraseña"+ENBLANCO,
			"Error de conexión","El Email ya existe"};
		for (int i=0;i<caso.length-1;i++)
			if(caso[i])
				error[i]="";
		if (caso[11]) {
			request.setAttribute("mensaje", "Enhorabuena usted se ha registrado correctamente correctamente. Recibirá un Email para confirmar de su correo.");
			request.getRequestDispatcher("Principal").forward(request, response);
			System.out.println(cli.getEmail()+" "+cli.getNumero());
			new EnviarCorreoSolicitudConfirmacion(cli.getEmail(), cli.getNumero());
		}
		else {
			request.setAttribute("error", error); //pasa el array con los mensajes de los errores
			request.setAttribute("cli", cli); //pasa el cliente
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}
		for (int i=0;i<caso.length;i++)
			System.out.println(i+" "+caso[i]);
		System.out.println("caso 11 "+caso[11]);
	}
	
}
