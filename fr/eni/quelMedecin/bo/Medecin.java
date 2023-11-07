package fr.eni.quelMedecin.bo;

/**
 * Classe héritée modélisant un médecin et spécialisant la classe Personne
 * Cette classe est aussi une généralisation des classes MedecinGeneraliste et MedecinSpecialiste
 *  
 * @author ENI
 * @version 3.0
 */
public class Medecin extends Personne {
	//ATTRIBUTS D'INSTANCE
	private Creneau[] creneaux;
	//CONSTANTES DE CLASSE
	public static final int MAX_CRENEAUX = 15;

	//CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de Medecin
	 * 
	 * @param nom - nom du médecin
	 * @param prenom - prénom du médecin
	 * @param numeroDeTelephone - numéro de téléphone du medecin
	 * @param adresse - adresse postale du medecin
	 */
	public Medecin(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		super(nom, prenom, numeroDeTelephone, adresse);
		creneaux = new Creneau[MAX_CRENEAUX];
	}

	//AUTRES METHODES
	/**
	 * Affiche sur la console sous la forme : NOM Prénom Téléphone : XXXXXXXXXX
	 * Adresse :
	 * Complément
	 * XXbis rue XXXXXXXXX
	 * 00000 XXXXXXXXXXXXX
	 * Créneaux :
	 * 00:00 - 00:00 (XX minutes)
	 * 00:00 - 00:00 (XX minutes)
	 * 00:00 - 00:00 (XX minutes)
	 * 00:00 - 00:00 (XX minutes)
	 */
	@Deprecated
	public void AfficherAdresseEtCreneaux() {
		System.out.println("Adresse :");
		this.adresse.afficher();
		System.out.println("Créneaux :");
		for (int i = 0; i < this.creneaux.length; i++)
			if (this.creneaux[i] != null)
				this.creneaux[i].afficher();
	}

	/**
	 * Formate les informations sur le Patient sous la forme :
	 * NOM Prénom 
	 * Téléphone : XXXXXXXXXX
	 * Adresse :
	 * Complément
	 * XXbis rue XXXXXXXXX
	 * 00000 XXXXXXXXXXXXX (cf methode toString() de Personne)
	 * Créneaux :
	 * 00:00 - 00:00 (XX minutes) (cf méthode toString() de Creneau)
	 * 00:00 - 00:00 (XX minutes)
	 * 00:00 - 00:00 (XX minutes)
	 * 00:00 - 00:00 (XX minutes)
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Creneaux :").append("\n");
		for (int i = 0; i < this.creneaux.length; i++)
			if (this.creneaux[i] != null)
				sb.append(this.creneaux[i].toString());
		return sb.toString();
	}

	/**
	 * Ajoute un créneau horaire pour ce médecin
	 * @param creneauAAjouter
	 */
	void ajouterCreneau(Creneau creneauAAjouter) {
		if (this != creneauAAjouter.getMedecin()) {
			System.err.println("Ce créneau ne peut être associé à ce médecin car il est déjà associé à un autre");
		} else {
			int pos = 0;
			while (pos < this.creneaux.length && this.creneaux[pos] != null)
				pos++;
			if (pos == this.creneaux.length)
				System.err.println("Trop de créneaux sont affectés à ce médecin");
			else
				this.creneaux[pos] = creneauAAjouter;
		}
	}


	public void examiner() {
		System.out.println("Le médecin procède à des examens de routine sur les patients (auscultation, prise de tensions, ...)");
	}

	public void diagnostiquer() {
		System.out.println("Le médecin évalue l'état de santé du patient pour découvrir d'éventuels problèmes ");
	}

	public void conseiller() {
		System.out.println("Le médecin dispense des conseils appropriés pour des habitudes saines (régime, hygiène, etc.)");
	}

	public void orienter() {
		System.out.println("Le médecin oriente vers un spécialiste en cas de besoin");
	}
}
