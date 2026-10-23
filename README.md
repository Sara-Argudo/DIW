# DIW

Repositorio de ejercicios del módulo **Desarrollo de Interfaces Web (DIW)** de 2º DAW,
centrados en la metodología **CSS/BEM** y el preprocesador **Sass**.

## Estructura

```
DIW/
├── BEM/
│   ├── index.html, index2.html, index-sass.html   (versiones de la interfaz)
│   ├── scss/
│   │   ├── _variables.scss, _base.scss            (variables y estilos base)
│   │   ├── _c-boton.scss, _c-panel.scss           (componentes: botón y panel)
│   │   ├── _l-paneles.scss                        (layout de paneles)
│   │   └── main.scss                              (punto de entrada → css/main.css)
│   ├── css/main.css (+ .map)                      (CSS generado)
│   ├── paneles/                                   (componentes sueltos: c-boton.css, c-panel.css, l-extremo.css...)
│   └── package.json
├── ejemplo-bem/
│   ├── index.html
│   ├── guia.md                                    (guía explicativa del ejemplo)
│   ├── scss/
│   │   ├── _system-tokens.scss                    (parciales: variables de sistema, no se compila)
│   │   ├── system.scss                            (publica tokens en :root → css/system.css)
│   │   ├── c-boton.scss, c-panel.scss             (componentes)
│   │   ├── l-extremo.scss, l-stack.scss           (layouts: dos extremos, apilado)
│   │   └── demo.scss                              (estilos de la página)
│   ├── css/                                       (CSS compilado por componente)
│   └── package.json
└── sass-colores/
    └── scss/
        ├── styles.css, styles2.css                (ejercicios de colores/gamas con Sass)
        └── *.css.map
```

## Contenido

- **`BEM/`** — interfaz de **paneles y botones** con metodología BEM: dos versiones,
  la clásica en CSS puro (`styles.css`) y la versionada con Sass, donde cada parcial
  compila al CSS principal.
- **`ejemplo-bem/`** — interfaz con **tres paneles** (Normal, Alternativos, Peligrosos)
  y **nueve botones**. Los tokens del sistema se publican una sola vez en `:root`
  desde `system.css` y se consumen con `var()`. Cada componente compila por separado
  a su propio `css/*.css`. Ver `guia.md` para más detalle.
- **`sass-colores/`** — ejercicios de colores con Sass (stylesheet principal + maps).

## Cómo compilar

Cada carpeta con `package.json` usa el compilador `sass`:

```bash
npm install        # instala sass (solo la primera vez)
npm run build:sass # compila scss/ → css/  (equivale a: sass scss:css)
```

## Otras ramas

- `BEM_SASS_IMPORTANCIA_BOTONES` / `importancia` — variación del sistema con
  **niveles de importancia en los botones** (`scss/components/`, `_variables-sistema.scss`).
- `sass-colores` — rama específica del ejercicio de colores.
