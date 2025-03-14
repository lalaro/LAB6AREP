# Lab 6 AREP

Para clonar el proyecto 

Para el Backend:

git clone  ´ https://github.com/lalaro/LAB6AREP.git ´

Para el frontend:

git clone  ´ https://github.com/lalaro/LoginFrontend.git ´

### Prerrequisitos

Se necesita de Maven (La versión más reciente) y Java 21, la instalación debe realizarse desde las paginas oficiales de cada programa.

### Instalación

Para Maven debe irse a https://maven.apache.org/download.cgi, descargar la versión más nueva que allá de Maven (En este caso tenemos la versión 3.9.6) y agregarse en la carpeta de Program Files, luego se hace la respectiva configuración de variables de entorno según la ubicación que tenemos para el archivo de instalación, tanto de MAVEN_HOME y de Path.
Luego revisamos que haya quedado bien configurado con el comando para Windows:

` mvn - v `
o
` mvn -version `

Para Java debe irse a https://www.oracle.com/java/technologies/downloads/?er=221886, descargar la versión 21 de Java y agregarse en la carpeta de Program Files, luego se hace la respectiva configuración de variables de entorno según la ubicación que tenemos para el archivo de instalación, tanto de JAVA_HOME y de Path.
Luego revisamos que haya quedado bien configurado con el comando para Windows:

` java -version `

Si no tenemos la versión solicitada podemos hacer lo siguiente, para el caso de Windows:

Ir al Windows PowerShell y ejecutar como administrador los siguientes codigos:

` [System.Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Java\jdk-21", [System.EnvironmentVariableTarget]::Machine) `

Revisar las rutas de la máquina

`  $env:JAVA_HOME = "C:\Program Files\Java\jdk-21" `

`  $env:Path = "C:\Program Files\Java\jdk-21\bin;" + $env:Path `

`  echo $env:JAVA_HOME `

`  javac -version `

`  java -version `

![image23.jpeg](src/main/resources/images/installation/image23.jpeg)

## Solución del lab

En este taller, diseñaremos e implementaremos una aplicación segura y escalable utilizando la infraestructura de AWS, centrándonos en las mejores prácticas de seguridad. Nuestra arquitectura constará de dos componentes principales:

Servidor 1: Servidor Apache
El servidor Apache será responsable de servir a un cliente HTML+JavaScript asíncrono a través de una conexión segura mediante TLS. El código del lado del cliente se entregará a través de canales cifrados, lo que garantiza la integridad y confidencialidad de los datos durante la descarga.
Servidor 2: Spring Framework
El servidor Spring gestionará los servicios de backend, ofreciendo endpoints API RESTful. Estos servicios también estarán protegidos mediante TLS, lo que garantiza una comunicación segura entre el cliente y el backend.
Características de Seguridad Clave:

Cifrado TLS: Transmisión segura de datos mediante certificados TLS generados mediante Let's Encrypt, lo que garantiza la confidencialidad e integridad.
Cliente Asíncrono: Nuestro cliente HTML+JavaScript utilizará técnicas asíncronas para optimizar el rendimiento y mantener una comunicación segura. Seguridad de inicio de sesión: Implementaremos la autenticación de inicio de sesión, con contraseñas almacenadas de forma segura como hashes.
Implementación en AWS: Todos los servicios se implementarán y gestionarán en AWS, aprovechando su infraestructura segura y confiable.
Este taller guiará a los participantes en el proceso de integración de estas medidas de seguridad, la configuración de implementaciones multiservidor y el uso de técnicas modernas de cifrado para proteger los datos de los usuarios.


### *Resumen del proyecto:*

Yo diseñé e implementé una aplicación segura y escalable en AWS, enfocándome en las mejores prácticas de seguridad. Configuré un servidor Apache para servir un cliente HTML+JavaScript asíncrono a través de una conexión segura con TLS, asegurando la integridad y confidencialidad de los datos. Además, desarrollé un backend con Spring Framework que ofrece endpoints API RESTful protegidos con TLS para garantizar una comunicación segura. Implementé cifrado TLS con certificados de Let's Encrypt, un cliente asíncrono para mejorar el rendimiento, y un sistema de autenticación con almacenamiento seguro de contraseñas en forma de hashes. Finalmente, desplegué todos los servicios en AWS, aprovechando su infraestructura confiable para garantizar la seguridad y escalabilidad del sistema.

### *Arquitectura del sistema:*

### *Detalle de la arquitectura:*

### *Descripción de la relación entre Apache, Spring y el cliente HTML+JS:*

La relación entre Apache, Spring y el cliente HTML+JavaScript sigue un modelo cliente-servidor con una capa de seguridad basada en TLS.

a. Apache como servidor web: Apache se encarga de servir los archivos estáticos del cliente, es decir, el código HTML, CSS y JavaScript. Además, establece una conexión segura mediante TLS, asegurando que la comunicación entre el usuario y el cliente web sea cifrada y protegida.

