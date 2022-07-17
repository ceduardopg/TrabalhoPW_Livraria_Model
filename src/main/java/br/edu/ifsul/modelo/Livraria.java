package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "livraria")
public class Livraria implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_livraria", sequenceName = "seq_livraria_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_livraria", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false) 
    private String nome;
    
    @NotBlank(message = "O site não pode ser em branco")
    @Length(max = 50, message = "O site não pode ter mais que {max} caracteres")
    @Column(name = "site", length = 50, nullable = false) 
    private String site;
    
    @OneToMany(mappedBy = "livraria", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Catalogo> catalogos = new ArrayList<>();
    
    public Livraria(){
        
    }
    
    public void adicionarCatalogo(Catalogo obj){
        obj.setLivraria(this);
        this.getCatalogos().add(obj);
    }
    
    public void removerCatalogo(int index){
        this.catalogos.remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    public List<Catalogo> getCatalogos() {
        return catalogos;
    }

    public void setCatalogos(List<Catalogo> catalogos) {
        this.catalogos = catalogos;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livraria other = (Livraria) obj;
        return Objects.equals(this.id, other.id);
    }

    
    
    
}
