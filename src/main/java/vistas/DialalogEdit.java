/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author Usuario
 */
public class DialalogEdit extends JDialog {

    private JDesktopPane escritorio;

    public DialalogEdit(JFrame owner) {
        super(owner, "Editar", true); 

        escritorio = new JDesktopPane();
        add(escritorio);

        setSize(452, 370);
        setLocationRelativeTo(owner);
        this.setResizable(false);
    }

    public void abrirInternalFrame(JInternalFrame internal) {
        escritorio.add(internal);
        internal.setVisible(true);
        internal.toFront();
    }
    
    public DialalogEdit(JFrame owner,int width) {
        super(owner, "Editar", true);  

        escritorio = new JDesktopPane();
        add(escritorio);

        setSize(width, 370);
        setLocationRelativeTo(owner);
    }
    
    public DialalogEdit(JFrame owner,int width, int height) {
        super(owner, "Editar", true);  

        escritorio = new JDesktopPane();
        add(escritorio);

        setSize(width, height);
        setLocationRelativeTo(owner);
    }

}
