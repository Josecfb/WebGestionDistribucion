package model.negocio;

import java.util.List;

import model.Articulo;
import model.Cliente;
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
	
	public List<Object[]> preciosArticulos(Cliente cli){
		return da.preciosArticulos(cli);
	}
	public Articulo buscaArticulo(int codigo) {
		return da.buscaArticulo(codigo);
	}
	public void actualizarArticulo(Articulo viejo) {
		da.actualizaArticulo(viejo);
	}
}
