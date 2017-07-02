package eis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import business.model.Equipe;
import business.model.Etudiant;
import business.model.Formateur;
import business.model.Projet;
import business.model.Promotion;

/**
 * 
 * @author FAteam
 *
 * 
 */
public class Dao {
	private EntityManager entityManager;

	/**
	 * Constructeur Dao : connexion à la base de donnée et opérations CRUD via l'interface Java Persistence API.
	 */
	public Dao() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("centreformationbis");
		entityManager = factory.createEntityManager();
	}

	///////////////////////////// AJOUT DE METHODES POUR INSCRIPTION D UN MEMBRE
	///////////////////////////// DANS UNE EQUIPE////////////

	/**
	 * Accède à une équipe par son nom
	 * @param String nom
	 * @return Equipe - equipe
	 */
	public Equipe getEquipe(String nom) {
		String requete = "SELECT g FROM Equipe g where g.nomEquipe = ";
		requete = requete + "'" + nom + "'";
		TypedQuery<Equipe> query = entityManager.createQuery(requete, Equipe.class);

		if (query.getResultList().size() != 0) {
			Equipe equipe = query.getSingleResult();
			System.out.println("Equipe trouv�e: " + equipe.getIdEquipe());
			return equipe;
		} else
			return null;
	}

	/**
	 * Accède à un étudiant via son nom.
	 * @param String nom
	 * @return Etudiant - etudiant
	 */
	public Etudiant getEtudiant(String nom) {
		String requete = "SELECT g FROM Etudiant g where g.nom = ";
		requete = requete + "'" + nom + "'";
		TypedQuery<Etudiant> query = entityManager.createQuery(requete, Etudiant.class);

		if (query.getResultList().size() != 0) {
			Etudiant etudiant = query.getSingleResult();
			System.out.println("Etudiant trouv�: " + etudiant.getNom());
			return etudiant;
		} else
			return null;
	}


	/**
	 * Inscris un étudiant dans une équipe.
	 * @param Equipe equipe
	 * @param Etudiant etudiant
	 * @return boolean - vrai si la transaction s'est bien effectuée, faux sinon.
	 */
	public boolean inscriptionEquipe(Equipe equipe, Etudiant etudiant) {
		entityManager.getTransaction().begin();
		List<Etudiant> liste;
		liste = equipe.getEtudiants();
		liste.add(etudiant);
		// equi.setEtudiants(liste);
		entityManager.merge(equipe);
		entityManager.getTransaction().commit();
		return true;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////

	////////// INSCRIPTION FORMATION///////////////////
	/**
	 * Inscirs un étudiant dans une promotion.
	 * @param Etudiant etudiant
	 * @param Promotion promotion
	 * @return boolean - vrai si la transaction s'est bien effectuée, faux sinon.
	 */
	public boolean inscriptionPromotion(Etudiant etudiant, Promotion promotion) {
		entityManager.getTransaction().begin();
		List<Promotion> promotions;
		promotions = etudiant.getPromotions();
		promotions.add(promotion);
		entityManager.merge(etudiant);
		entityManager.getTransaction().commit();
		return true;
	}

	/**
	 * Accède à une promotion via son nom.
	 * @param String nom
	 * @return Promotion - promotion
	 */
	public Promotion getPromotion(String nom) {
		String requete = "SELECT g FROM Promotion g where g.nomPromo = ";
		requete = requete + "'" + nom + "'";
		TypedQuery<Promotion> query = entityManager.createQuery(requete, Promotion.class);

		if (query.getResultList().size() != 0) {
			Promotion promotion = query.getSingleResult();
			System.out.println("Promotion trouvée: " + promotion.getIdPromotion());
			return promotion;
		} else
			return null;
	}

	/**
	 * Accède à un étudiant via sa promotion.
	 * @param Promotion promotion
	 * @return Etudiant - etudiant
	 */
	public Etudiant getPromotionEtudiant(Promotion promotion) {

		String requete = "SELECT g FROM Etudiant g where g.idMembre IN (SELECT m.idMembre FROM membre_promotion m where m.idPromotion = ";
		requete = requete + promotion.getIdPromotion() + ")";

		// String requete = "SELECT g FROM Promotion g where g.idPromotion IN
		// (SELECT m.idPromotion FROM membre_promotion m where m.idMembre = ";
		// requete = requete + e.getIdMembre()+")";
		// TypedQuery<Promotion> query = em.createQuery(requete,
		// Promotion.class);
		TypedQuery<Etudiant> query = entityManager.createQuery(requete, Etudiant.class);
Etudiant etudiantReturn;
		if (query.getResultList().size() != 0) {
			Etudiant e = query.getSingleResult();
			System.out.println("Promotion trouvée: " + promotion.getIdPromotion());
			return e;
		} else
			return null;
	}

	/**
	 * Crée le projet d'un formateur pour une promotion.
	 * @param Projet projet
	 * @param Formateur formateur
	 * @param Promotion promotion
	 * @return boolean - resultat de la transaction.
	 */
	public boolean creerProjet(Projet projet, Formateur formateur, Promotion promotion) {
		System.out.println("creation projet"); // pour tester
		projet.setFormateur(formateur);
		projet.setPromotion(promotion);
		entityManager.getTransaction().begin();
		entityManager.persist(projet);
		entityManager.getTransaction().commit();
		return true;
	}

	// requete parametr�e
	/**
	 * 
	 * @param 
	 * @return List <Projet>
	 * 
	 * 	 */
	/**
	 * Liste les projets d'un formateur.
	 * requête paramétrée.
	 * @param Formateur formateur
	 * @return List<> - de projets
	 */
	public List<Projet> getProjetsParFormateur(Formateur formateur) {
		List<Projet> projets = null;
		Query query = entityManager.createQuery("SELECT s FROM Projet s Where s.formateur = :var");
		query.setParameter("var", formateur);
		projets = query.getResultList();
		return projets;
	}

	/**
	 * Liste les sujets des projets d'un formateur.
	 * @param Formateur formateur
	 * @return ListString - liste des sujets
	 */
	public List<String> getSujetsParFormateur(Formateur formateur) {
		List<String> sujets = null;
		Query q = entityManager.createQuery("SELECT s.sujet FROM Projet s Where s.formateur = :var");
		q.setParameter("var", formateur);
		sujets = q.getResultList();
		return sujets;
	}

	/**
	 * Liste toutes les promotions.
	 * @return liste de promotions.
	 */
	public List<Promotion> getPromotions() {
		String requete = "SELECT g FROM Promotion g ";
		TypedQuery<Promotion> query = entityManager.createQuery(requete, Promotion.class);
		List<Promotion> promotions = query.getResultList();
		return promotions;
	}

	/**
	 * Liste toutes les équipes.
	 * @return liste d'équipe.
	 */
	public List<Equipe> getEquipes() {
		String requete = "select g FROM Equipe g";
		TypedQuery<Equipe> query = entityManager.createQuery(requete, Equipe.class);
		List<Equipe> liste = query.getResultList();
		return liste;
	}

	/**
	 * Vérifie le formateur en fonction du nom et du mot de passe.
	 * @param String nom
	 * @param String mdp
	 * @return Formateur - formateur
	 */
	public Formateur verifierFormateur(String nom, String mdp) {
		String requete = "SELECT g FROM Formateur g where g.nom = ";
		requete = requete + "'" + nom + "'";
		Formateur i1 = null;

		TypedQuery<Formateur> query = entityManager.createQuery(requete, Formateur.class);

		if (query.getResultList().size() != 0) {
			i1 = query.getSingleResult();
			System.out.println("Formateur trouv�:" + i1.getNom());
			requete = "SELECT g FROM Membre g where g.nom = ";
			requete = requete + "'" + nom + "'";
			requete = requete + "and g.motdepasse = " + "'" + mdp + "'";
			if (query.getResultList().size() != 0) {
				System.out.println("Mot de passe ok");
				Formateur f = query.getSingleResult();
				return f;

			} else {
				System.out.println("Mot de passe faux");
				return null;
			}
		} else {
			System.out.println("Pas trouv�");
			return null;
		}
	}

	/**
	 * Vérifie un étudiant par nom et mot de passe.
	 * @param String nom
	 * @param String mdp
	 * @return boolean - resultat du test de vérification.
	 */
	public Etudiant verifierEtudiant(String nom, String mdp) {
		String requete = "SELECT g FROM Etudiant g where g.nom = ";
		requete = requete + "'" + nom + "'";
		Etudiant e1 = null;

		TypedQuery<Etudiant> query = entityManager.createQuery(requete, Etudiant.class);

		if (query.getResultList().size() != 0) {
			e1 = query.getSingleResult();
			System.out.println("Etudiant trouv�:" + e1.getNom());
			requete = "SELECT g FROM Membre g where g.nom = ";
			requete = requete + "'" + nom + "'";
			requete = requete + "and g.motdepasse = " + "'" + mdp + "'";
			if (query.getResultList().size() != 0) {
				System.out.println("Mot de passe ok");
				Etudiant e = query.getSingleResult();
				return e;

			} else {
				System.out.println("Mot de passe faux");
				return null;
			}
		} else {
			System.out.println("Pas trouv�");
			return null;
		}
	}

}
