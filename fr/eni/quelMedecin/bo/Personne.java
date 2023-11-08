package fr.eni.quelMedecin.bo;

import java.util.Collections;
import java.util.Comparator;

/**
 * Classe modélisant une personne 
 * Cette classe regroupe les éléments communs à toutes les personnes 
 * qu'elles soient médecin ou patient
 * Elle généralise les classes Medecin et Patient
 * 
 * @author ENI
 * @version 3.0
 */
public abstract class Personne implements Comparator<Personne>{

	public static Comparator<Personne> comparatorNomPrenomCroissant = new Comparator<Personne>() {
		@Override
		public int compare(Personne o1, Personne o2) {
			return o1.getNom().compareTo(o2.getNom());
		}
	};
	public static Comparator<Personne> comparatorNomPrenomDecroissant = new Comparator<Personne>() {
		@Override
		public int compare(Personne o1, Personne o2) {
			return o2.getNom().compareTo(o1.getNom());
		}

	};

	//ATTRIBUTS D'INSTANCE
	protected String nom;
	protected String prenom;
	protected String numeroDeTelephone;
	//association unidirectionnelle
	protected Adresse adresse;

	//CONSTRUCTEURS
	/**
	 * Constructeur : crée une instance de Personne
	 *
	 * @param nom - nom de la personne
	 * @param prenom - prénom de la personne
	 * @param numeroDeTelephone - numéro de téléphone de la personne
	 * @param adresse - adresse postale de la personne
	 */


	public Personne(String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
		this.setNom(nom.toUpperCase());
		this.setPrenom(prenom);
		this.setNumeroDeTelephone(numeroDeTelephone);
		this.setAdresse(adresse);
	}

	//AUTRES METHODES
	/**
	 * Affiche les information sur la personne sous la forme :
	 * NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Adresse :
	 * ......(cf méthode afficher() de Adresse)
	 */
	@Deprecated
	public void afficher() {
		System.out.printf("%s %s%nTéléphone : %s%n", 
				this.getNom(), 
				this.getPrenom(), 
				this.getNumeroDeTelephone());
		if (this.adresse != null)
			this.getAdresse().afficher();
	}

	/**
	 * Formate les informations sur la Personne sous la forme :
	 * NOM Prénom
	 * Téléphone : XXXXXXXXXX
	 * Adresse :
	 * ......(cf méthode toString() de Adresse)
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getNom()).append(" ").append(this.getPrenom()).append("\n");
		sb.append("Téléphone : ").append(this.getNumeroDeTelephone()).append("\n");
		if (this.adresse != null) {
			sb.append(this.getAdresse().toString());
		}
		return sb.toString(); 
	}
	
	//ACCESSEURS ET MUTATEURS
	/**
	 * Getter pour nom.
	 * @return le nom du médecin
	 * @see MedecinGeneraliste#setNom(String)
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour nom.
	 * @param nom - le nom du medecin
	 * @see MedecinGeneraliste#getNom()
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter pour prenom.
	 * @return le prenom du médecin
	 * @see MedecinGeneraliste#setPrenom(String)
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter pour prenom.
	 * @param prenom - le prenom du medecin
	 * @see MedecinGeneraliste#getPrenom()
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter pour numeroDeTelephone.
	 * @return le numéro de téléphone
	 * @see MedecinGeneraliste#setNumeroDeTelephone(String)
	 */
	public String getNumeroDeTelephone() {
		return this.numeroDeTelephone;
	}

	/**
	 * Setter pour numeroDeTelephone.
	 * @param numeroDeTelephone -le numéro de téléphone
	 * @see MedecinGeneraliste#getNumeroDeTelephone()
	 */
	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}

	/**
	 * Getter pour adresse
	 * @return l'adresse du medecin
	 * @see MedecinGeneraliste#setAdresse(Adresse)
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * Setter pour adresse
	 * @param adresse - l'adresse du medecin
	 * @see MedecinGeneraliste#getAdresse()
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	@Override
	public int compare(Personne o1, Personne o2) {
		return o1.getNom().compareTo(o2.getNom());
	}

	@Override
	public Comparator<Personne> reversed() {
		return Comparator.super.reversed();
	}

	@Override
	public Comparator<Personne> thenComparing(Comparator<? super Personne> other) {
		return Comparator.super.thenComparing(other);
	}
}