package it.uniroma3.siw.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name = "artista")

public class Artista {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataDiNascita;
	@Column(nullable = false)
	private String luogoDiNascita;
	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataDiMorte;
	@Column
	private String luogoDiMorte;
	@Column
	private String nazionalita;
	
	@OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Quadro> quadri;
	
	@Column(nullable=true)
	private String ritratto;
	@Column(length=5096)
	private String biografia;

	 @Transient
	    public String getPhotosImagePath() {
	        if (ritratto.equals(null) || id.equals(null)) return null;
	         
	        return "/uploadable/artista-ritratto/" + id + "/" + ritratto;
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public LocalDate getDataDiMorte() {
		return dataDiMorte;
	}

	public void setDataDiMorte(LocalDate dataDiMorte) {
		this.dataDiMorte = dataDiMorte;
	}

	public String getLuogoDiMorte() {
		return luogoDiMorte;
	}

	public void setLuogoDiMorte(String luogoDiMorte) {
		this.luogoDiMorte = luogoDiMorte;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public List<Quadro> getQuadri() {
		return quadri;
	}

	public void setQuadri(List<Quadro> quadri) {
		this.quadri = quadri;
	}

	public String getRitratto() {
		return ritratto;
	}

	public void setRitratto(String ritratto) {
		this.ritratto = ritratto;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	 
	 
	 
	 
}
