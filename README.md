# ImageViewer

## Descripción

**ImageViewer** es una aplicación de escritorio desarrollada en Java que permite visualizar imágenes locales y navegar entre ellas mediante controles *Prev* y *Next*, así como
interactuar con las imágenes mediante arrastre horizontal. El proyecto está diseñado siguiendo principios de Ingeniería del Software, y empleando el patrón Model-View-Presenter.

El objetivo principal del proyecto es servir como ejemplo académico y práctico de una aplicación Swing con la arquitectura MVP, que sirve para crear interfaces de usuario que 
separan las responsabilidades en tres componentes: el Modelo (datos y lógica de negocio), la Vista (interfaz pasiva que muestra datos y captura eventos) y el Presentador (el 
intermediario que maneja la comunicación, recupera datos del Modelo y actualiza la Vista).

---

## Arquitectura

El proyecto sigue una arquitectura basada en capas, con una clara separación de responsabilidades:

* **application** → Implementación concreta de la aplicación (Swing, acceso a archivos, punto de entrada)
* **architecture** → Núcleo abstracto e independiente de frameworks
* **test** → Pruebas unitarias

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

## Capa `application`

### `Main`

Punto de entrada de la aplicación. Se encarga de inicializar los componentes principales y arrancar la interfaz gráfica.

### `Desktop`

Ventana principal de la aplicación (`JFrame`). Contiene y organiza los componentes Swing, como el visor de imágenes y los botones de control.

### `SwingImageDisplay`

Implementación concreta de la interfaz `ImageDisplay` usando Swing (`JPanel`).

Responsabilidades:

* Renderizar la imagen actual
* Gestionar eventos de ratón (arrastre y liberación)
* Comunicar interacciones al `Presenter`

### `FileImageStore`

Implementación de `ImageStore` que carga imágenes desde el sistema de archivos.

---

## Capa `architecture`

### control

Implementa el **Command Pattern** para desacoplar la UI de las acciones:

* `Command` → Interfaz funcional base
* `NextCommand` → Avanza a la siguiente imagen
* `PrevCommand` → Retrocede a la imagen anterior

---

### model

Contiene el núcleo del dominio:

* `Image` → Abstracción de una imagen (bitmap)
* `Canvas` → Utilidad para calcular escalado y ajuste de imágenes al área de dibujo
* `ImageProvider` → Proveedor secuencial de imágenes

---

### store

* `ImageStore` → Abstracción para obtener imágenes desde cualquier fuente (archivos, red, base de datos, etc.)

---

### ui

Define los contratos de la interfaz de usuario:

* `ImageDisplay` → Vista abstracta independiente de Swing
* `ImagePresenter` → Coordinador entre modelo y vista

Esta capa **no depende de Swing** ni de ninguna tecnología concreta.

---

## Tests

### `CanvasTest`

Pruebas unitarias para verificar el correcto cálculo de escalado y ajuste de imágenes en la clase `Canvas`.

---

## Características principales

* Visualización de imágenes locales
* Navegación *Next / Prev*
* Arrastre horizontal de imágenes
* Arquitectura desacoplada y extensible
* Uso correcto del ciclo de pintado en Swing (`paintComponent`)
* Preparado para añadir nuevas fuentes de imágenes o nuevas vistas

---

## Ejecución

1. Clonar el repositorio
2. Abrir el proyecto en IntelliJ IDEA (o IDE compatible)
3. Ejecutar la clase `Main`

---

## Principios, técnicas y patrones aplicados

* Single Responsibility Principle (SRP)
* Command Pattern
* MVP (Model–View–Presenter)
* TDD


