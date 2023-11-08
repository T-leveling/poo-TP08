package fr.eni.quelMedecin.bo;

import java.util.Comparator;

public class ComparatorMedecinSpecialisteTarif implements Comparator<MedecinSpecialiste> {

    @Override
    public int compare(MedecinSpecialiste medecin1, MedecinSpecialiste medecin2) {
        return medecin1.getTarif() - (medecin2.getTarif());
    }
}
