package py.com.aquipago.pronetbackend.data.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author vinsfran
 */
@Embeddable
public class DeudasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "servicio_id")
    private long servicioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "factura")
    private String factura;

    public DeudasPK() {
    }

    public DeudasPK(long servicioId, String factura) {
        this.servicioId = servicioId;
        this.factura = factura;
    }

    public long getServicioId() {
        return servicioId;
    }

    public void setServicioId(long servicioId) {
        this.servicioId = servicioId;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) servicioId;
        hash += (factura != null ? factura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeudasPK)) {
            return false;
        }
        DeudasPK other = (DeudasPK) object;
        if (this.servicioId != other.servicioId) {
            return false;
        }
        if ((this.factura == null && other.factura != null) || (this.factura != null && !this.factura.equals(other.factura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.entityPronet.DeudasPK[ servicioId=" + servicioId + ", factura=" + factura + " ]";
    }

}
