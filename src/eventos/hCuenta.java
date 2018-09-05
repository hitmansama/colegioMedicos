
package eventos;
import herramientas.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pojos.Cuenta;
public class hCuenta {
    public static Cuenta buscarCuenta(String _usuario){
        Cuenta cuenta = null;
        List<Cuenta> cuentas = buscarCuentas();
        Iterator it = cuentas.iterator();
        while(it.hasNext()){
            Cuenta  aux = (Cuenta)it.next();
            if(aux.getUsuario().equals(_usuario)){
                return aux;
            }
        }
        return null;
    }
    public static Cuenta obtenerCuenta(int _id){
       SessionFactory sf = HibernateUtil.abrirConexion();
       Cuenta l = null;
        Session session = sf.openSession();
        l = (Cuenta) session.get(Cuenta.class,_id);
        HibernateUtil.cerrarSesion(sf);
        return l;
    }
    private static List<Cuenta> buscarCuentas (){
        SessionFactory sf = HibernateUtil.abrirConexion();
        List<Cuenta> l = null;
        Session session = sf.openSession();
        Query hq = session.createQuery("from Cuenta");
        l = hq.list();
        HibernateUtil.cerrarSesion(sf);
        return l;
    }
    public static boolean editarCuenta(Cuenta _cuenta){
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.merge(_cuenta);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(hCuenta.class.getName()).log(Level.SEVERE, null, e);
        }
        HibernateUtil.cerrarSesion(sf);
        return false;
    }
    /*
    public static boolean editarPersona(Persona _persona){
        SessionFactory sf = HibernateUtil.abrirConexion();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
         try {
            session.merge(_persona);
            tx.commit();
            HibernateUtil.cerrarSesion();
            return true;
        } catch (Exception e) {
            tx.rollback();
            Logger.getLogger(hPersona.class.getName()).log(Level.SEVERE, null, e);
        }
        HibernateUtil.cerrarSesion(sf);
        return false;
    }*/
    
}
