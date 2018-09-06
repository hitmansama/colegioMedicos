package herramientas;

public final class IdiomaESP {
// Ventana login

    public final static String tLogin = "Ingreso usuario";
    public final static String lbUsuario = "Cuenta";
    public final static String lbContrasena = "Contraseña";
    public final static String mErLogin = "Cuenta o contraseña incorrectos.";
    public final static String btIngresar = "Ingresar";
    public final static String btSalir = "Salir";
    public final static String mNoCuentaEncontrada(String _cuenta) {
        return "No se encontró una cuenta " + _cuenta + " asociada.";
    }
    ;
    public final static String tNoCuentaEncontrada = "Cuenta no encontrada";
    public final static String tErrorContra = "Error contraseña";
    public final static String mErrorContra = "Contraseña equivocada. Revise su contraseña e inténtelo nuevamente.";
//ventana principal
    public final static String tPrincipal = "Colegio de médicos (Sistema de control socios).";
    public final static String op01 = "Programa";
    public final static String op01op01 = "Cerrar";
    public final static String Menu01 = "Administrar cuentas";
    public final static String Menu01Item01 = "Mi cuenta";
    public final static String Menu01Item02 = "Recuperar contraseña";
    public final static String Menu01Item03 = "SupAdmin Cuentas";
   //Ventana Mi Cuenta
    public final static String tMiCuenta = "Mi cuenta";
    public final static String lbNombres = "Nombres";
    public final static String lbApellidos = "Apellidos";
    public final static String btActualizar = "Actualizar";
    public final static String btCancelar = "Cancelar";
    public final static String mErMiCuentaCampoVacio ="Todos los campos son obligatorios.";
    public final static String mMiCuentaActualizada = "Se actualizó con éxito la cuenta";
    public final static String mErMiCuentaGuardar = "No se pudo actualizar la cuenta.";
    // venana Recuperar contraseña
    public final static String tRecuperarContrasena = "Recuperar contraseñas cuentas";
    public final static String btBuscar = "Buscar";
    public final static String mNoPrivilegioCuenta = "La cuenta es administrador o súper administrador, no tiene privilegios para acceder a esta cuenta.";
    public final static String tNoPrivilegioCuenta = "No se puede acceder a la cuenta.";
    //
    public final static String tSupAdminCuenta = "administrador Cuentas";
    public final static String mErEditarSinSele = "Debe seleccionar un objeto de la tabla";
    //TITULOS JOPTION
    public final static String jopInf = "Información";
    public final static String jopErr = "Error";
    public final static String jopWar = "Advertencia";
    public final static String jopQue = "Confirmación";
    public final static String bNuevo = "Nuevo";
    public final static String lNombres = "Nombres";
    public final static String lApellidos = "Apellidos";
    public final static String lTipoCuenta = "Tipo cuenta";
    public final static String mTipoAdmin = "Administrador";
    public final static String mTipoNormal = "Usuario";
    public final static String btGuardar = "Guardar";
    public final static String mGuardarUsuario = "Se guardó con éxito el nuevo usuario";
    public final static String tGuardarUsuario = "Guardar usuario";
    public final static String mErGuardarUsuario = "No se pudo guardar el nuevo usuario";
    public final static String mErExisteUsuario  = "Ya existe un usuario ";
    public final static String tEditarUsuario = "Editar usuario";
    public final static String mErSinPrivilegios = "No cuenta con los privilegios de Súper Administrador para esta acción";

    //ERRORES
    public final static String mErMaxJInter = "Hubo un error al tratar de reestablecer la ventana";
    public final static String mErConexionBD = "No se pudo establecer conexión con el servidor.";
    public final static String tErConexionBD = "Conexión a base de datos";
    //Salir del programa
    public final static String mSalir = "¿Está seguro que desea salir del programa principal?";
    public final static String tSalir = "Salir del programa";

}
