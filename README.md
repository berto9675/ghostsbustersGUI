# ghostsbustersGUI
# Ghostbusters en Asturias - GUI Version
## Descripción
Este proyecto es una evolución de *Ghostbusters en Asturias*, ahora con una interfaz gráfica desarrollada en **Java Swing y AWT**. La aplicación permite capturar, visualizar y gestionar fantasmas atrapados en diferentes lugares emblemáticos de Asturias, manteniendo la esencia del proyecto original pero con una experiencia de usuario mejorada.
El objetivo principal es proporcionar una herramienta interactiva y amigable para los usuarios interesados en la caza de fantasmas, brindando una representación visual clara de sus capturas y permitiendo gestionar su colección con facilidad.
## Características principales
- **Interfaz gráfica con Java Swing y AWT** para una gestión más intuitiva.
- **Los datos no se guardan al salir de la aplicación**, lo que permite iniciar una nueva cacería en cada ejecución.
- **Diseño modular y escalable**, permitiendo futuras mejoras y extensiones.
## Modelo MVP
El proyecto se ha desarrollado siguiendo un modelo MVP, estructurado de la siguiente manera:
- **Pantalla de inicio** para acceder al menú y navegar entre las opciones.
- **Capturar Fantasmas** → Permite registrar fantasmas atrapados proporcionando información relevante como el nombre, tipo y ubicación.
- **Visualizar la Lista de Fantasmas Capturados** → Permite consultar la lista completa de capturas, mostrando detalles clave en una tabla interactiva.
- **Liberar Fantasmas Inofensivos** → Opción para eliminar fantasmas que no representen una amenaza, brindando un control sobre las capturas.
- **Salir del programa con confirmación** → Para evitar cierres accidentales.
## Tecnologías utilizadas
## Tecnologías utilizadas
- ![Java](https://img.shields.io/badge/Java-orange?style=flat&logo=java) **Lenguaje:** Java 17
- ![JUnit](https://img.shields.io/badge/JUnit-5-green?style=flat&logo=JUnit) **Testing:** JUnit (mínimo 70% de cobertura)
- ![Mockito](https://img.shields.io/badge/Mockito-orange?style=flat) **Testing:** Mockito
- ![Git](https://img.shields.io/badge/Git-red?style=flat&logo=git) **Control de versiones:** Git y GitHub
- ![Jira](https://img.shields.io/badge/Jira-blue?style=flat&logo=jira) **Herramientas adicionales:** Jira para la gestión de tareas
- ![Maven](https://img.shields.io/badge/Maven-black?style=flat&logo=apache-maven) **Gestión de dependencias:** Maven
- ![Swing](https://img.shields.io/badge/Java%20Swing-AWT-lightgray?style=flat) **Interfaz gráfica:** Java Swing y AWT
- ![Draw.io](https://img.shields.io/badge/Draw.io-UML%20Diagrams-brightgreen?style=flat) **Diagramas UML:** Draw.io
## Instalación y ejecución
Para instalar y ejecutar la aplicación, sigue los siguientes pasos:
1. **Realiza un fork de este repositorio desde GitHub**.
2. **Clona el repositorio forkeado en tu equipo:**
   ```bash
   git clone https://github.com/tu_usuario/ghostbusters-asturias-gui.git
3. **Accede al directorio del proyecto:**
   ```bash
   cd ghostbusters-asturias-gui
4. **Compila el proyecto con Maven:**
   ```bash
   mvn clean install
5. **Ejecuta la aplicación:**
   ```bash
   java -jar target/ghostbusters-asturias-gui.jar
   
---
# Uso de la aplicación
La aplicación permite a los usuarios gestionar su caza de fantasmas de manera visual e interactiva. A continuación, se explica cómo funciona cada opción del menú:
## Pantalla de inicio
Desde aquí, los usuarios pueden acceder a las diferentes funciones del programa.
## Capturar Fantasmas
- Ingresar detalles del fantasma (nombre, tipo, ubicación).
- Confirmar la captura.
## Visualizar Lista de Fantasmas Capturados
- Ver tabla con los fantasmas capturados.
- Ordenar y filtrar la lista según distintos criterios.
## Liberar Fantasmas Inofensivos
- Seleccionar fantasmas que no sean peligrosos.
- Confirmar la liberación.
## Salir del programa
- Se solicita confirmación para evitar cierres accidentales.
## Capturas de pantalla
[demo](/src%20read.me/ghostbusterdemo.mp4)
---
# Historias de Usuario
A continuación, se presentan las historias de usuario definidas para este proyecto:
### 1️⃣ Captura de Fantasmas
**Como** usuario cazador de fantasmas, **quiero** registrar los fantasmas capturados con su información relevante, **para** llevar un control de mis capturas.
### 2️⃣ Visualización de la Lista de Fantasmas Capturados
**Como** usuario cazador de fantasmas, **quiero** consultar una lista de los fantasmas que he capturado, **para** revisar su información y organizar mis registros.
### 3️⃣ Liberación de Fantasmas Inofensivos
**Como** usuario cazador de fantasmas, **quiero** tener la opción de liberar fantasmas inofensivos, **para** mantener un equilibrio entre el mundo humano y el paranormal.
### 4️⃣ Confirmación al salir del programa
**Como** usuario cazador de fantasmas, **quiero** recibir una confirmación antes de salir de la aplicación, **para** evitar cerrar la sesión accidentalmente.
---
# Gestión del Proyecto
## Enlace a Jira
Puedes acceder al tablero de gestión del proyecto en Jira en el siguiente enlace:  
[Enlace a Jira](https://celiagarridoherrera.atlassian.net/jira/software/projects/GB/boards/36?atlOrigin=eyJpIjoiMGQ1ZDY1Yjg3MWUwNGExMDhhZGUxOGRiMjFiNDQ3NjMiLCJwIjoiaiJ9) 
## Diagrama UML
A continuación se presenta el diagrama UML del sistema:  
[diagrama UML](/src%20read.me/GhostbustersGUI.drawio.svg)
---
# Posibles mejoras futuras
- **Persistencia de datos**: Actualmente, los datos no se guardan al salir. Se puede agregar una base de datos o archivos de almacenamiento.
- **Autenticación de usuarios**: Implementar un sistema de inicio de sesión para guardar progresos individuales.
- **Mayor interactividad en la interfaz**: Uso de animaciones o mejoras visuales para la experiencia de usuario.
---
# Pruebas
Aunque en esta versión no se han implementado pruebas con TDD, el código base se ha desarrollado sobre una versión previa que sí incluyó pruebas unitarias con JUnit y pruebas unitarias.
[cobertura de test](/src%20read.me/Test_GUI.PNG)
---
# Autores
Este proyecto ha sido desarrollado por el equipo **JavaNormal Activity**:
- **Celia** (Developer)
- **Erika** (Developer)
- **Juan** (Developer)
- **Alberto** (Support)
---
# 📜 Licencia
Este proyecto se distribuye bajo la licencia **MIT**. Puedes utilizarlo y modificarlo libremente bajo los términos de esta licencia.
---
✨ **¡Esperamos que disfrutes cazando fantasmas en Asturias!** 👻🔦