/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Lenguaje {

    public static ArrayList<String> getLenguaje(String lenguaje) {
        String[] arr;
        arr = lenguaje.split(",");
        ArrayList<String> a = new ArrayList<>();
        boolean lambda = false;
        for (String item : arr) {
            if (item.contains("λ")) {
                if ("λ".equals(item) && lambda == false) {
                    lambda = true;
                    a.add(item);
                } else {
                    String cadena;
                    cadena = item.replaceAll("λ", "");
                    if (!cadena.isEmpty()) {
                        a.add(cadena);
                    }
                }
            } else {
                a.add(item);
            }
        }
        return a;
    }

    public static ArrayList<String> getAsterisco(String lenguajeText) {
        ArrayList<String> a = new ArrayList<>();
        a.add("λ");
        boolean lambda = false;
        for (String item : getLenguaje(lenguajeText)) {
            if (item.contains("λ")) {
                if ("λ".equals(item) && lambda == false) {
                    lambda = true;
                    a.add(item);
                } else {
                    String cadena;
                    cadena = item.replaceAll("λ", "");
                    if (!cadena.isEmpty()) {
                        a.add(cadena);
                        a.add(cadena + cadena);
                        a.add(cadena + cadena + cadena);
                    }
                }
            } else {
                a.add(item);
                a.add(item + item);
                a.add(item + item + item);
                a.add("...");
            }
        }
        return a;
    }

    public static ArrayList<String> getMas(String lenguajeText) {
        ArrayList<String> a = new ArrayList<>();
        boolean lambda = false;
        for (String item : getLenguaje(lenguajeText)) {
            if (item.equals("...")) {
                a.add(item);
            } else {
                if (item.contains("λ")) {
                    if ("λ".equals(item) && lambda == false) {
                        lambda = true;
                        a.add(item);
                    } else {
                        String cadena;
                        cadena = item.replaceAll("λ", "");
                        if (!cadena.isEmpty()) {
                            a.add(cadena);
                            a.add(cadena + cadena);
                            a.add(cadena + cadena + cadena);
                        }
                    }
                } else {
                    a.add(item);
                    a.add(item + item);
                    a.add(item + item + item);
                    a.add("...");
                }
            }
        }
        return a;
    }

    public static ArrayList<String> getConcatenacion(String a, String b) {
        ArrayList<String> c = new ArrayList<>();
        boolean lambda = false;
        for (String item : getLenguaje(a)) {
            if (item.equals("...")) {
                c.add(item);
            } else {
                for (String itemb : getLenguaje(b)) {
                    if (itemb.equals("...")) {
                        c.add(itemb);
                    } else {
                        if (item.contains("λ")) {
                            if (item.equals("λ")) {
                                item = "";
                            } else {
                                item = item.replaceAll("λ", "");
                            }
                        }
                        if (itemb.contains("λ")) {
                            if (itemb.equals("λ")) {
                                itemb = "";
                            } else {
                                itemb = item.replaceAll("λ", "");
                            }
                        }
                        String cadena = item + itemb;
                        if (!cadena.isEmpty()) {
                            c.add(cadena);
                        }
                    }
                }
            }
        }
        return c;
    }

    public static ArrayList<String> getUnion(String a, String b) {
        ArrayList<String> c = new ArrayList<>();
        boolean lambda = false;
        for (String item : getLenguaje(a)) {
            if (item.contains("λ")) {
                if ("λ".equals(item) && lambda == false) {
                    lambda = true;
                    c.add(item);
                } else {
                    String cadena;
                    cadena = item.replaceAll("λ", "");
                    if (!cadena.isEmpty()) {
                        c.add(cadena);
                    }
                }
            } else {
                c.add(item);
            }
        }
        for (String item : getLenguaje(b)) {
            if (!item.equals("...")) {
                if (!c.contains(item)) {
                    if (item.contains("λ")) {
                        if ("λ".equals(item) && lambda == false) {
                            lambda = true;
                            c.add(item);
                        } else {
                            String cadena;
                            cadena = item.replaceAll("λ", "");
                            if (!cadena.isEmpty()) {
                                c.add(cadena);
                            }
                        }
                    } else {
                        c.add(item);
                    }
                }
            } else {
                c.add(item);
            }
        }
        return c;
    }
}
