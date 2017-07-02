package business.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the PROJET database table.
 * 
 */
@Entity
@Table(name="PROJET")
@NamedQuery(name="Projet.findAll", query="SELECT p FROM Projet p")
public class Projet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PROJET")
	private int idProjet;

	@Column(name="DATE_CREATION")
	private String dateCreation;

	@Column(name="DATE_LIMITE_RENDU")
	private String dateLimiteRendu;

	@Column(name="SUJET")
	private String sujet;

	@Column(name="TITRE")
	private String titre;

	//bi-directional many-to-one association to Equipe
	@OneToMany(mappedBy="projet")
	private List<Equipe> equipes;

	//bi-directional many-to-one association to Formateur
	@ManyToOne
	@JoinColumn(name="ID_MEMBRE")
	private Formateur formateur;

	//bi-directional many-to-one association to Promotion
	@ManyToOne
	@JoinColumn(name="ID_PROMOTION")
	private Promotion promotion;

	public Projet() {
	}

	public int getIdProjet() {
		return this.idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public String getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDateLimiteRendu() {
		return this.dateLimiteRendu;
	}

	public void setDateLimiteRendu(String dateLimiteRendu) {
		this.dateLimiteRendu = dateLimiteRendu;
	}

	public String getSujet() {
		return this.sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Equipe> getEquipes() {
		return this.equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Equipe addEquipe(Equipe equipe) {
		getEquipes().add(equipe);
		equipe.setProjet(this);

		return equipe;
	}

	public Equipe removeEquipe(Equipe equipe) {
		getEquipes().remove(equipe);
		equipe.setProjet(null);

		return equipe;
	}

	public Formateur getFormateur() {
		return this.formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

}