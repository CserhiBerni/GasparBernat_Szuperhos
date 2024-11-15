package hu.petrik.szuperhosprojekt;

import java.text.MessageFormat;

public abstract class Bosszuallo implements Szuperhos {
    private double szuperero;
    private boolean vanEGyengesege;

    public Bosszuallo(double szuperero, boolean vanEGyengesege) {
        this.szuperero = szuperero;
        this.vanEGyengesege = vanEGyengesege;
    }

    public double getSzuperero() {
        return szuperero;
    }

    public void setSzuperero(double szuperero) {
        this.szuperero = szuperero;
    }

    public boolean isVanEGyengesege() {
        return vanEGyengesege;
    }

    public void setVanEGyengesege(boolean vanEGyengesege) {
        this.vanEGyengesege = vanEGyengesege;
    }

    @Override
    public double mekkoraAzEreje() {
        return this.szuperero;
    }

    @Override
    public boolean legyoziE(Szuperhos masik) {
        if (masik instanceof Bosszuallo) {
            Bosszuallo ellenfel = (Bosszuallo) masik;
            if (ellenfel.isVanEGyengesege() && this.szuperero > ellenfel.getSzuperero()) {
                return true;
            }
        } else if (masik instanceof Batman) {
            return this.szuperero > 2 * masik.mekkoraAzEreje();
        }
        return false;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Szupererő: {0,number,#.##}; {1}",
                szuperero,
                vanEGyengesege ? "van gyengesége" : "nincs gyengesége");
    }

    public abstract boolean megmentiAVilagot();
}

