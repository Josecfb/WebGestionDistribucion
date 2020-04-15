package model.negocio;

import java.util.List;

import model.Articulo;
import model.persistencia.DaoArticulo;

public class GestorArticulo {
	DaoArticulo da;
	
	public GestorArticulo() {
		da=new DaoArticulo();
	}
	
	public List<Articulo> listado(int familia){
		return da.listado(familia);
	}
}
