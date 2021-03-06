package pojos;
// Generated 11-sep-2018 10:00:25 by Hibernate Tools 4.3.1



/**
 * Auditoriacuenta generated by hbm2java
 */
public class Auditoriacuenta  implements java.io.Serializable {


     private Integer id;
     private Cuenta cuenta;
     private Socio socio;
     private String detalle;

    public Auditoriacuenta() {
    }

	
    public Auditoriacuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public Auditoriacuenta(Cuenta cuenta, Socio socio, String detalle) {
       this.cuenta = cuenta;
       this.socio = socio;
       this.detalle = detalle;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Cuenta getCuenta() {
        return this.cuenta;
    }
    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public Socio getSocio() {
        return this.socio;
    }
    
    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    public String getDetalle() {
        return this.detalle;
    }
    
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }




}


