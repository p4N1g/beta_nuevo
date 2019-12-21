<% @ page contentType = "text / html" import = "java.util. *"%>
<% = new java.util.Date ()%>. <% Y%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Acceso</title>
    <meta name="viewport" content="width-device-width">
    <link rel="stylesheet" href="../css/styleacceso.css">
    <html xmlns="http://www.w3.org/1999/xhtml"></html>
    <meta name="description" content="Web para crear grupos de investigacion con profesionales, conocer profesionales de tu entorno, noticias, etc.">
    <meta name="keywords" content="researchers,investigadores,grupos de investigacion,profesionales">
    <meta name="author" content="Antonio Sanchez,Carlos Freire, Francisco Cordoba, Angel Cañuelo">
    <script src="../js/funcion_validar_datos.js"></script>
    <!--Pasalo ya antonioo-->
</head>
<body>
    <div class="contenedor-form">
        <div class="toggle">
            <span>Crear Cuenta</span>
        </div>

        <div class="formulario">
        <h2> Iniciar Sesión </h2>
        <form action="IniciaSesion">
                Email<br>
                <input type="text" placeholder="Introduce tu Email" id="log" required><br>
                Contraseña<br>
                <input type="password" placeholder="Introduce tu Contraseña" id="pass" required><br>
                <input onclick=go() type="button" value="Iniciar Sesión">
        </form>
        <div class="olvido-password">
            <a href="#">Olvidé mi contraseña</a>
         </div>
        </div>

        <div class="formulario">
                <h2> Crear cuenta </h2>
                <form action="Creacuenta">
                    Nombre<br>
                    <input type="text" placeholder="Introduce tu Nombre" required><br>
                    Apellidos<br>
                    <input type="text" placeholder="Introduce tus Apellidos" required><br>
                    Nombre de Usuario<br>
                    <input type="text" placeholder="Introduce tu Usuario" required><br>
                    Email<br>
                    <input type="email" placeholder="Introduce tu Email" required><br>
                    Contraseña<br>
                    <input type="password" placeholder="Introduce tu Contraseña" required><br>
                    Fecha de Nacimiento<br>
                    <input type="date" required><br>
                    Sexo<br>
                    <input type="radio" name="gender" value="Masculino"> Masculino<br>
                    <input type="radio" name="gender" value="Femenino"> Femenino<br>
                    <input type="radio" name="gender" value="otro" checked> Otro<br>
                    <input type="submit" value="Registrarse"><br>
                </form>
                <div class="acepta-terminos">
                    <form action="acepta">
                       <input type="checkbox" required>Estoy de acuerdo con <a href="./termino_condiciones.html">Terminos y Condiciones</a><br>
                    </form>
                </div>
         </div>


    </div>
    <script src="../js/jquery-3.4.1.min.js"></script>
    <script src="../js/acceso.js"></script>
</body>
</html>
