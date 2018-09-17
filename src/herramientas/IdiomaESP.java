package herramientas;

public final class IdiomaESP {
// Ventana login

    public final static String tLogin = "Ingreso usuario";
    public final static String lbUsuario = "Cuenta";
    public final static String lbContrasena = "Contraseña";
    public final static String mErLogin = "Cuenta o contraseña incorrectos.";
    public final static String btIngresar = "Ingresar";
    public final static String btSalir = "Salir";
    public final static String tEstadoSocio = "Estado";
    public final static String lbOpActivo = "Activo";
    public final static String lbOpInactivo = "Inactivo";

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
    public final static String mErMiCuentaCampoVacio = "Todos los campos son obligatorios.";
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
    public final static String tDatosPersonales = "Datos personales";
    public final static String tDatosEducacion = "Datos de educación";
    public final static String tDatosContacto = "Datos de contacto";
    public final static String lCodigo = "Código";
    public final static String lCedula = "Cédula";
    public final static String lbApelPat = "Apellido pat";
    public final static String lbApelMat = "Apellido mat";
    public final static String lbfechaNac = "Fecha nac";
    public final static String lbCiudad = "Ciudad";
    public final static String lbProv = "Provincia";
    public final static String lbPais = "Pais";
    public final static String tGraduacion = "Graduacion";
    public final static String lbUniv = "Universidad";
    public final static String lbTitulo = "Titulo de";
    public final static String lbEstadoCiv = "Est. civil";
    public final static String lbOpcSoltero = "Soltero/a";
    public final static String lbOpcCasado = "Casado/a";
    public final static String lbOpcDivorciado = "Divorciado/a";
    public final static String lbOpcViudo = "Viudo/a";
    public final static String lbOpcSeleccionar = "Seleccionar";
    public final static String lbNombreConyuge = "Conyuge";
    public final static String phCodigo = "ejm 1234";
    public final static String phNombres = "ejm Carlos Daniel";
    public final static String phApPat = "ejm Zambrano";
    public final static String phApMat = "ejm Vera";
    public final static String phCedula = "ejm 1311766250";
    public final static String phPais = "ejm Ecuador";
    public final static String phProvincia = "ejm Manabi";
    public final static String phCiudad = "ejm Portoviejo";
    public final static String phConyuge = "ejm Ana Maria Menendez Palacios";
    public final static String lbUniversidad = "Universidad";
    public final static String phUniversidad = "ejm Univercidad Tecnica de Manabi";
    public final static String lbInsSanitaria = "Ins. Sanitaria";
    public final static String phInsSanitaria = "ejm InscSanitaria";
    public final static String lbTituloUni = "Titulo de";
    public final static String phTituloUni = "ejm Medico cirujano";
    public final static String lbLibro = "Libro";
    public final static String lbFolio = "Folio";
    public final static String phLibro = "ejm Libro";
    public final static String phFolio = "ejm Folio";
    public final static String lbLugarGrad = "Lugar grad.";
    public final static String phLugarGrad = "ejm Portoviejo";
    public final static String lbFechaGrad = "Fecha";
    public final static String tEspecialidad = "Especialidad";
    public final static String lbEspcialidad = "Titulo Esp";
    public final static String phEspecialidad = "ejm Ginecología";
    public final static String tRural = "Rural";
    public final static String lbRural = "Medicatura rural";
    public final static String phRural = "ejm Centro de salud";
    public final static String lbResidencia = "Residencia";
    public final static String phResidencia = "ejm Portoviejo";
    public final static String lbSangre = "Tipo sangre";

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
    public final static String mErExisteUsuario = "Ya existe un usuario ";
    public final static String tEditarUsuario = "Editar usuario";
    public final static String mErSinPrivilegios = "No cuenta con los privilegios de Súper Administrador para esta acción";
    public final static String lbDireccion = "Direccion";
    public final static String phDireccion = "ejm Urb Colinas Real";
    public final static String lbDireccionConsul = "Consultorio";
    public final static String phConsultorio = "ejm Plaza Medic";
    public final static String lbTelfono = "Telefono";
    public final static String phTelefono = "ejm 052635542";
    public final static String lbCorreo  = "email";
    public final static String phCorreo = "ejm nombre@xmail.com";
    public final static String lbCelular = "Celular";
    public final static String phCelular = "ejm 0999123456";
    public final static String tNuevoSocio = "Nuevo socio";
    //ERRORES
    public final static String mErMaxJInter = "Hubo un error al tratar de reestablecer la ventana";
    public final static String mErConexionBD = "No se pudo establecer conexión con el servidor.";
    public final static String tErConexionBD = "Conexión a base de datos";
    //Salir del programa
    public final static String mSalir = "¿Está seguro que desea salir del programa principal?";
    public final static String tSalir = "Salir del programa";

}
