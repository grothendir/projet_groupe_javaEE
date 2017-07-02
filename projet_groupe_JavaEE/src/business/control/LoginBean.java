package business.control;

import java.util.List;

import business.model.Equipe;
import business.model.Etudiant;
import business.model.Formateur;
import business.model.Projet;
import business.model.Promotion;
import eis.dao.Dao;

public class LoginBean {

	private Formateur formateur;
	private Etudiant etudiant;
	private Dao dao;
	private String nom;
	private String motdepasse;
	private String nomprojet;
	private Projet leProjet;

	private List<Projet> lesProjets;
	private List<Promotion> lesPromotions;
	private String nomPromotion;

	private List<Equipe> lesEquipes;
	private Equipe equipe;
	private int idEquipe;
	private int idPromo;

	public int getIdEquipe() {
		return idEquipe;
	}

	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

	/**
	 * 
	 */
	public LoginBean() {
		dao = new Dao();
		setLesPromotions(dao.getPromotions());
		setLesEquipes(dao.getEquipes());
	}

	////////////////////// CREATION D UN PROJET//////////////
	/**
	 * Création d'un projet
	 * 
	 * @return
	 */
	public String creerProjet() {
		System.out.println("promotion trouv�e" + nomPromotion + " " + leProjet.getSujet());

		for (Promotion p : lesPromotions) {
			if (p.getIdPromotion().equals(nomPromotion))
				dao.creerProjet(leProjet, formateur, p);
		}
		return "inconnu";
	}

	//////////////////////// INSCRIPTION DANS UNE
	//////////////////////// EQUIPE///////////////////////////
	public String inscriptionEquipe() {
		System.out.println("Equipe trouvee : " + idEquipe + " " + etudiant.getNom());

		for (Equipe e : lesEquipes) {
			if (e.getIdEquipe() == idEquipe) {
				System.out.println("Equipe trouvee : " + e.getNomEquipe() + " " + etudiant.getNom());
				dao.inscriptionEquipe(e, etudiant);
			}
		}
		return "validationInscription";
	}

	//////////////////////// INSCRIPTION DANS UNE
	//////////////////////// PROMOTION///////////////////////////

	public void inscriptionPromotion() {
		System.out.println("Promotion trouvee : " + nomPromotion + " " + etudiant.getNom());

		for (Promotion p : lesPromotions) {
			if (p.getNomPromo().equals(nomPromotion)) {
				System.out.println("Promotion trouvee : " + p.getNomPromo() + " " + etudiant.getNom());
				dao.inscriptionPromotion(etudiant, p);
			}
		}

	}

	/**
	 * 
	 * @param Promotion
	 *            promotion
	 * @return
	 */
	public String getPromotionEtudiant(Promotion p) {
		return (dao.getPromotionEtudiant(p).getNom());

	}

	/////////////////////// VALIDATION MEMBRE// ETUDIANT OU
	/////////////////////// FORMATEUR//////////////////

	public String validationMembre() {
		formateur = dao.verifierFormateur(nom, motdepasse);
		String vue = "inviteFormateur";
		if (formateur != null) {
			lesProjets = dao.getProjetParFormateur(formateur);
			leProjet = new Projet();
		}

		else {
			etudiant = dao.verifierEtudiant(nom, motdepasse);
			if (etudiant != null) {
				vue = "InviteEtudiantBis";
			} else {
				vue = "inconnu";
			}
		}
		return vue;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public String getNomprojet() {
		return nomprojet;
	}

	public void setNomprojet(String nomprojet) {
		this.nomprojet = nomprojet;
	}

	public Projet getLeProjet() {
		return leProjet;
	}

	public void setLeProjet(Projet leProjet) {
		this.leProjet = leProjet;
	}

	public List<Projet> getLesProjets() {
		return lesProjets;
	}

	public void setLesProjets(List<Projet> lesProjets) {
		this.lesProjets = lesProjets;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public List<Equipe> getLesEquipes() {
		return lesEquipes;
	}

	public void setLesEquipes(List<Equipe> lesEquipes) {
		this.lesEquipes = lesEquipes;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public List<Promotion> getLesPromotions() {
		return lesPromotions;
	}

	public void setLesPromotions(List<Promotion> lesPromotions) {
		this.lesPromotions = lesPromotions;
	}

	public String getNomPromotion() {
		return nomPromotion;
	}

	public void setNomPromotion(String nomPromotion) {
		this.nomPromotion = nomPromotion;
	}

}
