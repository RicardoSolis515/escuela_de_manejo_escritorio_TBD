/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editorTabla;

/**
 *
 * @author Usuario
 */
import javax.swing.ImageIcon;
import java.awt.Image;

public class Iconos_botones {

    private final String ICONO_EDITAR = "/Resources/icons8-editar-16.png";
    //"C:\Users\Usuario\Documents\NetBeansProjects\EscuelaDeManejo_Escritorio\Resources\icons8-editar-16.png"
    private final String ICONO_ELIMINAR = "/Resources/icons8-eliminar-16.png";

    
    public ImageIcon getEditarIcono() {
        return cargarIcono(ICONO_EDITAR, 20, 20);
    }

    
    public ImageIcon getEliminarIcono() {
        return cargarIcono(ICONO_ELIMINAR, 20, 20);
    }


    private ImageIcon cargarIcono(String ruta, int ancho, int alto) {
        try {
            ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(ruta));
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(
                    ancho, alto, Image.SCALE_SMOOTH
            );
            return new ImageIcon(imagenEscalada);
        } catch (Exception e) {
            System.err.println("No se pudo cargar el icono: " + ruta);
            return null;
        }
    }
}

