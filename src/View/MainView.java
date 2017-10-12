package View;

import Controller.BBDD.ActionUserBD;
import Model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {
    private JTextField cmpoNombre;
    private JTextField cmpoApellidos;
    private JTextField cmpoEdad;
    private JTextField cmpoAltura;
    private JButton btnAlta;
    private JPanel panel1;
    private JButton btnListar;

    public MainView() {
        btnAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = cmpoNombre.getText();
                String apellidos = cmpoApellidos.getText();
                int edad = Integer.parseInt(cmpoEdad.getText());
                float altura = Float.parseFloat(cmpoAltura.getText());

                Usuario usuario = new Usuario(nombre, apellidos, edad, altura);

                //SaveDatasInFile save = new SaveDatasInFile();

                //save.saveData(usuario);
                ActionUserBD saveUserBD = new ActionUserBD();

                saveUserBD.insertUser(usuario);

            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Listado dialog = new Listado();
                    dialog.pack();
                    dialog.setVisible(true);
                    System.exit(0);
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
