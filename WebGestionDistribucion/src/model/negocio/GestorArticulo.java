package model.negocio;

import java.util.List;

import model.Articulo;
import model.persistencia.DaoArticulo;

public class GestorArticulo {
	DaoArticulo da;
	
	public GestorArticulo() {
		da=new DaoArticulo();
	}
	
	public List<Articulo> listado(String filtroNombre){
		return da.listado(filtroNombre);
	}
}
