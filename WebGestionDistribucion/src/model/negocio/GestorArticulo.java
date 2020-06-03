package model.negocio;

import java.util.List;

import model.Articulo;
import model.Cliente;
import model.Familia;
import model.persistencia.DaoArticulo;
/**
 * Clase gestora de art�culos
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
	 * Llama al m�todo listaArticulos de DaoArticulo
	 * @return List de Articulo
	 */
	public List<Articulo> listaArticulos(){
		return da.listaArticulos();
	}
	/**
	 * Llama al m�todo listaFamilias de DaoArticulo
	 * @return List de Familia
	 */
	public List<Familia> listaFamilias(){
		return da.listaFamilias();
	}
	/**
	 * Llama al m�todo preciosArticulos de DaoArticulo
	 * @param cli Objeto Cliente
	 * @return List de array de Object
	 */
	public List<Object[]> preciosArticulos(Cliente cli){
		return da.preciosArticulos(cli);
	}
	/**
	 * Llama al m�todo buscaArticulo de DaoArticulo
	 * @param codigo c�digo de art�culo
	 * @return Objeto Articulo
	 */
	public Articulo buscaArticulo(int codigo) {
		return da.buscaArticulo(codigo);
	}
	/**
	 * Llama al m�todo actualizarArt�culo de DaoArticulo
	 * @param viejo Objeto Articulo
	 */
	public void actualizarArticulo(Articulo viejo) {
		da.actualizaArticulo(viejo);
	}
}
