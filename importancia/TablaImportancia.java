
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TablaImportancia extends JFrame {

    private final Color azul = new Color(0, 87, 194);
    private final Color naranja = new Color(255, 129, 46);
    private final Color rojo = new Color(211, 47, 47);
    private final Color gris = new Color(238, 238, 238);

    public TablaImportancia() {
        setTitle("Tabla de importancia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 0);

        // Primera fila: título general
        agregarCelda(panel, gbc, "", 0, 0, 1, 1,
                gris, true);
        agregarCelda(panel, gbc, "Importancia", 1, 0, 3, 1,
                gris, true);

        // Segunda fila: encabezados
        agregarCelda(panel, gbc, "Función", 0, 1, 1, 1,
                new Color(204, 204, 204), true);
        agregarCelda(panel, gbc, "Primaria", 1, 1, 1, 1,
                gris, false);
        agregarCelda(panel, gbc, "Secundaria", 2, 1, 1, 1,
                gris, false);
        agregarCelda(panel, gbc, "Terciaria", 3, 1, 1, 1,
                gris, false);

        // Filas de datos
        agregarFila(panel, gbc, "Normal", azul, 2);
        agregarFila(panel, gbc, "Alternativa", naranja, 3);
        agregarFila(panel, gbc, "Peligrosa", rojo, 4);

        add(panel);
        setSize(760, 280);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarCelda(
            JPanel panel,
            GridBagConstraints gbc,
            String texto,
            int x, int y,
            int ancho, int alto,
            Color fondo,
            boolean negrita) {

        JLabel etiqueta = new JLabel(texto, SwingConstants.CENTER);
        etiqueta.setOpaque(true);
        etiqueta.setBackground(fondo);
        etiqueta.setBorder(new LineBorder(
                new Color(204, 204, 204)));

        if (negrita) {
            etiqueta.setFont(new Font(
                    "Arial", Font.BOLD, 14));
        } else {
            etiqueta.setFont(new Font(
                    "Arial", Font.PLAIN, 14));
        }

        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = ancho;
        gbc.gridheight = alto;
        gbc.weightx = ancho;
        gbc.weighty = 1;

        panel.add(etiqueta, gbc);
    }

    private void agregarFila(
            JPanel panel,
            GridBagConstraints gbc,
            String funcion,
            Color color,
            int fila) {

        agregarCelda(panel, gbc, funcion, 0, fila,
                1, 1, Color.WHITE, false);

        // Primaria: botón relleno
        agregarBoton(panel, gbc, color, fila, 1, true);

        // Secundaria: botón con borde
        agregarBoton(panel, gbc, color, fila, 2, false);

        // Terciaria: enlace sin borde
        agregarEnlace(panel, gbc, color, fila, 3);
    }

    private void agregarBoton(
            JPanel panel,
            GridBagConstraints gbc,
            Color color,
            int fila, int columna,
            boolean relleno) {

        JPanel celda = new JPanel(
                new GridBagLayout());
        celda.setBackground(Color.WHITE);
        celda.setBorder(new LineBorder(
                new Color(204, 204, 204)));

        JButton boton = new JButton("Mas información");
        boton.setFont(new Font("Arial", Font.PLAIN, 16));
        boton.setFocusPainted(false);
        boton.setBorder(new LineBorder(color));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        if (relleno) {
            boton.setBackground(color);
            boton.setForeground(Color.WHITE);
            boton.setOpaque(true);
        } else {
            boton.setBackground(Color.WHITE);
            boton.setForeground(color);
            boton.setOpaque(true);
        }

        boton.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Información: " + obtenerFuncion(fila),
                        "Más información",
                        JOptionPane.INFORMATION_MESSAGE));

        celda.add(boton);

        gbc.gridx = columna;
        gbc.gridy = fila;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;

        panel.add(celda, gbc);
    }

    private void agregarEnlace(
            JPanel panel,
            GridBagConstraints gbc,
            Color color,
            int fila, int columna) {

        JPanel celda = new JPanel(
                new GridBagLayout());
        celda.setBackground(Color.WHITE);
        celda.setBorder(new LineBorder(
                new Color(204, 204, 204)));

        JButton enlace = new JButton("Mas información");
        enlace.setFont(new Font("Arial", Font.PLAIN, 16));
        enlace.setForeground(color);
        enlace.setBorderPainted(false);
        enlace.setContentAreaFilled(false);
        enlace.setFocusPainted(false);
        enlace.setCursor(new Cursor(Cursor.HAND_CURSOR));

        enlace.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this,
                        "Información: " + obtenerFuncion(fila),
                        "Más información",
                        JOptionPane.INFORMATION_MESSAGE));

        celda.add(enlace);

        gbc.gridx = columna;
        gbc.gridy = fila;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;

        panel.add(celda, gbc);
    }

    private String obtenerFuncion(int fila) {
        switch (fila) {
            case 2:
                return "Normal";
            case 3:
                return "Alternativa";
            case 4:
                return "Peligrosa";
            default:
                return "General";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                TablaImportancia::new);
    }
}
