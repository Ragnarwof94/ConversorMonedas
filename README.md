# 💰 Conversor de Monedas en Java 17

Este es un sencillo pero potente **Conversor de Monedas** desarrollado en Java 17. Permite a los usuarios obtener tasas de cambio en tiempo real y convertir entre diferentes monedas utilizando una API externa.

## 🌟 Características Destacadas

* **📈 Tasas de Cambio en Tiempo Real:** Obtiene las tasas de conversión actualizadas de la  **API `ExchangeRate-API.com`** .
* **💻 Interfaz de Consola:** Interacción simple y directa a través de la línea de comandos.
* **✅ Fácil de Usar:** Solicita al usuario la moneda de origen, la moneda de destino y la cantidad a convertir.
* **🛡️ Manejo de Errores:** Incluye manejo de excepciones robusto para errores de red, formato JSON y entradas de usuario inválidas.
* **📋 Lista de Monedas Soportadas:** Muestra una lista clara y organizada de las monedas disponibles para la conversión.

---

## 🛠️ Tecnologías Utilizadas

* ☕ **Java Development Kit (JDK) 17:** El entorno de desarrollo y ejecución principal.
* 📦 **Maven:** Herramienta para la gestión de dependencias y la construcción del proyecto.
* 📝 **Gson 2.10.1:** Librería de Google para la serialización y deserialización de objetos Java a/desde JSON.
* 🌐 **Java 11+ HttpClient:** API nativa de Java para realizar solicitudes HTTP.
* 🌐 **ExchangeRate-API.com:** Servicio externo para obtener tasas de cambio de divisas.

---

## 🚀 Guía de Inicio Rápido

Sigue estos pasos para poner en marcha el proyecto en tu máquina local.

### 📌 Requisitos Previos

Asegúrate de tener instalado lo siguiente:

* **JDK 17** o una versión superior.
* **Maven** (generalmente incluido con los IDEs modernos como IntelliJ IDEA).
* Un **IDE de Java** (IntelliJ IDEA, Eclipse, VS Code con extensiones Java, etc.).

### 1️⃣ Obtener una Clave API

Este proyecto utiliza `ExchangeRate-API.com` para obtener las tasas de cambio. Necesitarás una clave API gratuita.

1. **Visita:** `https://www.exchangerate-api.com/s/free`
2. **Regístrate** para obtener tu clave API gratuita.
3. **Copia** tu clave API.

### 2️⃣ Configuración del Proyecto

1. **Clona el repositorio** (si ya lo tienes en tu máquina local, omite este paso):
   **Bash**

   ```
   git clone https://github.com/tu_usuario/Conversor-monedas.git
   cd Conversor-monedas
   ```

   *(Nota: Reemplaza `https://github.com/tu_usuario/Conversor-monedas.git` con la URL real de tu repositorio).*
2. **Abre el proyecto en tu IDE:**

   * Selecciona "Open" y navega hasta la carpeta `Conversor-monedas`.
   * Tu IDE debería detectar automáticamente que es un proyecto Maven e importar las dependencias.
3. **Añade la dependencia Gson** (si aún no está):

   * Abre el archivo `pom.xml` en la raíz de tu proyecto.
   * Asegúrate de que la siguiente sección de dependencia esté presente:

   **XML**

   ```
   <dependencies>
       <dependency>
           <groupId>com.google.code.gson</groupId>
           <artifactId>gson</artifactId>
           <version>2.10.1</version>
       </dependency>
   </dependencies>
   ```

   * Si realizaste cambios, recarga el proyecto Maven en tu IDE para descargar la librería.
4. **Inserta tu Clave API en el código:**

   * Abre el archivo `ConversorMonedas.java` (ubicado en `src/main/java/ConversorMonedas.java`).
   * Busca la línea y reemplaza las comillas vacías con tu clave API:

   **Java**

   ```
   private static final String API_KEY = "TU_CLAVE_API_AQUI";
   ```

   *(Importante: Si estás usando un entorno como Alura, la clave API podría ser proporcionada automáticamente por el entorno. Si ese es el caso, puedes dejar la cadena vacía).*

### 3️⃣ Ejecutar el Proyecto

1. En tu IDE, navega a la clase `ConversorMonedas.java`.
2. Haz clic derecho en el archivo o dentro del código y selecciona  **"Run 'ConversorMonedas.main()'"** .
3. El programa se ejecutará en la consola de tu IDE. Sigue las instrucciones para ingresar las monedas y la cantidad a convertir.

---

## 💡 Posibles Mejoras Futuras

* **Interfaz Gráfica de Usuario (GUI):** Implementar una interfaz gráfica usando **JavaFX** o  **Swing** .
* **Historial de Conversiones:** Guardar un registro de las conversiones realizadas en un archivo o base de datos.
* **Validación de Entrada Mejorada:** Validar la entrada del usuario de forma más robusta (ej. con expresiones regulares).
* **Manejo de Errores Más Detallado:** Proporcionar mensajes de error más específicos para diferentes escenarios de fallo de la API.

---

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si tienes ideas para mejorar este conversor, no dudes en abrir un **`issue`** o enviar un  **`pull request`** .

## 📄 Licencia

Este proyecto está bajo la  **Licencia MIT** . Consulta el archivo `LICENSE` para más detalles.
