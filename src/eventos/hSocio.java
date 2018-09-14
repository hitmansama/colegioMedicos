package eventos;

import herramientas.HibernateUtil;
import java.awt.Image;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Socio;

public class hSocio {
    public  hSocio(){
        
    }
    public static class datosPersonales  {

        public datosPersonales() {
        }

        public datosPersonales(String codigo, String nombres, String apellidosPaternos, String apellidosMaternos, String cedula, Date fechaNacimiento, String pais, String ciudad, String provincia, String estadoCivil, String conyuge, Image foto, String grupoSanguineo) {
            this.codigo = codigo;
            this.nombres = nombres;
            this.apellidosPaternos = apellidosPaternos;
            this.apellidosMaternos = apellidosMaternos;
            this.cedula = cedula;
            this.fechaNacimiento = fechaNacimiento;
            this.pais = pais;
            this.ciudad = ciudad;
            this.provincia = provincia;
            this.estadoCivil = estadoCivil;
            this.conyuge = conyuge;
            this.foto = foto;
            this.grupoSanguineo = grupoSanguineo;
        }

        public datosPersonales(String codigo, String nombres, String apellidosPaternos, String apellidosMaternos, String cedula, Date fechaNacimiento, String pais, String ciudad, String provincia, String estadoCivil, String conyuge, String grupoSanguineo) {
            this.codigo = codigo;
            this.nombres = nombres;
            this.apellidosPaternos = apellidosPaternos;
            this.apellidosMaternos = apellidosMaternos;
            this.cedula = cedula;
            this.fechaNacimiento = fechaNacimiento;
            this.pais = pais;
            this.ciudad = ciudad;
            this.provincia = provincia;
            this.estadoCivil = estadoCivil;
            this.conyuge = conyuge;
            this.grupoSanguineo = grupoSanguineo;
        }

        private String codigo;
        private String nombres;
        private String apellidosPaternos;
        private String apellidosMaternos;
        private String cedula;
        private Date fechaNacimiento;
        private String pais;
        private String ciudad;
        private String provincia;
        private String estadoCivil;
        private String conyuge;
        private Image foto;
        private String grupoSanguineo;

        public String getGrupoSanguineo() {
            return grupoSanguineo;
        }

        public void setGrupoSanguineo(String grupoSanguineo) {
            this.grupoSanguineo = grupoSanguineo;
        }

        public Image getFoto() {
            return foto;
        }

        public void setFoto(Image foto) {
            this.foto = foto;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getApellidosPaternos() {
            return apellidosPaternos;
        }

        public void setApellidosPaternos(String apellidosPaternos) {
            this.apellidosPaternos = apellidosPaternos;
        }

        public String getApellidosMaternos() {
            return apellidosMaternos;
        }

        public void setApellidosMaternos(String apellidosMaternos) {
            this.apellidosMaternos = apellidosMaternos;
        }

        public String getCedula() {
            return cedula;
        }

        public void setCedula(String cedula) {
            this.cedula = cedula;
        }

        public Date getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(Date fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public String getPais() {
            return pais;
        }

        public void setPais(String pais) {
            this.pais = pais;
        }

        public String getCiudad() {
            return ciudad;
        }

        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }

        public String getProvincia() {
            return provincia;
        }

        public void setProvincia(String provincia) {
            this.provincia = provincia;
        }

        public String getEstadoCivil() {
            return estadoCivil;
        }

        public void setEstadoCivil(String estadoCivil) {
            this.estadoCivil = estadoCivil;
        }

        public String getConyuge() {
            return conyuge;
        }

        public void setConyuge(String conyuge) {
            this.conyuge = conyuge;
        }

    }

    public static class datosEstudios {

        private String universidadGraduacion;
        private String tituloGraduacion;
        private String inscripcionSanitaria;
        private String libro;
        private String folio;
        private String lugarGraduacion;
        private Date fechaGraduacion;
        private String tituloEspecialidad;
        private String universidadEspecialidad;
        private Date fechaEspecialidad;
        private String medicaturaRural;
        private Date fechaRural;

