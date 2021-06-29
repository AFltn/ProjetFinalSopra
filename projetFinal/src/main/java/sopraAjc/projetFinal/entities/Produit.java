package sopraAjc.projetFinal.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import sopraAjc.projetFinal.entities.views.Views;




@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "produit")
@SequenceGenerator(name = "seqProduit", sequenceName = "seq_produit", initialValue = 100, allocationSize = 1)
public class Produit {
	
	@JsonView(Views.Common.class)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduit")
	private Integer id;
	
	
	@JsonView(Views.Common.class)
	@Column(name = "nom", length = 100, nullable = false)
	@NotEmpty(message = "le nom ne peut pas etre vide")
	@Size(min = 2)
	private String nom;
	
	@Lob
	@Column(name = "picture")
	private byte[] photo;
	
	@JsonView(Views.Common.class)
	@Column(name = "editeur", length = 100, nullable = false)
	@NotEmpty(message = "le nom de l'editeur ne peut pas etre vide")
	@Size(min = 2)
	private String editeur;
	
	
	@JsonView(Views.Common.class)
	@Column(name = "prix")
	@Min(value = 1)
	private double prix;
	
	@JsonView(Views.Common.class)
	@Column(name = "date_Sortie")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateSortie;
	
	@JsonView(Views.Common.class)
	@Column(name = "age_Minimum")
	@Min(value = 1)
	private int ageMin;
	
	@JsonView(Views.Common.class)
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column(name = "description")
	private String description;
	
	@JsonView(Views.Common.class)
	@Column(name = "nb_Min_Joueurs")
	@Min(value = 1)
	private int nbMinJoueurs;
	
	@JsonView(Views.Common.class)
	@Column(name = "nb_Max_Joueurs")
	@Min(value = 1)
	private int nbMaxJoueurs;
	
	@JsonView(Views.Common.class)
	@Column(name = "note_Moyenne")
	@Min(value = 0)
	private double noteMoyenne;
	

	
//	@JsonView({ Views.CommandeWithLigneCommande.class, Views.ClientWithCommande.class })
	@OneToMany(mappedBy = "produit")
	private List<Avis> avis;

		
	@JsonIgnore
	@OneToMany(mappedBy = "key.produit")
	private List<LigneCommande> lignesCommandes = new ArrayList<>();

	public Produit() {

	}

	public Produit(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
	}


	public String getEditeur() {
		return editeur;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

	public int getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(int ageMin) {
		this.ageMin = ageMin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbMinJoueurs() {
		return nbMinJoueurs;
	}

	public void setNbMinJoueurs(int nbMinJoueurs) {
		this.nbMinJoueurs = nbMinJoueurs;
	}

	public int getNbMaxJoueurs() {
		return nbMaxJoueurs;
	}

	public void setNbMaxJoueurs(int nbMaxJoueurs) {
		this.nbMaxJoueurs = nbMaxJoueurs;
	}

	public double getNoteMoyenne() {
		return noteMoyenne;
	}

	public void setNoteMoyenne(double noteMoyenne) {
		this.noteMoyenne = noteMoyenne;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}


	public List<LigneCommande> getLignesCommandes() {
		return lignesCommandes;
	}

	public void setLignesCommandes(List<LigneCommande> lignesCommandes) {
		this.lignesCommandes = lignesCommandes;
	}
	
	public void calculerMoyenne(List<Avis> avis) {
		int cpt = 0;
		for (Avis n : avis) {
			cpt +=1;
			noteMoyenne+=n.getNote();
		}
		setNoteMoyenne(noteMoyenne/cpt);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
	}

}
