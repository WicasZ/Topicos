package Bloc;

import java.awt.Font;
import java.io.InputStream;

public class Fonts {
    private Font font = null;

    public Fonts() {
        String fontName = "Montserrat.ttf";
        try {
            // Se carga la fuente
            InputStream is = getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            // Si existe un error se carga fuente por defecto ARIAL
            System.err.println(fontName + " No se cargo la fuente");
            font = new Font("Arial", Font.PLAIN, 12);
        }
    }

    public Font FontM(int style, float size) {
        Font tfont = font.deriveFont(style, size);
        return tfont;
    }
}
