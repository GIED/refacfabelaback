package com.refacFabela.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tw_carrito_compra_producto")
public class TwCarritoCompraPedido {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_id")
    private Long nId;

    @Column(name = "n_id_usuario")
    private Long nIdUsuario;

    @Column(name = "n_id_pedido")
    private Long nIdPedido;
    
    @Column(name = "n_id_producto")
    private Long nIdProducto;

    @Column(name = "n_cantidad")
    private Integer nCantidad;

    @Column(name = "d_fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dFechaRegistro;

    @Column(name = "d_fecha_llegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dFechaLlegada;

    @Column(name = "n_estatus")
    private Integer nEstatus;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "n_id_usuario", referencedColumnName = "n_id", insertable = false, updatable = false)
    private TcUsuario twUsuario;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "n_id_producto", referencedColumnName = "n_id", insertable = false, updatable = false)
    private TcProducto tcProducto;
    
    public TwCarritoCompraPedido() {
    	
    }

	public Long getnId() {
		return nId;
	}

	public void setnId(Long nId) {
		this.nId = nId;
	}

	public Long getnIdUsuario() {
		return nIdUsuario;
	}

	public void setnIdUsuario(Long nIdUsuario) {
		this.nIdUsuario = nIdUsuario;
	}

	public Long getnIdPedido() {
		return nIdPedido;
	}

	public void setnIdPedido(Long nIdPedido) {
		this.nIdPedido = nIdPedido;
	}

	public Long getnIdProducto() {
		return nIdProducto;
	}

	public void setnIdProducto(Long nIdProducto) {
		this.nIdProducto = nIdProducto;
	}

	public Integer getnCantidad() {
		return nCantidad;
	}

	public void setnCantidad(Integer nCantidad) {
		this.nCantidad = nCantidad;
	}

	public Date getdFechaRegistro() {
		return dFechaRegistro;
	}

	public void setdFechaRegistro(Date dFechaRegistro) {
		this.dFechaRegistro = dFechaRegistro;
	}

	public Date getdFechaLlegada() {
		return dFechaLlegada;
	}

	public void setdFechaLlegada(Date dFechaLlegada) {
		this.dFechaLlegada = dFechaLlegada;
	}

	public Integer getnEstatus() {
		return nEstatus;
	}

	public void setnEstatus(Integer nEstatus) {
		this.nEstatus = nEstatus;
	}

	public TcUsuario getTwUsuario() {
		return twUsuario;
	}

	public void setTwUsuario(TcUsuario twUsuario) {
		this.twUsuario = twUsuario;
	}

	public TcProducto getTcProducto() {
		return tcProducto;
	}

	public void setTcProducto(TcProducto tcProducto) {
		this.tcProducto = tcProducto;
	}

	@Override
	public String toString() {
		return "TwCarritoCompraPedido [nId=" + nId + ", nIdUsuario=" + nIdUsuario + ", nIdPedido=" + nIdPedido
				+ ", nIdProducto=" + nIdProducto + ", nCantidad=" + nCantidad + ", dFechaRegistro=" + dFechaRegistro
				+ ", dFechaLlegada=" + dFechaLlegada + ", nEstatus=" + nEstatus + ", twUsuario=" + twUsuario
				+ ", tcProducto=" + tcProducto + "]";
	}
    
    

}
