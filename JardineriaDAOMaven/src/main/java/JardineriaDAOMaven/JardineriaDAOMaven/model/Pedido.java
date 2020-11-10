package JardineriaDAOMaven.JardineriaDAOMaven.model;

import java.util.Calendar;

public class Pedido {
	private int codigo_pedido;
	private Calendar fecha_pedido;
	private Calendar fecha_esperada;
	private Calendar fecha_entrega;
	private String estado;
	private String comentarios;
	private int  codigo_cliente;
		
//CONSTRUCTOR
	public Pedido(int codigo_pedido, Calendar fecha_pedido, Calendar fecha_esperada, Calendar fecha_entrega, String estado,
			String comentarios, int codigo_cliente) {
		super();
		this.codigo_pedido = codigo_pedido;
		this.fecha_pedido = fecha_pedido;
		this.fecha_esperada = fecha_esperada;
		this.fecha_entrega = fecha_entrega;
		this.estado = estado;
		this.comentarios = comentarios;
		this.codigo_cliente = codigo_cliente;
	}
	
	public Pedido(int codigo_pedido, Calendar fecha_pedido, Calendar fecha_esperada, Calendar fecha_entrega, int codigo_cliente) {
		super();
		this.codigo_pedido = codigo_pedido;
		this.fecha_pedido = fecha_pedido;
		this.fecha_esperada = fecha_esperada;
		this.fecha_entrega = fecha_entrega;
		this.codigo_cliente = codigo_cliente;
	}

//GETTERS AND SETTERS
	public int getCodigo_pedido() {
		return codigo_pedido;
	}
	public void setCodigo_pedido(int codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}

	public Calendar getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(Calendar fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	public Calendar getFecha_esperada() {
		return fecha_esperada;
	}
	public void setFecha_esperada(Calendar fecha_esperada) {
		this.fecha_esperada = fecha_esperada;
	}

	public Calendar getFecha_entrega() {
		return fecha_entrega;
	}
	public void setFecha_entrega(Calendar fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public int getCodigo_cliente() {
		return codigo_cliente;
	}
	public void setCodigo_cliente(int codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}

//METODOS
	@Override
	public String toString() {
		return "Pedido [codigo_pedido=" + codigo_pedido + ", fecha_pedido=" + fecha_pedido + ", fecha_esperada="
				+ fecha_esperada + ", fecha_entrega=" + fecha_entrega + ", estado=" + estado + ", comentarios="
				+ comentarios + ", codigo_cliente=" + codigo_cliente + "]";
	}
	
	
	
}
