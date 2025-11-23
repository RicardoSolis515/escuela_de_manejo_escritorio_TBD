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
 */public class DialalogEdit extends JDialog {

    private JDesktopPane escritorio;

    public DialalogEdit(JFrame owner) {
        super(owner, "Editar", true);  // <-- true = MODAL

        escritorio = new JDesktopPane();
        add(escritorio);

        setSize(535, 330);
        setLocationRelativeTo(owner);
    }

    public void abrirInternalFrame(JInternalFrame internal) {
        escritorio.add(internal);
        internal.setVisible(true);
        internal.toFront();
    }
}
