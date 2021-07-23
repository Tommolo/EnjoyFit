package it.uniroma3.siw.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "opera")

public class Quadro {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false)
	private String titolo;
	@Column
	private int anno;
	@Column(length=5096)
	private String descrizione;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="collezione_id")
	private Collezione collezione;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "artista_id")
	private Artista artista;
	
	@Column(nullable=true)
	private String foto;
	
	 @Transient
	    public String getPhotosImagePath() {
	        if (foto.equals(null) || id.equals(null)) return null;
	         
	        return "/uploadable/quadri/" + id + "/" + foto;
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Collezione getCollezione() {
		return collezione;
	}

	public void setCollezione(Collezione collezione) {
		this.collezione = collezione;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	 
	 
}
