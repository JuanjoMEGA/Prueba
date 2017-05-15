/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA.clases;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jjmelgar
 */
@Entity
@Table(name = "smartphones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Smartphones.findAll", query = "SELECT s FROM Smartphones s")
    , @NamedQuery(name = "Smartphones.findById", query = "SELECT s FROM Smartphones s WHERE s.id = :id")
    , @NamedQuery(name = "Smartphones.findByBid", query = "SELECT s FROM Smartphones s WHERE s.bid = :bid")
    , @NamedQuery(name = "Smartphones.findByPantalla", query = "SELECT s FROM Smartphones s WHERE s.pantalla = :pantalla")
    , @NamedQuery(name = "Smartphones.findByPotencia", query = "SELECT s FROM Smartphones s WHERE s.potencia = :potencia")
    , @NamedQuery(name = "Smartphones.findByCamara", query = "SELECT s FROM Smartphones s WHERE s.camara = :camara")
    , @NamedQuery(name = "Smartphones.findBySensor", query = "SELECT s FROM Smartphones s WHERE s.sensor = :sensor")
    , @NamedQuery(name = "Smartphones.findByModelo", query = "SELECT s FROM Smartphones s WHERE s.modelo = :modelo")
    , @NamedQuery(name = "Smartphones.findByPublicado", query = "SELECT s FROM Smartphones s WHERE s.publicado = :publicado")
    , @NamedQuery(name = "Smartphones.findByDimensiones", query = "SELECT s FROM Smartphones s WHERE s.dimensiones = :dimensiones")
    , @NamedQuery(name = "Smartphones.findByPeso", query = "SELECT s FROM Smartphones s WHERE s.peso = :peso")
    , @NamedQuery(name = "Smartphones.findByBateria", query = "SELECT s FROM Smartphones s WHERE s.bateria = :bateria")
    , @NamedQuery(name = "Smartphones.findByColores", query = "SELECT s FROM Smartphones s WHERE s.colores = :colores")
    , @NamedQuery(name = "Smartphones.findByImagemini", query = "SELECT s FROM Smartphones s WHERE s.imagemini = :imagemini")
    , @NamedQuery(name = "Smartphones.findByDestacado", query = "SELECT s FROM Smartphones s WHERE s.destacado = :destacado")
    , @NamedQuery(name = "Smartphones.findByPrecio", query = "SELECT s FROM Smartphones s WHERE s.precio = :precio")})
public class Smartphone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "bid")
    private int bid;
    @Basic(optional = false)
    @Column(name = "pantalla")
    private String pantalla;
    @Basic(optional = false)
    @Column(name = "potencia")
    private String potencia;
    @Basic(optional = false)
    @Column(name = "camara")
    private String camara;
    @Basic(optional = false)
    @Column(name = "sensor")
    private String sensor;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "publicado")
    @Temporal(TemporalType.DATE)
    private Date publicado;
    @Basic(optional = false)
    @Column(name = "dimensiones")
    private String dimensiones;
    @Basic(optional = false)
    @Column(name = "peso")
    private int peso;
    @Basic(optional = false)
    @Column(name = "bateria")
    private int bateria;
    @Basic(optional = false)
    @Column(name = "colores")
    private String colores;
    @Basic(optional = false)
    @Lob
    @Column(name = "contenido")
    private String contenido;
    @Basic(optional = false)
    @Column(name = "imagemini")
    private String imagemini;
    @Column(name = "destacado")
    private String destacado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;

    public Smartphone() {
    }

    public Smartphone(Integer id) {
        this.id = id;
    }

    public Smartphone(Integer id, int bid, String pantalla, String potencia, String camara, String sensor, String modelo, Date publicado, String dimensiones, int peso, int bateria, String colores, String contenido, String imagemini, BigDecimal precio) {
        this.id = id;
        this.bid = bid;
        this.pantalla = pantalla;
        this.potencia = potencia;
        this.camara = camara;
        this.sensor = sensor;
        this.modelo = modelo;
        this.publicado = publicado;
        this.dimensiones = dimensiones;
        this.peso = peso;
        this.bateria = bateria;
        this.colores = colores;
        this.contenido = contenido;
        this.imagemini = imagemini;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getCamara() {
        return camara;
    }

    public void setCamara(String camara) {
        this.camara = camara;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getPublicado() {
        return publicado;
    }

    public void setPublicado(Date publicado) {
        this.publicado = publicado;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getImagemini() {
        return imagemini;
    }

    public void setImagemini(String imagemini) {
        this.imagemini = imagemini;
    }

    public String getDestacado() {
        return destacado;
    }

    public void setDestacado(String destacado) {
        this.destacado = destacado;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Smartphone)) {
            return false;
        }
        Smartphone other = (Smartphone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.clases.Smartphones[ id=" + id + " ]";
    }
    
}
