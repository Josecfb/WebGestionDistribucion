package model.negocio;

import java.util.List;

import model.Articulo;
import model.Familia;
import model.persistencia.DaoArticulo;

public class GestorArticulo {
	DaoArticulo da;
	
	public GestorArticulo() {
		da=new DaoArticulo();
	}
	
	public List<Articulo> listaArticulos(){
		return da.listaArticulos();
	}
	
	public List<Familia> listaFamilias(){
		return da.listaFamilias();
	}
}
