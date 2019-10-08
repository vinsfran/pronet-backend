package py.com.aquipago.pronetbackend.data.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author vinsfran
 */
@Entity
@Table(name = "deudas")
public class Deudas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeudasPK deudasPK;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "vencimiento")
    @Temporal(TemporalType.DATE)
    private Date vencimiento;

    @Size(max = 2)
    @Column(name = "estado")
    private String estado;

    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @ManyToOne
    private Clientes clienteId;

    @JoinColumn(name = "servicio_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicios servicios;

    @OneToMany(mappedBy = "deudas")
    private List<Transacciones> transaccionesList;

    public Deudas() {
    }

    public Deudas(DeudasPK deudasPK) {
        this.deudasPK = deudasPK;
    }

    public Deudas(long servicioId, String factura) {
        this.deudasPK = new DeudasPK(servicioId, factura);
    }

    public DeudasPK getDeudasPK() {
        return deudasPK;
    }

    public void setDeudasPK(DeudasPK deudasPK) {
        this.deudasPK = deudasPK;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Clientes getClienteId() {
        return clienteId;
    }

    public void setClienteId(Clientes clienteId) {
        this.clienteId = clienteId;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    @XmlTransient
    public List<Transacciones> getTransaccionesList() {
        return transaccionesList;
    }

    public void setTransaccionesList(List<Transacciones> transaccionesList) {
        this.transaccionesList = transaccionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deudasPK != null ? deudasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deudas)) {
            return false;
        }
        Deudas other = (Deudas) object;
        if ((this.deudasPK == null && other.deudasPK != null) || (this.deudasPK != null && !this.deudasPK.equals(other.deudasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.entityPronet.Deudas[ deudasPK=" + deudasPK + " ]";
    }

}
