package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ALBARAN_CLIENTE database table.
 * 
 */
@Entity
@Table(name="ALBARAN_CLIENTE")
@NamedQuery(name="AlbaranCliente.findAll", query="SELECT a FROM AlbaranCliente a")
public class AlbaranCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="NUM")
	private int num;

	@Column(name="ENTREGADO")
	private byte entregado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA")
	private Date fecha;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="CLIENTE")
	private Cliente clienteBean;

	//bi-directional many-to-one association to PedidosCliente
	@OneToMany(mappedBy="albaranCliente")
	private List<PedidoCliente> pedidosClientes;

	public AlbaranCliente() {
	}

	public int getNum() {
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public byte getEntregado() {
		return this.entregado;
	}

	public void setEntregado(byte entregado) {
		this.entregado = entregado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getClienteBean() {
		return this.clienteBean;
	}

	public void setClienteBean(Cliente clienteBean) {
		this.clienteBean = clienteBean;
	}

	public List<PedidoCliente> getPedidosClientes() {
		return this.pedidosClientes;
	}

	public void setPedidosClientes(List<PedidoCliente> pedidosClientes) {
		this.pedidosClientes = pedidosClientes;
	}

	public PedidoCliente addPedidosCliente(PedidoCliente pedidosCliente) {
		getPedidosClientes().add(pedidosCliente);
		pedidosCliente.setAlbaranCliente(this);

		return pedidosCliente;
	}

	public PedidoCliente removePedidosCliente(PedidoCliente pedidosCliente) {
		getPedidosClientes().remove(pedidosCliente);
		pedidosCliente.setAlbaranCliente(null);

		return pedidosCliente;
	}

}