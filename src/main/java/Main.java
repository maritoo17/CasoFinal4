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
        mostrarMenu();
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
            switch (input) {
                case "CreacionYAlmacenamiento":
                    CreacionYAlmacenamiento creacionYAlmacenamiento = new CreacionYAlmacenamiento();
                    creacionYAlmacenamiento.setVisible(true);
                    creacionYAlmacenamiento.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            mostrarMenu();
                        }
                    });
                    break;
                case "NavegacionYListado":
                    NavegacionYListado navegacionYListado = new NavegacionYListado();
                    navegacionYListado.setVisible(true);
                    navegacionYListado.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            mostrarMenu();
                        }
                    });
                    break;
                case "BuscadorDePalabras":
                    BuscadorDePalabras buscadorDePalabras = new BuscadorDePalabras();
                    buscadorDePalabras.setVisible(true);
                    buscadorDePalabras.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            mostrarMenu();
                        }
                    });
                    break;
                case "AgendaDeContactos":
                    AgendaDeContactos agendaDeContactos = new AgendaDeContactos();
                    agendaDeContactos.setVisible(true);
                    agendaDeContactos.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            mostrarMenu();
                        }
                    });
                    break;
                case "MultiplicidadDeVentanas":
                    MultiplicidadDeVentanas multiplicidadDeVentanas = new MultiplicidadDeVentanas();
                    multiplicidadDeVentanas.setVisible(true);
                    multiplicidadDeVentanas.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            mostrarMenu();
                        }
                    });
                    break;
                case "SeguimientoDelRaton":
                    SeguimientoDelRaton seguimientoDelRaton = new SeguimientoDelRaton();
                    seguimientoDelRaton.setVisible(true);
                    seguimientoDelRaton.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            mostrarMenu();
                        }
                    });
                    break;
                case "BarraDeDesplazamiento":
                    BarraDeDesplazamiento barraDeDesplazamiento = new BarraDeDesplazamiento();
                    barraDeDesplazamiento.setVisible(true);
                    barraDeDesplazamiento.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            mostrarMenu();
                        }
                    });
                    break;
                case "ValidadorDeEmail":
                    ValidadorDeEmail validadorDeEmail = new ValidadorDeEmail();
                    validadorDeEmail.setVisible(true);
                    validadorDeEmail.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            mostrarMenu();
                        }
                    });
                    break;
                case "HerramientaDeDibujo":
                    HerramientaDeDibujo herramientaDeDibujo = new HerramientaDeDibujo();
                    herramientaDeDibujo.setVisible(true);
                    herramientaDeDibujo.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            mostrarMenu();
                        }
                    });
                    break;
                case "AnalisisDeTexto":
                    AnalisisDeTexto analisisDeTexto = new AnalisisDeTexto();
                    analisisDeTexto.setVisible(true);
                    analisisDeTexto.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            mostrarMenu();
                        }
                    });
                    break;
            }
        }
    }
}
