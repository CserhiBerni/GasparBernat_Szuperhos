package hu.petrik.szuperhosprojekt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Kepregeny {
    public static List<Szuperhos> szuperhosLista = new ArrayList<>();

    public static void szereplok(String fajlNev) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fajlNev))) {
            String sor;
            while ((sor = reader.readLine()) != null) {
                String[] adatok = sor.split(" ");
                String tipus = adatok[0];
                int kutyukSzama = Integer.parseInt(adatok[1]);

                Szuperhos szuperhos;
                if (tipus.equalsIgnoreCase("Vasember")) {
                    szuperhos = new Vasember();
                } else if (tipus.equalsIgnoreCase("Batman")) {
                    szuperhos = new Batman();
                } else {
                    throw new IllegalArgumentException("Ismeretlen szuperhős típus: " + tipus);
                }

                if (szuperhos instanceof Milliardos) {
                    Milliardos milliardos = (Milliardos) szuperhos;
                    for (int i = 0; i < kutyukSzama; i++) {
                        milliardos.kutyutKeszit();
                    }
                }

                szuperhosLista.add(szuperhos);
            }
        } catch (IOException e) {
            System.err.println("Hiba történt a fájl beolvasása közben: " + e.getMessage());
        }
    }

    public static void szuperhosok() {
        for (Szuperhos szuperhos : szuperhosLista) {
            System.out.println(szuperhos);
        }
    }

    public static void main(String[] args) {
        szereplok("szuperhosok.txt");
        szuperhosok();
    }
}