        public datosEstudios(String universidadGraduacion, String tituloGraduacion, String inscripcionSanitaria, String libro, String folio, String lugarGraduacion, Date fechaGraduacion, String tituloEspecialidad, String universidadEspecialidad, Date fechaEspecialidad, String medicaturaRural, Date fechaRural) {
            this.universidadGraduacion = universidadGraduacion;
            this.tituloGraduacion = tituloGraduacion;
            this.inscripcionSanitaria = inscripcionSanitaria;
            this.libro = libro;
            this.folio = folio;
            this.lugarGraduacion = lugarGraduacion;
            this.fechaGraduacion = fechaGraduacion;
            this.tituloEspecialidad = tituloEspecialidad;
            this.universidadEspecialidad = universidadEspecialidad;
            this.fechaEspecialidad = fechaEspecialidad;
            this.medicaturaRural = medicaturaRural;
            this.fechaRural = fechaRural;
        }

        public datosEstudios() {
        }

        public String getUniversidadGraduacion() {
            return universidadGraduacion;
        }

        public void setUniversidadGraduacion(String universidadGraduacion) {
            this.universidadGraduacion = universidadGraduacion;
        }

        public String getTituloGraduacion() {
            return tituloGraduacion;
        }

        public void setTituloGraduacion(String tituloGraduacion) {
            this.tituloGraduacion = tituloGraduacion;
        }

        public String getInscripcionSanitaria() {
            return inscripcionSanitaria;
        }

        public void setInscripcionSanitaria(String inscripcionSanitaria) {
            this.inscripcionSanitaria = inscripcionSanitaria;
        }

        public String getLibro() {
            return libro;
        }

        public void setLibro(String libro) {
            this.libro = libro;
        }

        public String getFolio() {
            return folio;
        }

        public void setFolio(String folio) {
            this.folio = folio;
        }

        public String getLugarGraduacion() {
            return lugarGraduacion;
        }

        public void setLugarGraduacion(String lugarGraduacion) {
            this.lugarGraduacion = lugarGraduacion;
        }

        public Date getFechaGraduacion() {
            return fechaGraduacion;
        }

        public void setFechaGraduacion(Date fechaGraduacion) {
            this.fechaGraduacion = fechaGraduacion;
        }

        public String getTituloEspecialidad() {
            return tituloEspecialidad;
        }

        public void setTituloEspecialidad(String tituloEspecialidad) {
            this.tituloEspecialidad = tituloEspecialidad;
        }

        public String getUniversidadEspecialidad() {
            return universidadEspecialidad;
        }

        public void setUniversidadEspecialidad(String universidadEspecialidad) {
            this.universidadEspecialidad = universidadEspecialidad;
        }

        public Date getFechaEspecialidad() {
            return fechaEspecialidad;
        }

        public void setFechaEspecialidad(Date fechaEspecialidad) {
            this.fechaEspecialidad = fechaEspecialidad;
        }

        public String getMedicaturaRural() {
            return medicaturaRural;
        }

        public void setMedicaturaRural(String medicaturaRural) {
            this.medicaturaRural = medicaturaRural;
        }

        public Date getFechaRural() {
            return fechaRural;
        }

        public void setFechaRural(Date fechaRural) {
            this.fechaRural = fechaRural;
        }

    }

    public static class datosContacto {

        private String residencia;
        private String direccion;
        private String telefono;
        private String consultorio;
        private String telfonoConsultorio;
        private String email;
        private String celular;

        public datosContacto(String residencia, String direccion, String telefono, String consultorio, String telfonoConsultorio, String email, String celular) {
            this.residencia = residencia;
            this.direccion = direccion;
            this.telefono = telefono;
            this.consultorio = consultorio;
            this.telfonoConsultorio = telfonoConsultorio;
            this.email = email;
            this.celular = celular;
        }

