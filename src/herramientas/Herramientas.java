package herramientas;

import colegiomedicos.jiMiCuenta;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

/**
 * getIcono no static. CONSTRUIR
 *
 * @author PC
 */
public final class Herramientas {

    public final static String obligatorio(String _texto) {
        return "<html><font color=black>" + _texto + "</font><font color=red>*</font></html>";
    }

    public static void fullSecreen(JFrame ventana) {
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private static String TextoEditado(String vTexto) {
        int n = 0;
        String tr = "";
        for (int i = 0; i < vTexto.length(); i++) {
            if (n < 52) {
                tr += vTexto.charAt(i);
                n++;
                if (vTexto.charAt(i) == '\n') {
                    n = 0;
                }
            } else {
                if (Character.isWhitespace(vTexto.charAt(i))) {
                    tr = tr + "\n";
                } else {
                    tr = tr + "-\n";
                    i--;
                }
                n = 0;
            }

        }
        return tr;
    }

    public static void AlinearHorizontalCentro(Component esto, Component EnEsto) {
        esto.setLocation((EnEsto.getWidth() / 2) - (esto.getWidth() / 2), esto.getY());
    }

    public static int CalcularEdad(Date fechaNa) {
        Date today = new Date();
        int diff_year = today.getYear() - fechaNa.getYear();
        int diff_month = today.getMonth() - fechaNa.getMonth();
        int diff_day = today.getDay() - fechaNa.getDay();

        //Si está en ese año pero todavía no los ha cumplido
        if (diff_month < 0 || (diff_month == 0 && diff_day < 0)) {
            diff_year = diff_year - 1; //no aparecían los dos guiones del postincremento :|
        }
        return diff_year;
    }

    private static void CentrarInternalEscritorio(JInternalFrame ventana, JDesktopPane Escritorio) {
        Point p = new Point();
        p.x = Escritorio.getWidth() / 2 - ventana.getWidth() / 2;
        p.y = Escritorio.getHeight() / 2 - ventana.getHeight() / 2;
        ventana.setLocation(p);
    }

    /**
     * javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C,
     * java.awt.event.InputEvent.SHIFT_MASK)
     *
     * @param _texto
     * @param _convinacionTecla
     * @param _ventanaAbrir
     * @param _escritorio
     * @return
     */
    public JMenuItem crearMenuItem(String _texto, javax.swing.KeyStroke _convinacionTecla, JInternalFrame _ventanaAbrir, JDesktopPane _escritorio) {
        JMenuItem menu01item01 = new JMenuItem(_texto);
        menu01item01.setAccelerator(_convinacionTecla);
        menu01item01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAbrirInternal(evt, _ventanaAbrir, _escritorio);
            }
        });
        return menu01item01;
    }

    protected void jMenuAbrirInternal(java.awt.event.ActionEvent evt, JInternalFrame _ven, JDesktopPane _escritorio) {
        AgregarVenEscritorio(_escritorio, _ven);

    }

    public static void AgregarVenEscritorio(JDesktopPane escritorio, JInternalFrame ventana) {
        for (JInternalFrame aux : escritorio.getAllFrames()) {
            if (aux.getName().equals(ventana.getName())) {
                try {
                    aux.setMaximum(true);
                    aux.setMaximum(false);
                } catch (PropertyVetoException ex) {
                    MensajeErr(IdiomaESP.mErMaxJInter);
                }
                CentrarInternalEscritorio(aux, escritorio);
                return;
            }
        }
        escritorio.add(ventana);
        CentrarInternalEscritorio(ventana, escritorio);
        ventana.setVisible(true);

    }

    public static void cambiarIconoVentana(Window ventana, String url) {
        try {
            InputStream imageInputStream = ventana.getClass().getResourceAsStream(url);
            BufferedImage bufferedImage = ImageIO.read(imageInputStream);
            ventana.setIconImage(bufferedImage);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public ImageIcon getIcono(String url, int ancho, int alto) {
        ImageIcon imageIcon = null;
        try {
            imageIcon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream(url)));
            Image aux = imageIcon.getImage();
            imageIcon = new ImageIcon(aux.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
        } catch (IOException ex) {
            // Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageIcon;
    }

    public ImageIcon getIconoExternal(String url, int ancho, int alto) {
        ImageIcon imageIcon = null;
        imageIcon = new ImageIcon(url); // Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        Image aux = imageIcon.getImage();
        float anchPor = imageIcon.getIconWidth() / ancho;
        imageIcon = new ImageIcon(aux.getScaledInstance(ancho, alto, Image.SCALE_AREA_AVERAGING));
        return imageIcon;
    }

    public static void CerrarProgramaPrincipal() {
        if (OkCancelQues(IdiomaESP.mSalir, IdiomaESP.tSalir) == JOptionPane.OK_OPTION) {
            System.exit(1);
        }
    }

    public static void VentanaCentroWindows(Component ventana) {
        Dimension div = Toolkit.getDefaultToolkit().getScreenSize();
        ventana.setLocation(div.width / 2 - ventana.getWidth() / 2, div.height / 2 - ventana.getHeight() / 2);

    }

    public static boolean isContrasena(String _contra, char[] _pass) {
        return _contra.equals(new String(_pass));
    }

    public static BufferedImage Redimensionar(InputStream imagen, int ancho, int alto) {
        BufferedImage im = null;
        /*int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;*/
        try {
            im = ImageIO.read(imagen);
            BufferedImage nim = new BufferedImage(ancho, alto, im.getType());
            Graphics2D nimg = nim.createGraphics();
            nimg.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            nimg.dispose();
            return nim;
        } catch (IOException ex) {
            //new PlayAudio().Error();
            MensajeErr(ex.getMessage());
        }

        return null;
    }

    public static Byte toByte(boolean _estado) {
        return new Byte(_estado ? "1" : "0");
    }

    public static boolean isFloat(String _valor) {
        try {
            Float.parseFloat(_valor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void EncolumnarComponentes(List<Component> _objetos, int _enAncho, int _nColumnas) {
        if ((_objetos != null || _objetos.size() > 0) && _enAncho > 0 && _nColumnas > 0) {
            int anchoComponentes = (_enAncho - (_nColumnas * 10 + 15)) / _nColumnas;
            int nCol = 0;
            int posX = 0;
            int posY = 0;
            Iterator<Component> iterator = _objetos.iterator();
            while (iterator.hasNext()) {
                //coger cada uno de los componetes a encolumnar
                Component cAux = iterator.next();
                try {
                    JLabel temp = (JLabel) cAux;
                    temp.setHorizontalAlignment(JLabel.CENTER);
                } catch (Exception e) {
                }
                //si recien empieza a encolumnar se hubica en la misma fila que inica.
                //pone el tamaño de cada uno de los componentes iguales.
                cAux.setSize(anchoComponentes, cAux.getSize().height);
                if (posY == 0) {
                    posY = cAux.getLocation().y;
                }

                posX += 10;
                cAux.setLocation(new Point(posX, posY));
                nCol++;
                posX += anchoComponentes;
                if (nCol >= _nColumnas) {
                    posY += cAux.getSize().height + 10;
                    posX = 0;
                    nCol = 0;
                }
            }
        }
    }

    public static byte[] toByte(File _file) throws IOException {
        BufferedImage buffImage = ImageIO.read(_file);
        WritableRaster raster = buffImage.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();
        return data.getData();
    }

    public static BufferedImage toImage(byte[] codigoImagen) throws IOException {

        ByteArrayInputStream bis = new ByteArrayInputStream(codigoImagen);
        BufferedImage bImage = ImageIO.read(bis);
        return bImage;
    }

    public static String formatearDecimal(Float _valor) {
        return String.format(Locale.ROOT, "%.2f", _valor);
    }

    // <editor-fold defaultstate="collapsed" desc="JOPTION MENSAJES">   
    public static void MensajeInfo(String Texto) {
        JOptionPane.showMessageDialog(null, TextoEditado(Texto), IdiomaESP.jopInf, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void MensajeInfo(String Texto, String Titulo) {
        JOptionPane.showMessageDialog(null, TextoEditado(Texto), Titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void MensajeErr(String Texto) {
        JOptionPane.showMessageDialog(null, TextoEditado(Texto), IdiomaESP.jopErr, JOptionPane.ERROR_MESSAGE);
    }

    public static void MensajeErr(String Texto, String Titulo) {
        JOptionPane.showMessageDialog(null, TextoEditado(Texto), Titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void MensajeAdv(String Texto) {
        JOptionPane.showMessageDialog(null, TextoEditado(Texto), IdiomaESP.jopWar, JOptionPane.WARNING_MESSAGE);
    }

    public static void MensajeAdv(String Texto, String Titulo) {
        JOptionPane.showMessageDialog(null, TextoEditado(Texto), Titulo, JOptionPane.WARNING_MESSAGE);
    }// </editor-fold>  
    // <editor-fold defaultstate="collapsed" desc="JOPTION PREGUNTA">   

    public static int OkCancelQues(String Texto) {
        return JOptionPane.showConfirmDialog(null, TextoEditado(Texto), IdiomaESP.jopQue, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public static int OkCancelQues(String Texto, String Titulo) {
        return JOptionPane.showConfirmDialog(null, TextoEditado(Texto), Titulo, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public static int OkCancelErr(String Texto) {
        return JOptionPane.showConfirmDialog(null, TextoEditado(Texto), IdiomaESP.jopErr, JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
    }

    public static int OkCancelErr(String Texto, String Titulo) {
        return JOptionPane.showConfirmDialog(null, TextoEditado(Texto), Titulo, JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
    }

    public static int OkCancelAdv(String Texto) {
        return JOptionPane.showConfirmDialog(null, TextoEditado(Texto), IdiomaESP.jopWar, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
    }

    public static int OkCancelAdv(String Texto, String Titulo) {
        return JOptionPane.showConfirmDialog(null, TextoEditado(Texto), Titulo, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
    }

    public static int YesNoCancel(String Texto) {
        return JOptionPane.showConfirmDialog(null, TextoEditado(Texto), IdiomaESP.jopQue, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    public static int YesNoCancel(String Texto, String Titulo) {
        return JOptionPane.showConfirmDialog(null, TextoEditado(Texto), Titulo, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }// </editor-fold>  
}
