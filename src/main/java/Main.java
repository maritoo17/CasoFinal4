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
            SwingUtilities.invokeLater(Main::mostrarMenu);
        }

        public static void mostrarMenu() {
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

            if (input != null) {
                abrirVentanaSeleccionada(input);
            }
        }

        private static void abrirVentanaSeleccionada(String seleccion) {
            JFrame ventana = null;
            switch (seleccion) {
                case "CreacionYAlmacenamiento":
                    ventana = new CreacionYAlmacenamiento();
                    break;
                case "NavegacionYListado":
                    ventana = new NavegacionYListado();
                    break;
                case "BuscadorDePalabras":
                    ventana = new BuscadorDePalabras();
                    break;
                case "AgendaDeContactos":
                    ventana = new AgendaDeContactos();
                    break;
                case "MultiplicidadDeVentanas":
                    ventana = new MultiplicidadDeVentanas();
                    break;
                case "SeguimientoDelRaton":
                    ventana = new SeguimientoDelRaton();
                    break;
                case "BarraDeDesplazamiento":
                    ventana = new BarraDeDesplazamiento();
                    break;
                case "ValidadorDeEmail":
                    ventana = new ValidadorDeEmail();
                    break;
                case "HerramientaDeDibujo":
                    ventana = new HerramientaDeDibujo();
                    break;
                case "AnalisisDeTexto":
                    ventana = new AnalisisDeTexto();
                    break;
            }

            if (ventana != null) {
                ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ventana.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        SwingUtilities.invokeLater(Main::mostrarMenu);
                    }
                });
                ventana.setVisible(true);
            }
        }
    }
