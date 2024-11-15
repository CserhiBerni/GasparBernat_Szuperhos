package hu.petrik.szuperhosprojekt;

public class Batman implements Szuperhos, Milliardos {
    private double lelemenyesseg;

    public Batman() {
        this.lelemenyesseg = 100;
    }

    public double getLelemenyesseg() {
        return lelemenyesseg;
    }

    @Override
    public double mekkoraAzEreje() {
        return 2 * lelemenyesseg;
    }

    @Override
    public boolean legyoziE(Szuperhos masik) {
        return masik.mekkoraAzEreje() < this.lelemenyesseg;
    }

    @Override
    public void kutyutKeszit() {
        this.lelemenyesseg += 50;
    }

    @Override
    public String toString() {
        return String.format("Batman: leleményesség: %.2f", lelemenyesseg);
    }
}

