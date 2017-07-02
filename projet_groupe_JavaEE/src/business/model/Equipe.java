package business.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the EQUIPE database table.
 * 
 */
@Entity
@Table(name="EQUIPE")
@NamedQuery(name="Equipe.findAll", query="SELECT e FROM Equipe e")
public class Equipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EQUIPE")
	private int idEquipe;

	@Column(name="COMMENTAIRE")
	private String commentaire;

	@Column(name="DATE_CREATION_EQUIPE")
	private String dateCreationEquipe;

	//bi-directional many-to-one association to Etudiant
	@ManyToOne
	@JoinColumn(name="ID_MEMBRE")
	private Etudiant etudiant;

	//bi-directional many-to-one association to Projet
	@ManyToOne
	@JoinColumn(name="ID_PROJET")
	private Projet projet;

	//bi-directional many-to-many association to Etudiant
	@ManyToMany(mappedBy="equipes2")
	private List<Etudiant> etudiants;

	public Equipe() {
	}

	public int getIdEquipe() {
		return this.idEquipe;
	}

	public void setIdEquipe(int idEquipe) {
		this.idEquipe = idEquipe;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getDateCreationEquipe() {
		return this.dateCreationEquipe;
	}

	public void setDateCreationEquipe(String dateCreationEquipe) {
		this.dateCreationEquipe = dateCreationEquipe;
	}

	public Etudiant getEtudiant() {
		return this.etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<Etudiant> getEtudiants() {
		return this.etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

}