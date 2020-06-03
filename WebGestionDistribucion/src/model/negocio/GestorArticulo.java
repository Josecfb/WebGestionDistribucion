package model.negocio;

import java.util.List;

import model.Articulo;
import model.Cliente;
import model.Familia;
import model.persistencia.DaoArticulo;
/**
 * Clase gestora de artículos
 * @author Jose Carlos
 *
 */
public class GestorArticulo {
	DaoArticulo da;
	/**
	 * El constructor crea un objeto DaoArticulo
	 */
	public GestorArticulo() {
		da=new DaoArticulo();
	}
	/**
	 * Llama al método listaArticulos de DaoArticulo
	 * @return List de Articulo
	 */
	public List<Articulo> listaArticulos(){
		return da.listaArticulos();
	}
	/**
	 * Llama al método listaFamilias de DaoArticulo
	 * @return List de Familia
	 */
	public List<Familia> listaFamilias(){
		return da.listaFamilias();
	}
	/**
	 * Llama al método preciosArticulos de DaoArticulo
	 * @param cli Objeto Cliente
	 * @return List de array de Object
	 */
	public List<Object[]> preciosArticulos(Cliente cli){
		return da.preciosArticulos(cli);
	}
	/**
	 * Llama al método buscaArticulo de DaoArticulo
	 * @param codigo código de artículo
	 * @return Objeto Articulo
	 */
	public Articulo buscaArticulo(int codigo) {
		return da.buscaArticulo(codigo);
	}
	/**
	 * Llama al método actualizarArtículo de DaoArticulo
	 * @param viejo Objeto Articulo
	 */
	public void actualizarArticulo(Articulo viejo) {
		da.actualizaArticulo(viejo);
	}
}