b. Cliente HTML+JavaScript: El cliente, ejecutado en el navegador, interactúa con el servidor backend mediante peticiones asíncronas (AJAX o Fetch API). Se comunica con los endpoints RESTful expuestos por Spring para obtener o enviar datos.

c. Spring como backend: Spring Framework maneja la lógica del servidor, procesando las solicitudes del cliente y respondiendo con datos en formato JSON. Además, protege las conexiones con TLS y gestiona la autenticación de usuarios mediante almacenamiento seguro de credenciales.

En conjunto, Apache distribuye la interfaz del cliente, que se conecta asíncronamente con Spring, garantizando una arquitectura modular, segura y escalable.

### *Implementación segura en AWS:*

Para garantizar una implementación segura en AWS, desplegué los servicios siguiendo las mejores prácticas de seguridad. Configuré Apache en una instancia EC2 para servir los archivos HTML+JavaScript de forma segura, utilizando certificados TLS de Let's Encrypt para cifrar la comunicación. El backend con Spring Framework se ejecuta en otra instancia EC2, asegurando un entorno aislado dentro de una VPC (Virtual Private Cloud) protegida.

### *Uso de TLS para conexiones seguras entre el cliente, Apache y Spring:*

Para garantizar conexiones seguras entre el cliente, Apache y Spring, implementé TLS (Transport Layer Security) en toda la comunicación. Configuré Apache con un certificado TLS de Let's Encrypt, permitiendo que el cliente HTML+JavaScript se conecte mediante HTTPS, asegurando la integridad y confidencialidad de los datos y protegiéndolos contra ataques como man-in-the-middle (MITM). Además, Apache actúa como proxy inverso, reenviando las solicitudes del cliente al backend en Spring a través de una conexión segura con TLS habilitado, evitando que datos sensibles sean interceptados. Gracias a esta implementación, toda la comunicación entre el cliente y el backend viaja cifrada y autenticada, asegurando una infraestructura segura y confiable.

### *Funcionalidad de inicio de sesión con contraseñas almacenadas de forma segura:*

Implementé un inicio de sesión seguro donde las contraseñas se almacenan de forma protegida con bcrypt, evitando el almacenamiento en texto plano. Al autenticarse, el sistema compara los hashes en lugar de las contraseñas originales, asegurando una mayor protección contra accesos no autorizados.

### *Capturas de pantalla:*

Se debe configurar la ruta donde está Apache

![image4.jpeg](src/main/resources/images/image4.jpeg)

Y configuración del puerto donde va escuchar el front

![image17.jpeg](src/main/resources/images/image17.jpeg)

Es importante primero inciar Apache:

![image1.jpeg](src/main/resources/images/image1.jpeg)
![image2.jpeg](src/main/resources/images/image2.jpeg)

Comprobamos que Apache funcione:

![image3.jpeg](src/main/resources/images/image3.jpeg)

Se le da la ruta de nuestro proyecto Apache:

![image12.jpeg](src/main/resources/images/image12.jpeg)
![image13.jpeg](src/main/resources/images/image13.jpeg)

Se debe conectar el front con el back

![image 5.jpeg](src/main/resources/images/image%205.jpeg)

Compilamos el proyecto back

![image6.jpeg](src/main/resources/images/image6.jpeg)

Se dockeriza el back con el front 

![image7.jpeg](src/main/resources/images/image7.jpeg)
![image8.jpeg](src/main/resources/images/image8.jpeg)
![image9.jpeg](src/main/resources/images/image9.jpeg)

Configuramos los puertos del docker

![image10.jpeg](src/main/resources/images/image10.jpeg)

Se verifica el push del Docker

![image11.jpeg](src/main/resources/images/image11.jpeg)
![image14.jpeg](src/main/resources/images/image14.jpeg)

Se verifica que la ruta del Docker funcione:

![image15.jpeg](src/main/resources/images/image15.jpeg)

Es importante generar el certificado TLS para el front

![image16.jpeg](src/main/resources/images/image16.jpeg)

Se inician las instancias del EC2 y se configuran:

![image18.jpeg](src/main/resources/images/image18.jpeg)
![image19.jpeg](src/main/resources/images/image19.jpeg)
![image20.jpeg](src/main/resources/images/image20.jpeg)
![image21.jpeg](src/main/resources/images/image21.jpeg)

Tendremos nuestro despliegue con la seguridad, según el certificado TLS

![image22.jpeg](src/main/resources/images/image22.jpeg)

### *Video:*

