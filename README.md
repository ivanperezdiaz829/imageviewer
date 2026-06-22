# **ImageViewer**
## Visualizador de imágenes locales con navegación y arrastre mediante arquitectura MVP

![Java](https://img.shields.io/badge/Java-17-orange?logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-Desktop%20UI-blue)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-red?logo=apachemaven&logoColor=white)
![Arquitectura](https://img.shields.io/badge/Arquitectura-MVP-purple)
![TDD](https://img.shields.io/badge/Testing-TDD-yellow)
![Status](https://img.shields.io/badge/Status-Completado-success)

---

## ¿En qué consiste?

**ImageViewer** es una aplicación de escritorio desarrollada en **Java** que permite **visualizar imágenes locales** y navegar entre ellas mediante controles *Prev* y *Next*, así como interactuar con ellas mediante **arrastre horizontal**. El proyecto sigue principios de Ingeniería del Software empleando el patrón **Model-View-Presenter (MVP)**.

El objetivo principal es servir como ejemplo académico y práctico de una aplicación Swing con arquitectura MVP, separando las responsabilidades en tres componentes: el **Modelo** (datos y lógica de negocio), la **Vista** (interfaz pasiva que muestra datos y captura eventos) y el **Presentador** (intermediario que maneja la comunicación entre ambos).

### Características Principales

* **Navegación intuitiva:** Controles *Prev* y *Next* para recorrer el álbum de imágenes.
* **Interacción gestual:** Arrastre horizontal de imágenes con el ratón.
* **Arquitectura desacoplada:** La Vista no conoce la lógica; el Presentador orquesta todo.
* **Extensible:** Preparado para nuevas fuentes de imágenes (red, base de datos) o nuevas vistas sin modificar el núcleo.
* **Testado con TDD:** Pruebas unitarias sobre la lógica de escalado y ajuste de imágenes.

---

## Stack Tecnológico

El proyecto ha sido desarrollado en **Java** utilizando las siguientes tecnologías:

* **Java + Swing:** Lógica de negocio e interfaz gráfica de escritorio (`JFrame`, `JPanel`, `paintComponent`).
* **Maven:** Gestión de dependencias y construcción del proyecto.
* **Command Pattern:** Desacoplamiento entre los botones de control y las acciones de navegación.
* **MVP (Model-View-Presenter):** Separación clara de responsabilidades entre modelo, vista y presentador.
* **TDD:** Desarrollo guiado por pruebas unitarias sobre la clase `Canvas`.

---

## Arquitectura

El proyecto sigue una arquitectura basada en capas con clara separación de responsabilidades:

| Capa | Descripción |
| :--- | :--- |
| **application** | Implementación concreta: UI Swing, acceso a archivos y punto de entrada |
| **architecture** | Núcleo abstracto e independiente de frameworks |
| **test** | Pruebas unitarias con TDD |

### Principios, técnicas y patrones aplicados

| Patrón / Principio | Uso en el proyecto |
| :--- | :--- |
| **MVP** | Separa modelo, vista pasiva y presentador coordinador |
| **Command Pattern** | Desacopla los botones *Next* / *Prev* de la lógica de navegación |
| **SRP** | Cada clase tiene una única responsabilidad bien definida |
| **TDD** | `CanvasTest` verifica el escalado y ajuste de imágenes antes de implementar |

---

## Estructura del proyecto

```
software.ulpgc.imageviewer
│
├── application
│   └── gui
│   |    ├── Desktop
│   |    ├── Main
│   |    ├── SwingImageDisplay
│   └── FileImageStore
│
├── architecture
│   ├── control
│   │   ├── Command
│   │   ├── NextCommand
│   │   └── PrevCommand
│   │
│   ├── model
│   │   ├── Canvas
│   │   ├── Image
│   │   └── ImageProvider
│   │
│   ├── store
│   │   └── ImageStore
│   │
│   └── ui
│       ├── ImageDisplay
│       └── ImagePresenter
│
├── resources
│
└── test
    └── CanvasTest
```

---

## Instalación y Uso

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/ivanperezdiaz829/imageviewer
   cd imageviewer
   ```

2. **Compilar con Maven:**
   ```bash
   mvn clean install
   ```

3. **Ejecutar la aplicación:**
   ```bash
   # Abrir el proyecto en IntelliJ IDEA (o IDE compatible)
   # Ejecutar la clase application.gui.Main
   ```

4. **Ejecutar los tests:**
   ```bash
   mvn test
   ```

---

## Autoría

Este proyecto ha sido desarrollado como parte de una práctica de Ingeniería del Software 2 con arquitectura MVP por:

* **Iván Pérez Díaz** - [GitHub](https://github.com/ivanperezdiaz829)

---

*Este software es un proyecto académico orientado a la práctica del patrón MVP, TDD y principios de diseño de software en Java.*