
package eventos;

import herramientas.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojos.Socio;

public class hSocio {
    public static List<Socio> obtenerSocios() {
        SessionFactory sf = HibernateUtil.abrirConexion();
        List<Socio> l = null;
        Session session = sf.openSession();
        Query hq = session.createQuery("from Socio");
        l = hq.list();
        HibernateUtil.cerrarSesion(sf);
        return l;
    }
}
