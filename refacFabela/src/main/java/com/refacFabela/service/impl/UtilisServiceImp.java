package com.refacFabela.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.refacFabela.model.TcCatalogogeneral;
import com.refacFabela.model.TcGanancia;
import com.refacFabela.model.TcProducto;
import com.refacFabela.repository.CatalogoGananciaRepository;
import com.refacFabela.repository.CatalogosRepository;
import com.refacFabela.utils.utils;

@Service
public class UtilisServiceImp {

	@Autowired
	private CatalogosRepository catalogosRepository;
	@Autowired
	private CatalogoGananciaRepository catalogoGananciaRepository;

public TcProducto calcularPrecio(TcProducto tcProducto){
		
		
		Double iva=obtenerValorIva();
		Double precioPeso=convertirMoneda(tcProducto.getsMoneda(), tcProducto.getnPrecio());
		Double ganancia=obtenerGanancia(tcProducto.getnIdGanancia());
		
		tcProducto.setnPrecioPeso(precioPeso);
		tcProducto.setnPrecioSinIva(precioPeso+(precioPeso*ganancia));
		tcProducto.setnPrecioConIva((precioPeso+(precioPeso*ganancia))+((precioPeso+(precioPeso*ganancia))*iva));
		tcProducto.setnPrecioIva((precioPeso+(precioPeso*ganancia))*iva);
		
		System.out.println("El precio peso es "+precioPeso);
		System.out.println("El objeto completo es "+tcProducto);
			
		
		return tcProducto;
	}

	public Double obtenerTipoCambio() {

		TcCatalogogeneral catalogo = catalogosRepository.findBysClave(utils.filtroTipoCambio);

		return catalogo.getnValor();
	}

	public Double obtenerValorIva() {

		TcCatalogogeneral catalogo = catalogosRepository.findBysClave(utils.filtroIva);

		return catalogo.getnValor();
	}
	public Double convertirMoneda(String moneda, Double precio) {
		
		Double precioMoneda=obtenerTipoCambio();
		Double precioPeso=(double) 0;
		
		if(moneda.equals("USD")) {
			
			precioPeso=precio*precioMoneda;
			
			
		}
		else if(moneda.equals("PESO")) {
			
			precioPeso=precio;
			
		}
		
		
		return precioPeso;
		
	}
	public Double obtenerGanancia(Long nId) {
		
		TcGanancia ganancia=catalogoGananciaRepository.getById(nId);
		
		return ganancia.getnGanancia();
	}

}
