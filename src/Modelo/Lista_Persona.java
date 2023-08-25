/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.General.obj;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rafael Corredor
 */
public class Lista_Persona implements Serializable {

    Persona listaDatos[];
    int tam;
    private final long versionID = 1;

    public final String nombre_Fichero = "Persona.dat";

    public void Guadar_Fichero() {
        try {
            Guardar_Txt.guardar(nombre_Fichero, obj);
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Lo siento no se puede guardar la información , intente más tarde");
        }

    }

    public void Extraer_Fichero() {
        try {
            obj = Guardar_Txt.Extraer(nombre_Fichero, Lista_Persona.class);
            if (obj == null) {
                obj = new Lista_Persona(3);
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Lo siento no se pudieron cargar los dato del archivo");
        }

    }

    public Lista_Persona(int tam) {
        generar(tam);
    }

    public Persona[] getListDatos() {
        return listaDatos;
    }

    public int getTam() {
        return tam;
    }

    public Persona extraerArreglo(int pos) {
        return listaDatos[pos];
    }

    public void generar(int tam) {
        if (tam <= 0) {
            generar(Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de profesores")));
        } else {
            this.tam = tam;
            listaDatos = new Persona[tam];
        }
    }

    public void Guardar_Arreglo(String nombre, String apellido,
            String cedula, String Barrio, String Edad, int pos) {

        Persona a = new Persona();
        a.setNombre(nombre);
        a.setApellido(apellido);
        a.setBarrio(Barrio);
        a.setCedula(cedula);
        a.setEdad(Edad);

        obj.listaDatos[pos] = a;
        Guadar_Fichero();
    }

    public void Mostrar_Tabla(DefaultTableModel Tabla) {
        Extraer_Fichero();
        for (int i = 0; i < 3; i++) {

            Tabla.addRow(new Object[]{
            obj.extraerArreglo(i).getNombre(),
               obj.extraerArreglo(i).getApellido(),
               obj.extraerArreglo(i).getCedula(),
                obj.extraerArreglo(i).getBarrio(),
                obj.extraerArreglo(i).getEdad()
            });
        }

    }

//    public void busqueda_avanzada(int dato) {
//        try {
//
//            for (int i = 0; i < tam; i++) {
//                if (dato == obtenerEstudiante(i).getId()) {
//                    JOptionPane.showMessageDialog(null, "se encontró");
//                } else {
//                    JOptionPane.showMessageDialog(null, "No se encontró");
//                }
//            }
//        } catch (Exception e) {
//        }
//    }
    public void obtenerprofesores(int pos, Persona datos) {
        if (pos < 0 || pos >= tam) {
            JOptionPane.showMessageDialog(null, "No se puede agregar. Fuera de índice.");
        } else {
            listaDatos[pos] = datos;
        }
    }

    public Persona obtenerEstudiante(int pos) {
        return this.listaDatos[pos];
    }

    public Persona[] obtenerPorNota() {
        Persona nuevo[] = new Persona[tam];
        int contador = 0;
        for (int i = 0; i < tam; i++) {

            nuevo[contador] = this.listaDatos[i];
            contador++;
        }

        return nuevo;
    }

}
