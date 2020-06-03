package model.persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import model.Articulo;
import model.Cliente;
import model.Familia;
import model.persistencia.AbreCierra;
/**
 * Gestiona la persistencia de Articulo
 * @author Jose Carlos
 *
 */
public class DaoArticulo {
	private EntityManager em;
	private AbreCierra ab;
	/**
	 * El constructor crea un objeto AbreCierra
	 */
	public DaoArticulo() {
		ab=new AbreCierra();
	}
	/**
	 * Obtiene la lista de todos los artículos
	 * @return List de Articulo
	 */
	@SuppressWarnings("unchecked")
	public List<Articulo> listaArticulos(){
		List<Articulo> lista;
		em=ab.abrirConexion();
		if (em==null)
			return null;
		lista=em.createQuery("SELECT ar FROM Articulo ar").getResultList();
		ab.cerrarConexion();
		return lista;
	}
	/**
	 * Obtiene la lista de todas las familias de Artículos
	 * @return List de Familia
	 */
	@SuppressWarnings("unchecked")
	public List<Familia> listaFamilias(){
		List<Familia> lista;
		em=ab.abrirConexion();
		if (em==null)
			return null;
		lista=em.createQuery("SELECT fam FROM Familia fam").getResultList();
		ab.cerrarConexion();
		return lista;
	}
	/**
	 * Obtiene el codigo, nombre, precio, stock-reservados, suma de cantidades pedidas por parte del cliente de todos los artículos
	 * @param cli Objeto Cliente
	 * @return List de array de Object
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> preciosArticulos(Cliente cli){
		List<Object[]> lista;
		em=ab.abrirConexion();
		if (em==null)
			return null;
		String consulta="select art.cod, art.nombre, "
				+ "(select pre.precio from PreciosCliente pre where pre.articuloBean=art and pre.clienteBean=:clie), "	
				+ "case when :tipo=0 then "
						+ "art.precioMinorista "
					+ "else art.precioMayorista end, "
				+ "art.stock-art.reservados,"
				+ "(select sum(fil.cantidad) from FilasPedidosCliente fil where fil.articuloBean=art and fil.pedidosCliente.clienteBean=:clie) "
				+ "from Articulo art order by 6 desc";
		lista=em.createQuery(consulta).setParameter("tipo", cli.getTipo()).setParameter("clie", cli).getResultList();
		ab.cerrarConexion();
		return lista;
	}
	/**
	 * Retorna el articulo con un determinado código
	 * @param codigo código de artículo
	 * @return Objeto Articulo
	 */
	public Articulo buscaArticulo(int codigo) {
		em=ab.abrirConexion();
		if (em==null)
			return null;
		Articulo art=em.find(Articulo.class, codigo);
		em.close();
		return art;
	}
	/**
	 * Actualiza la cantidad de reservados de un artículo
	 * @param viejo Objeto Articulo
	 */
	public void actualizaArticulo(Articulo viejo) {
		em=ab.abrirConexion();
		Articulo art=em.find(Articulo.class, viejo.getCod());
		art.setReservados(viejo.getReservados());
		em.getTransaction().begin();
		em.merge(art);
		em.getTransaction().commit();
		em.close();
	}
}
