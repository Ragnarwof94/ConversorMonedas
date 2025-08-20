💰 Conversor de Monedas en Java 17

Este es un sencillo pero potente Conversor de Monedas desarrollado en Java 17. Permite a los usuarios obtener tasas de cambio en tiempo real y convertir entre diferentes monedas utilizando una API externa.



🌟 Características

Tasas de Cambio en Tiempo Real: Obtiene las tasas de conversión actualizadas de la API ExchangeRate-API.com.



Interfaz de Consola: Interacción simple y directa a través de la línea de comandos.



Fácil de Usar: Solicita al usuario la moneda de origen, la moneda de destino y la cantidad a convertir.



Manejo de Errores: Incluye manejo de excepciones para errores de red, formato JSON y entradas de usuario inválidas.



Lista de Monedas Disponibles: Muestra una lista clara y organizada de las monedas soportadas por la API.



🛠️ Tecnologías Utilizadas

Java Development Kit (JDK) 17: El entorno de desarrollo y ejecución principal.



Maven: Herramienta para la gestión de dependencias y la construcción del proyecto.



Gson 2.10.1: Librería de Google para la serialización y deserialización de objetos Java a/desde JSON.



Java 11+ HttpClient: API nativa de Java para realizar solicitudes HTTP.



ExchangeRate-API.com: API externa para obtener tasas de cambio de divisas.



🚀 Cómo Empezar

Sigue estos pasos para poner en marcha el proyecto en tu máquina local.



Requisitos Previos

Asegúrate de tener instalado lo siguiente:



JDK 17 o superior.



Maven (generalmente incluido con los IDEs modernos como IntelliJ IDEA).



Un IDE de Java (IntelliJ IDEA, Eclipse, VS Code con extensiones Java, etc.).



1\. Obtener una Clave API

Este proyecto utiliza ExchangeRate-API.com para obtener las tasas de cambio. Necesitarás una clave API gratuita.



Visita https://www.exchangerate-api.com/s/free.



Regístrate para obtener tu clave API gratuita.



Copia tu clave API.



2\. Configuración del Proyecto

Clonar el repositorio (si ya lo tienes en tu máquina local, omite este paso):



git clone https://github.com/tu\_usuario/Conversor-monedas.git

cd Conversor-monedas



(Nota: Reemplaza https://github.com/tu\_usuario/Conversor-monedas.git con la URL real de tu repositorio si lo estás clonando desde GitHub después de subirlo).



Abrir el proyecto en tu IDE:



Abre tu IDE (ej. IntelliJ IDEA).



Selecciona "Open" o "Abrir" y navega hasta la carpeta Conversor-monedas que acabas de clonar/crear.



Tu IDE debería detectar automáticamente que es un proyecto Maven e importar las dependencias.



Añadir la dependencia Gson (si aún no está):



Abre el archivo pom.xml en la raíz de tu proyecto.



Asegúrate de que la siguiente sección de <dependencies> esté presente:



<dependencies>

&nbsp;   <dependency>

&nbsp;       <groupId>com.google.code.gson</groupId>

&nbsp;       <artifactId>gson</artifactId>

&nbsp;       <version>2.10.1</version>

&nbsp;   </dependency>

</dependencies>



Si realizaste cambios, recarga el proyecto Maven en tu IDE para descargar la librería.



Insertar tu Clave API en el código:



Abre el archivo ConversorMonedas.java (ubicado en src/main/java/ConversorMonedas.java).



Busca la línea:



private static final String API\_KEY = "";



Reemplaza las comillas vacías "" con tu clave API obtenida de ExchangeRate-API.com. Por ejemplo:



private static final String API\_KEY = "TU\_CLAVE\_API\_AQUI";



Importante: Si estás ejecutando esto en un entorno como Canvas, la clave API podría ser proporcionada automáticamente por el entorno. Si ese es el caso, puedes dejar la cadena vacía como está.



3\. Ejecutar el Proyecto

En tu IDE, navega a la clase ConversorMonedas.java.



Haz clic derecho en el archivo o dentro del código y selecciona "Run 'ConversorMonedas.main()'" (o un botón de "Play" similar en la barra de herramientas superior).



El programa se ejecutará en la ventana de la consola de tu IDE. Sigue las instrucciones para ingresar las monedas y la cantidad.



💡 Posibles Mejoras

Interfaz Gráfica de Usuario (GUI): Implementar una interfaz gráfica usando SwingFX, JavaFX o frameworks web.



Selección de Moneda Base: Permitir al usuario elegir la moneda base para las tasas de cambio.



Historial de Conversiones: Guardar un registro de las conversiones realizadas.



Validación de Entrada Mejorada: Validar la entrada del usuario de forma más robusta (ej. expresiones regulares para códigos de moneda).



Manejo de Errores Más Detallado: Proporcionar mensajes de error más específicos para diferentes escenarios de fallo de la API.



🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si tienes ideas para mejorar este conversor, no dudes en abrir un "issue" o enviar un "pull request".



📄 Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

