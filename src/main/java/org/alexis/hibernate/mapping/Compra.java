package org.alexis.hibernate.mapping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "compra")
public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;


	@Id
 	@GenericGenerator(name = "uuid2", strategy = "uuid2")
 	@GeneratedValue(generator = "uuid2")
     private String id;


     @Column(name = "tipoComprobante", nullable = false)
     private String tipoComprobante;

     @Temporal(TemporalType.DATE)
     @Column(name = "fechaFactura", nullable = false)
     private Date fechaFactura;

     @Temporal(TemporalType.DATE)
     @Column(name = "fechaLlegada", nullable = false)
     private Date fechaLlegada;

     @Column(name = "serie", nullable = false)
     private String serie;

     @Column(name = "numero", nullable = false)
     private int numero;

     @Column(name = "importe", nullable = false)
     private double importe;

     @Column(name = "vigencia", nullable = false)
     private boolean vigencia = true;

    @ElementCollection    
   // @CollectionTable(name="student", joinColumns=JoinColumn(name="college_id"))
    @CollectionTable(name = "lst_Detalle")
    @MapKeyColumn(name = "tabkey_key")
    private Map<Customer, Certy> lstDetalle = new HashMap<Customer, Certy>();
    
    @ElementCollection    
   // @CollectionTable(name="student", joinColumns=JoinColumn(name="college_id"))
    @CollectionTable(name = "str_str")
    @MapKeyColumn(name = "strkey_str")
    private Map<String, String> strstr = new HashMap<String, String>();
     

	public Map<String, String> getStrstr() {
		return strstr;
	}


	public void setStrstr(Map<String, String> strstr) {
		this.strstr = strstr;
	}


	public Compra(String tipoComprobante, String serie) {
		super();
		this.tipoComprobante = tipoComprobante;
		this.fechaFactura = new Date();
		this.fechaLlegada = new Date();
		this.serie = serie;
		this.numero = 10;
		this.importe = new Double("25.34");
		this.vigencia = true;
	}


	public Compra() {
		super();

	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public boolean isVigencia() {
		return vigencia;
	}

	public void setVigencia(boolean vigencia) {
		this.vigencia = vigencia;
	}


	public Map<Customer, Certy> getLstDetalle() {
		return lstDetalle;
	}


	public void setLstDetalle(Map<Customer, Certy> lstDetalle) {
		this.lstDetalle = lstDetalle;
	}



	

     
}
