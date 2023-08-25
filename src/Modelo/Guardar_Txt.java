/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Rafael Corredor
 */
public class Guardar_Txt {

    public static boolean guardar(String nombre, Serializable obj) {
        boolean sw = false;
        try (FileOutputStream ob = new FileOutputStream(nombre);
                ObjectOutputStream tr = new ObjectOutputStream(ob);) {
            tr.writeObject(obj);
            sw = true;

        } catch (Exception e) {
        }
        return sw;

    }

    public static <E> E Extraer(String nom, Class<E> op) {
        E obb = null;
        try (FileInputStream h = new FileInputStream(nom);
                ObjectInputStream ar = new ObjectInputStream(h);) {
            obb = (E) ar.readObject();

        } catch (Exception e) {
        }

        return obb;
    }
}