        public datosContacto() {
        }

        public String getResidencia() {
            return residencia;
        }

        public void setResidencia(String residencia) {
            this.residencia = residencia;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getConsultorio() {
            return consultorio;
        }

        public void setConsultorio(String consultorio) {
            this.consultorio = consultorio;
        }

        public String getTelfonoConsultorio() {
            return telfonoConsultorio;
        }

        public void setTelfonoConsultorio(String telfonoConsultorio) {
            this.telfonoConsultorio = telfonoConsultorio;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCelular() {
            return celular;
        }

        public void setCelular(String celular) {
            this.celular = celular;
        }

    }

    public static List<Socio> obtenerSocios() {
        SessionFactory sf = HibernateUtil.abrirConexion();
        List<Socio> l = null;
        Session session = sf.openSession();
        Query hq = session.createQuery("from Socio");
        l = hq.list();
        HibernateUtil.cerrarSesion(sf);
        return l;
    }

    public static boolean guardarSocioNuevo(datosPersonales _datosPersonales, datosEstudios _datosEstudios, datosContacto _datosContacto) {
        Socio socio = new Socio();
        socio.setCodigo(_datosPersonales.getCodigo());
        socio.setCedula(_datosPersonales.getCedula());
        socio.setNombres(_datosPersonales.getNombres());
        socio.setApellidoPaterno(_datosPersonales.getApellidosPaternos());
        socio.setApellidoMaterno(_datosPersonales.getApellidosMaternos());
        socio.setFechaNacimiento(_datosPersonales.getFechaNacimiento());
        socio.setPais(_datosPersonales.getPais());
        socio.setProvincia(_datosPersonales.getProvincia());
        socio.setCiudad(_datosPersonales.getCiudad());
        socio.setEstadoCivil(_datosPersonales.getEstadoCivil());
        socio.setNombresConyuge(_datosPersonales.getConyuge());
        socio.setGrupoSanguineo(_datosPersonales.getGrupoSanguineo());
        socio.setGraduacionUni(_datosEstudios.getUniversidadGraduacion());
        socio.setTituloDe(_datosEstudios.getTituloGraduacion());
        socio.setInscripcionSanitaria(_datosEstudios.getInscripcionSanitaria());
        socio.setLibro(_datosEstudios.getLibro());
        socio.setFolio(_datosEstudios.getFolio());
        socio.setLugarGrad(_datosEstudios.getLugarGraduacion());
        socio.setFehaGrad(_datosEstudios.getFechaGraduacion());
        socio.setEspecialidad(_datosEstudios.getTituloEspecialidad());
        socio.setUniversidadEsp(_datosEstudios.getUniversidadEspecialidad());
        socio.setFechaEsp(_datosEstudios.fechaEspecialidad);
        socio.setMedicaturaRural(_datosEstudios.getMedicaturaRural());
        socio.setFechaRural(_datosEstudios.getFechaRural());
        socio.setDireccionResidencia(_datosContacto.getDireccion());
        socio.setLugarResidencia(_datosContacto.getResidencia());
        socio.setTelfResidencia(_datosContacto.getTelefono());
        socio.setDireccionConsultorio(_datosContacto.getConsultorio());
        socio.setTelfConsultorio(_datosContacto.getTelfonoConsultorio());
        socio.setEmail(_datosContacto.getEmail());
        socio.setTelfCelular(_datosContacto.getCelular());
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(socio);
            tx.commit();
            HibernateUtil.cerrarSesion(sf);
            return true;
        } catch (Exception e) {
            tx.rollback();
        }
        return false;
    }

    public static boolean guardarSocioNuevo(Socio _socio) {

        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(_socio);
            tx.commit();
            HibernateUtil.cerrarSesion(sf);
            return true;
        } catch (Exception e) {
            tx.rollback();
        }
        return false;
    }

}
