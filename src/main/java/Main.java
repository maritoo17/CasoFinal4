import EditorTexto.CreacionYAlmacenamiento;
import EditorTexto.NavegacionYListado;
import PalabrasYGestion.BuscadorDePalabras;
import PalabrasYGestion.AgendaDeContactos;
import InterfazGráfica.MultiplicidadDeVentanas;
import InterfazGráfica.SeguimientoDelRaton;
import InterfazGráfica.BarraDeDesplazamiento;
import ValidacionEmailYDiseño.ValidadorDeEmail;
import ValidacionEmailYDiseño.HerramientaDeDibujo;
import ComparadorYContador.AnalisisDeTexto;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String[] options = {
                "CreacionYAlmacenamiento",
                "NavegacionYListado",
                "BuscadorDePalabras",
                "AgendaDeContactos",
                "MultiplicidadDeVentanas",
                "SeguimientoDelRaton",
                "BarraDeDesplazamiento",
                "ValidadorDeEmail",
                "HerramientaDeDibujo",
                "AnalisisDeTexto"
        };

        String input = (String) JOptionPane.showInputDialog(null, "Elige una opción",
                "Menú", JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);

        switch (input) {
            case "CreacionYAlmacenamiento":
                CreacionYAlmacenamiento creacionYAlmacenamiento = new CreacionYAlmacenamiento();
                creacionYAlmacenamiento.setVisible(true);
                break;
            case "NavegacionYListado":
                NavegacionYListado navegacionYListado = new NavegacionYListado();
                navegacionYListado.setVisible(true);
                break;
            case "BuscadorDePalabras":
                BuscadorDePalabras buscadorDePalabras = new BuscadorDePalabras();
                buscadorDePalabras.setVisible(true);
                break;
            case "AgendaDeContactos":
                AgendaDeContactos agendaDeContactos = new AgendaDeContactos();
                agendaDeContactos.setVisible(true);
                break;
            case "MultiplicidadDeVentanas":
                MultiplicidadDeVentanas multiplicidadDeVentanas = new MultiplicidadDeVentanas();
                multiplicidadDeVentanas.setVisible(true);
                break;
            case "SeguimientoDelRaton":
                SeguimientoDelRaton seguimientoDelRaton = new SeguimientoDelRaton();
                seguimientoDelRaton.setVisible(true);
                break;
            case "BarraDeDesplazamiento":
                BarraDeDesplazamiento barraDeDesplazamiento = new BarraDeDesplazamiento();
                barraDeDesplazamiento.setVisible(true);
                break;
            case "ValidadorDeEmail":
                ValidadorDeEmail validadorDeEmail = new ValidadorDeEmail();
                validadorDeEmail.setVisible(true);
                break;
            case "HerramientaDeDibujo":
                HerramientaDeDibujo herramientaDeDibujo = new HerramientaDeDibujo();
                herramientaDeDibujo.setVisible(true);
                break;
            case "AnalisisDeTexto":
                AnalisisDeTexto analisisDeTexto = new AnalisisDeTexto();
                analisisDeTexto.setVisible(true);
                break;
        }
    }
}