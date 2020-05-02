package model.persistencia;

import java.util.List;

import javax.persistence.EntityManager;

import model.Articulo;
import model.Cliente;
import model.Familia;
import model.persistencia.AbreCierra;

public class DaoArticulo {
	private EntityManager em;
	private AbreCierra ab;
	
	public DaoArticulo() {
		ab=new AbreCierra();
	}
	
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
	
	@SuppressWarnings("unchecked")
	public List<Object[]> preciosArticulos(Cliente cli,String filtro){
		System.out.println("FILTRO "+filtro);
		List<Object[]> lista;
		em=ab.abrirConexion();
		if (em==null)
			return null;
		String consulta;
		if (filtro!=null) {
			consulta="select art.cod, art.nombre, "
				+ "case when pre.clienteBean=:clie then pre.precio else null end, "	
				+ "case when :tipo=0 then "
						+ "art.precioMinorista "
					+ "else art.precioMayorista end, "
				+ "art.stock-art.reservados "
				+ "from Articulo art left join PreciosCliente pre on art=pre.articuloBean where art.nombre like '%:filtro%'";
			lista=em.createQuery(consulta).setParameter("tipo", cli.getTipo()).setParameter("clie", cli).setParameter("filtro", filtro).getResultList();
		}
		else {
			consulta="select art.cod, art.nombre, "
					+ "case when pre.clienteBean=:clie then pre.precio else null end, "	
					+ "case when :tipo=0 then "
							+ "art.precioMinorista "
						+ "else art.precioMayorista end, "
					+ "art.stock-art.reservados "
					+ "from Articulo art left join PreciosCliente pre on art=pre.articuloBean";
			lista=em.createQuery(consulta).setParameter("tipo", cli.getTipo()).setParameter("clie", cli).getResultList();
		}
		ab.cerrarConexion();
		return lista;
	}
}
