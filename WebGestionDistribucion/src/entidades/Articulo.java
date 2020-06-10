package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ARTICULOS database table.
 * 
 */
@Entity
@Table(name="ARTICULOS")
@NamedQuery(name="Articulo.findAll", query="SELECT a FROM Articulo a")
public class Articulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD")
	private int cod;

	@Column(name="CODPRO")
	private String codpro;

	@Column(name="COSTE")
	private Double coste;

	@Column(name="IVA")
	private Double iva;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="PRECIO_MAYORISTA")
	private Double precioMayorista;

	@Column(name="PRECIO_MINORISTA")
	private Double precioMinorista;

	@Column(name="STOCK")
	private int stock;

	@Column(name="STOCK_MINIMO")
	private int stockMinimo;

	@Column(name="UNIDADES_CAJA")
	private int unidadesCaja;
	
	@Column(name="ENPEDIDO")
	private boolean enPedido;
	
	@Column(name="RESERVADOS")
	private int reservados;

	//bi-directional many-to-one association to Familia
	@ManyToOne
	@JoinColumn(name="FAMILIA")
	private Familia familiaBean;

	//bi-directional many-to-one association to FilasPedidosCliente
	@OneToMany(mappedBy="articuloBean")
	private List<FilasPedidosCliente> filasPedidosClientes;

	//bi-directional many-to-one association to PreciosCliente
	@OneToMany(mappedBy="articuloBean")
	private List<PreciosCliente> preciosClientes;

	public Articulo() {
	}

	public int getCod() {
		return this.cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getCodpro() {
		return this.codpro;
	}

	public void setCodpro(String codpro) {
		this.codpro = codpro;
	}

	public Double getCoste() {
		return this.coste;
	}

	public void setCoste(Double coste) {
		this.coste = coste;
	}

	public Double getIva() {
		return this.iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecioMayorista() {
		return this.precioMayorista;
	}

	public void setPrecioMayorista(Double precioMayorista) {
		this.precioMayorista = precioMayorista;
	}

	public Double getPrecioMinorista() {
		return this.precioMinorista;
	}

	public void setPrecioMinorista(Double precioMinorista) {
		this.precioMinorista = precioMinorista;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockMinimo() {
		return this.stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getUnidadesCaja() {
		return this.unidadesCaja;
	}

	public void setUnidadesCaja(int unidadesCaja) {
		this.unidadesCaja = unidadesCaja;
	}

	public Familia getFamiliaBean() {
		return this.familiaBean;
	}

	public void setFamiliaBean(Familia familiaBean) {
		this.familiaBean = familiaBean;
	}

	public int getReservados() {
		return reservados;
	}

	public void setReservados(int reservados) {
		this.reservados = reservados;
	}

	public List<FilasPedidosCliente> getFilasPedidosClientes() {
		return this.filasPedidosClientes;
	}

	public void setFilasPedidosClientes(List<FilasPedidosCliente> filasPedidosClientes) {
		this.filasPedidosClientes = filasPedidosClientes;
	}

	public FilasPedidosCliente addFilasPedidosCliente(FilasPedidosCliente filasPedidosCliente) {
		getFilasPedidosClientes().add(filasPedidosCliente);
		filasPedidosCliente.setArticuloBean(this);

		return filasPedidosCliente;
	}

	public FilasPedidosCliente removeFilasPedidosCliente(FilasPedidosCliente filasPedidosCliente) {
		getFilasPedidosClientes().remove(filasPedidosCliente);
		filasPedidosCliente.setArticuloBean(null);

		return filasPedidosCliente;
	}

	public List<PreciosCliente> getPreciosClientes() {
		return this.preciosClientes;
	}

	public void setPreciosClientes(List<PreciosCliente> preciosClientes) {
		this.preciosClientes = preciosClientes;
	}

	public PreciosCliente addPreciosCliente(PreciosCliente preciosCliente) {
		getPreciosClientes().add(preciosCliente);
		preciosCliente.setArticuloBean(this);

		return preciosCliente;
	}

	public PreciosCliente removePreciosCliente(PreciosCliente preciosCliente) {
		getPreciosClientes().remove(preciosCliente);
		preciosCliente.setArticuloBean(null);

		return preciosCliente;
	}

	@Override
	public String toString() {
		return nombre;
	}

	
}