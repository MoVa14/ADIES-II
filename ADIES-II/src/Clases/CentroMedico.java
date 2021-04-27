/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author moise
 */
public class CentroMedico {

    public static int id_centro = 0;
    public static String nombre_centro = "";

    public static String getNombre_centro() {
        return nombre_centro;
    }

    public static void setNombre_centro(String nombre_centro) {
        CentroMedico.nombre_centro = nombre_centro;
    }

    public static int getId_centro() {
        return id_centro;
    }

    public static void setId_centro(int id_centro) {
        CentroMedico.id_centro = id_centro;
    }

}
