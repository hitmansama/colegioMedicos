package colegiomedicos;
import herramientas.HibernateUtil;
import herramientas.IdiomaESP;
import javax.swing.JFrame;
public class ColegioMedicos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(!HibernateUtil.estadoConexion()){
            herramientas.Herramientas.MensajeErr(IdiomaESP.mErConexionBD,IdiomaESP.tErConexionBD);
            System.exit(0);
        }
        else{
           /* JFrame aux = new jfVentanaPrincipal();
            herramientas.Herramientas.fullSecreen(aux);
            aux.setTitle(IdiomaESP.tPrincipal);
            aux.setVisible(true);*/
           new jdLogin(null, true).setVisible(true);
        }
    }
    
}
