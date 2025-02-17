<<<<<<< HEAD
# ghostsbustersGUI
# GhostBusters con GUI

## Índice /// corregir en funcion de los cambios
1. [Descripción](#descripción)
2. [Equipo de desarrollo](#equipo-de-desarrollo)
3. [Tecnologías utilizadas](#tecnologías-utilizadas)
4. [Funcionalidades principales](#funcionalidades-principales)
5. [Alcance del MVP](#alcance-del-mvp)
6. [Estructura del proyecto](#estructura-del-proyecto)
7. [Instalación y ejecución](#instalación-y-ejecución)
8. [Diagrama de clases](#diagrama-de-clases)
9. [Cobertura de tests](#cobertura-de-tests)

## Descripción
**Ghostbusters en Asturias** es una aplicación en Java que permite a los usuarios capturar, visualizar y gestionar fantasmas en diferentes ubicaciones de Asturias. Desarrollado con el patrón MVC y aplicando TDD, el proyecto se ejecuta en consola y cuenta con una cobertura mínima del 70% en pruebas.

## Equipo de desarrollo
   **JavaNormal Activity** 👻
- [Celia](https://github.com/celiagarridoherrera)
- [Erika](https://github.com/erikamc99)
- [Alberto](https://github.com/berto9675)
- [Juan](https://github.com/juancastro000)

## Tecnologías utilizadas // a corregir segun avance el proyecto
- ![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=java&logoColor=white) **Lenguaje:** Java
- ![JUnit](https://img.shields.io/badge/JUnit-25A162?style=flat-square&logo=junit5&logoColor=white) **Testing:** JUnit (mínimo 70% de cobertura)
- ![Mockito](https://img.shields.io/badge/Mockito-FF8000?style=flat-square&logo=mockito&logoColor=white) **Testing:** Mockito
- ![Git](https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white) **Control de versiones:** Git y GitHub
- ![Jira](https://img.shields.io/badge/Jira-0052CC?style=flat-square&logo=jira&logoColor=white) **Herramientas adicionales:** Jira para la gestión de tareas


## Funcionalidades principales // a corregir segun avance el proyecto
1. **Capturar fantasmas**.
2. **Visualizar la lista de fantasmas atrapados**.
3. **Liberar fantasmas inofensivos**.
4. **Filtrar fantasmas** según su clase.
5. **Ver fantasmas capturados en un mes específico**.

## 📌Historias de Usuario👨‍💻
🧲 **1. Capturar Fantasmas:**  
  **COMO** usuario, **QUIERO** capturar un nuevo fantasma **PARA** expandir mi colección y proteger los lugares emblemáticos de Asturias.  
🕊️ **3. Liberar Fantasmas:**  
  **COMO** usuario, **QUIERO** liberar fantasmas menos peligrosos o inofensivos **PARA** hacer espacio en mi contenedor ectoplásmico.  
🔎 **4. Filtrar Fantasmas por Clase:**  
   **COMO** usuario, **QUIERO** filtrar los fantasmas por clase **PARA** priorizar cuáles estudiar o utilizar en mis investigaciones.  
📅 **5. Ver Fantasmas Capturados en un Mes Específico:**  
   **COMO** usuario, **QUIERO** obtener un listado de los fantasmas atrapados en un mes **PARA** estudiar patrones de actividad paranormal en Asturias.  
🚪 **6. Salir del Programa:**  
   **COMO** usuario, **QUIERO** salir del juego **PARA** guardar mi progreso y continuar en otra ocasión.  

## Alcance del MVP // a completar segun avance el proyecto
El MVP incluye:


## Estructura del proyecto // a corregir segun avance el proyecto
```
📦 ghostbusters
 ┣ 📂 assets
 ┣ 📂 src
 ┃ ┣ 📂 main
 ┃ ┃ ┣ 📂 model
 ┃ ┃ ┣ 📂 view
 ┃ ┃ ┣ 📂 controller
 ┃ ┃ ┣ 📂 utils
 ┃ ┃ ┗ App.java
 ┃ ┣ 📂 test
 ┃ ┗ 📜 README.md
```

## Instalación y ejecución // a corregir segun avance el proyecto
1. Clonar este repositorio:
   ```bash
   git clone https://github.com/erikamc99/Ghostbusters.git
   ```
2. Abrir el proyecto en tu IDE de preferencia.
3. Compilar y ejecutar `App.java`.

### Diagrama de clases
[link al diagrama de clases](https://drive.google.com/file/d/1gZmb3mFoyc2-mIS0MnKCAH4v-LXEtsOC/view?usp=sharing)
![Diagrama de clases]()

### Cobertura de tests
![Tests]()

---
## **Comentarios y Contribuciones**
¡Tus comentarios son bienvenidos! No dudes en abrir issues o enviar pull requests para sugerir mejoras o reportar problemas.
---
## **Licencia**
Este proyecto está bajo la Licencia de [Berto9675](https://github.com/berto9675), [juancastro000](https://github.com/juancastro000), [celiagarridoherrera](https://github.com/celiagarridoherrera) y de [erikamc99](https://github.com/erikamc99)
---
¡Caza fantasmas y mantenos libre de espectros! 👻⚡
=======
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

## Capturas de pantalla *(pendiente de agregar cuando haya avances)*

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
*(Imagen diagrama)*

---

# Posibles mejoras futuras

- **Persistencia de datos**: Actualmente, los datos no se guardan al salir. Se puede agregar una base de datos o archivos de almacenamiento.
- **Autenticación de usuarios**: Implementar un sistema de inicio de sesión para guardar progresos individuales.
- **Mayor interactividad en la interfaz**: Uso de animaciones o mejoras visuales para la experiencia de usuario.

---

# Pruebas

Aunque en esta versión no se han implementado pruebas con TDD, el código base se ha desarrollado sobre una versión previa que sí incluyó pruebas unitarias con JUnit.

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

   
>>>>>>> main
