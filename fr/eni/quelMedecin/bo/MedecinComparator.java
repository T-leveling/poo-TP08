package fr.eni.quelMedecin.bo;

import java.util.ArrayList;
import java.util.Comparator;

public class MedecinComparator implements Comparator<MedecinSpecialiste> {


    @Override
    public int compare(MedecinSpecialiste medecin1, MedecinSpecialiste medecin2) {
        return medecin1.getSpecialite().compareTo(medecin2.getSpecialite());
    }

    @Override
    public Comparator<MedecinSpecialiste> reversed() {
        return Comparator.super.reversed();
    }
}
