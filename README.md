# DIW — Desarrollo de Interfaces Web

![Ciclo](https://img.shields.io/badge/ciclo-2%C2%BA%20DAW-blue)
![Módulo](https://img.shields.io/badge/m%C3%B3dulo-DIW-purple)
![Metodología](https://img.shields.io/badge/metodolog%C3%ADa-BEM-yellowgreen)
![Preprocesador](https://img.shields.io/badge/preprocesador-Sass-CC6699)

Repositorio de ejercicios del módulo **Desarrollo de Interfaces Web (DIW)** de 2.º DAW, centrados en la metodología **BEM** para nombrar clases y en el preprocesador **Sass**.

## 🗂️ Estructura

```text
DIW/
├── BEM/
│   ├── index.html · index2.html · index-sass.html   # Versiones de la interfaz
│   ├── scss/
│   │   ├── _variables.scss · _base.scss             # Variables y estilos base
│   │   ├── _c-boton.scss · _c-panel.scss            # Componentes: botón y panel
│   │   ├── _l-paneles.scss                          # Layout de paneles
│   │   └── main.scss                                # Entrada → css/main.css
│   ├── css/main.css                                 # CSS generado
│   ├── paneles/                                     # CSS suelto por componente
│   └── package.json
├── ejemplo-bem/
│   ├── index.html
│   ├── guia.md                                      # Guía explicativa del ejemplo
│   ├── scss/
│   │   ├── _system-tokens.scss                      # Parcial de tokens (no compila)
│   │   ├── system.scss                              # Publica tokens en :root
│   │   ├── c-boton.scss · c-panel.scss              # Componentes
│   │   ├── l-extremo.scss · l-stack.scss            # Layouts
│   │   └── demo.scss                                # Estilos de la página
│   ├── css/                                         # CSS compilado por componente
│   └── package.json
└── sass-colores/
    └── scss/                                        # Ejercicios de colores con Sass
```

## 📦 Contenido

| Carpeta | Qué contiene |
| ------- | ------------ |
| **`BEM/`** | Interfaz de **paneles y botones** con BEM: una versión clásica en CSS puro y otra versionada con Sass, donde cada parcial compila al CSS principal |
| **`ejemplo-bem/`** | Interfaz con **tres paneles** (Normal, Alternativos, Peligrosos) y **nueve botones**. Los tokens del sistema se publican una sola vez en `:root` desde `system.css` y se consumen con `var()`; cada componente compila a su propio `css/*.css` |
| **`sass-colores/`** | Ejercicios de colores y gamas con Sass |

## 🔨 Cómo compilar

Las carpetas con `package.json` usan el compilador de Sass:

```bash
npm install          # instala sass (solo la primera vez)
npm run build:sass   # compila scss/ → css/  (equivale a: sass scss:css)
```

## 🌿 Ramas del repositorio

| Rama | Descripción |
| ---- | ----------- |
| `main` | Proyecto principal con ejemplos BEM + Sass |
| `importancia` | Ejercicios del boletín de importancia en CSS |
| `BEM_SASS_IMPORTANCIA_BOTONES` | Variación del sistema con **niveles de importancia en los botones**: variables de sistema con listas y bucles `@for`, variables públicas `--mlt-sys-*`, 9 botones (3 funciones × 3 importancias) y 3 paneles independientes |
| `sass-colores` | Ejercicio específico de colores con Sass |

---

✏️ Proyecto académico de 2.º DAW — módulo **DIW**