Video: [Video funcionamiento](https://youtu.be/99LdZeAXAZ0)

## Ejecutando las pruebas

Podemos Abrir en terminal el proyecto y ejecutar las pruebas desde el PowerShell, en el caso de Windows. Y ejecutamos el comando:

` mvn test `

O de igual forma en el ID que deseemos.

Así se vera:

![image26.jpeg](src/main/resources/images/installation/image26.jpeg)
![image27.jpeg](src/main/resources/images/installation/image27.jpeg)

### Desglose en pruebas de extremo a extremo

1. testValidateUser_Failure

Qué prueba: Verifica que la validación de un usuario con una contraseña incorrecta falle.
Por qué la prueba: Asegura que el sistema no permite el acceso con credenciales incorrectas, protegiendo así la autenticación.

2. testValidateUserSuccess

Qué prueba: Verifica que un usuario con credenciales correctas pueda autenticarse correctamente.
Por qué la prueba: Confirma que el sistema autentica correctamente a los usuarios cuando proporcionan las credenciales adecuadas.

3. testValidateUserFailure_WrongPassword

Qué prueba: Comprueba que un usuario con nombre válido pero contraseña incorrecta no pueda autenticarse.
Por qué la prueba: Garantiza que las credenciales incorrectas no permitan acceso al sistema.

4. testValidateUserFailure_UserNotFound

Qué prueba: Verifica que un usuario inexistente no pueda autenticarse.
Por qué la prueba: Asegura que solo los usuarios registrados puedan acceder al sistema.

5. testValidateUserWithNullPassword

Qué prueba: Verifica que el sistema maneje correctamente una contraseña nula en la autenticación.
Por qué la prueba: Evita posibles errores o vulnerabilidades por valores nulos en las credenciales.

6. testValidateUserWithIncorrectPassword

Qué prueba: Asegura que una contraseña incorrecta no permita el acceso.
Por qué la prueba: Protege contra intentos de acceso con credenciales incorrectas.

7. testValidateUserWithNonExistentUsername

Qué prueba: Comprueba que un nombre de usuario inexistente no pueda autenticarse.
Por qué la prueba: Previene accesos indebidos con nombres de usuario no registrados.

8. testValidateUserWithIncorrectPassword2

Qué prueba: Similar a testValidateUserWithIncorrectPassword, valida el rechazo de contraseñas incorrectas.
Por qué la prueba: Refuerza la validación de seguridad en autenticaciones fallidas.

9. testValidateUserWithNonExistentUsername2

Qué prueba: Similar a testValidateUserWithNonExistentUsername, verifica que usuarios inexistentes sean rechazados.
Por qué la prueba: Garantiza que solo usuarios registrados puedan autenticarse.

10. testValidateUserWithHashedPasswordMismatch

Qué prueba: Verifica que un usuario con una contraseña incorrecta y una versión hash diferente no pueda autenticarse.
Por qué la prueba: Asegura que las contraseñas se comparan correctamente utilizando hashing, protegiendo la autenticación.

### Y pruebas de estilo de código

Las pruebas realizadas verifican la seguridad del proceso de autenticación en la aplicación, asegurando que solo los usuarios con credenciales correctas puedan acceder. Se evaluaron distintos escenarios, incluyendo contraseñas incorrectas, usuarios inexistentes, valores nulos y comparaciones de contraseñas encriptadas. Estas pruebas garantizan que el sistema maneje correctamente los intentos de autenticación fallidos, evitando accesos no autorizados y fortaleciendo la seguridad de la aplicación.

## Despliegue

Podemos Abrir en terminal el proyecto y compilar y empaquetar el proyecto desde el PowerShell, en el caso de Windows. Y ejecutamos los comandos:

` mvn clean install `

` mvn spring-boot:run `

O de igual forma en el ID que deseemos.

Así se verá:

![image24.jpeg](src/main/resources/images/installation/image24.jpeg)
![image25.jpeg](src/main/resources/images/installation/image25.jpeg)

## Construido con

* [Maven](https://maven.apache.org/) - Gestión de dependencias.
* [Java](https://www.java.com/es/) - Versionamiento en Java.
* [GitHub](https://docs.github.com/es) - Sistema de control de versiones distribuido.
* [IntelliJ](https://www.jetbrains.com/es-es/idea/) - Entorno de desarrollo integrado.
* [AWS](https://docs.aws.amazon.com/es_es/) - Amazon Web Services / plataforma de servicios de nube.
* [Docker](https://docs.docker.com/) - Tecnología en contenedores que permite crear y usar contenedores Linux.
* [Spring Boot](https://docs.spring.io/spring-boot/index.html) -Herramienta de código abierto para desarrollar aplicaciones web y microservicios en Java
* [Apache](https://httpd.apache.org/docs/) -Es un servidor web de código abierto y gratuito que se utiliza para alojar sitios web

## Contribuyendo

Por favor, lee [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) para detalles sobre nuestro código de conducta y el proceso para enviarnos solicitudes de cambios (*pull requests*).

## Versionado

Usamos [SemVer](http://semver.org/) para el versionado.

## Autores

* **Laura Valentina Rodríguez Ortegón** - *Lab5 AREP* - [Repositorio](https://github.com/lalaro/LAB5AREP_CRUD.git)

## Licencia

Este proyecto está licenciado bajo la Licencia MIT - consulta el archivo [LICENSE.md](LICENSE.md) para más detalles.

## Reconocimientos

* Agradecimientos a la Escuela Colombiana de Ingeniería
* La documentación de Git Hub
* Al profesor Luis Daniel Benavides
