package com.refacFabela.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tc_gasto")
@NamedQuery(name = "TcGasto.findAll", query = "SELECT t FROM TcGasto t")
public class TcGasto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "n_id")
	private Long nId;

	@Column(name = "s_gasto")
	private String sGasto;

	@Column(name = "n_estatus")
	private Integer nEstatus;
	
	public TcGasto() {
	}

	
	public Long getnId() {
		return nId;
	}

	public void setnId(Long nId) {
		this.nId = nId;
	}

	public String getsGasto() {
		return sGasto;
	}

	public void setsGasto(String sGasto) {
		this.sGasto = sGasto;
	}

	public Integer getnEstatus() {
		return nEstatus;
	}

	public void setnEstatus(Integer nEstatus) {
		this.nEstatus = nEstatus;
	}


	@Override
	public String toString() {
		return "TcGasto [nId=" + nId + ", sGasto=" + sGasto + ", nEstatus=" + nEstatus + "]";
	}
	
	

	

}
