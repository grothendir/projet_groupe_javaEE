package business.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ETUDIANT database table.
 * 
 */
@Entity
@Table(name="ETUDIANT")
@NamedQuery(name="Etudiant.findAll", query="SELECT e FROM Etudiant e")
public class Etudiant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_MEMBRE")
	private int idMembre;

	@Column(name="NOM")
	private String nom;

	//bi-directional many-to-one association to Equipe
	@OneToMany(mappedBy="etudiant")
	private List<Equipe> equipes1;

	//bi-directional one-to-one association to Membre
	@OneToOne
	@JoinColumn(name="ID_MEMBRE")
	private Membre membre;

	//bi-directional many-to-many association to Equipe
	@ManyToMany
	@JoinTable(
		name="MEMBRE_EQUIPE"
		, joinColumns={
			@JoinColumn(name="ID_MEMBRE")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_EQUIPE")
			}
		)
	private List<Equipe> equipes2;

	//bi-directional many-to-many association to Promotion
	@ManyToMany(mappedBy="etudiants")
	private List<Promotion> promotions;

	public Etudiant() {
	}

	public int getIdMembre() {
		return this.idMembre;
	}

	public void setIdMembre(int idMembre) {
		this.idMembre = idMembre;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Equipe> getEquipes1() {
		return this.equipes1;
	}

	public void setEquipes1(List<Equipe> equipes1) {
		this.equipes1 = equipes1;
	}

	public Equipe addEquipes1(Equipe equipes1) {
		getEquipes1().add(equipes1);
		equipes1.setEtudiant(this);

		return equipes1;
	}

	public Equipe removeEquipes1(Equipe equipes1) {
		getEquipes1().remove(equipes1);
		equipes1.setEtudiant(null);

		return equipes1;
	}

	public Membre getMembre() {
		return this.membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public List<Equipe> getEquipes2() {
		return this.equipes2;
	}

	public void setEquipes2(List<Equipe> equipes2) {
		this.equipes2 = equipes2;
	}

	public List<Promotion> getPromotions() {
		return this.promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

}