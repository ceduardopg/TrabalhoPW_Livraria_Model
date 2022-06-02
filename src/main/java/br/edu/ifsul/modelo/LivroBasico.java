package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Carlos
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "livro_basico")
public class LivroBasico implements Serializable{
    
    @Id
    @NotBlank(message = "O ISBN deve ser informado")
    @Length(max = 13, message = "O ISBN não pode ter mais que {max} caracteres")
    @Column(name = "isbn", length = 13, nullable = false)
    private String isbn;
    
    @NotBlank(message = "O titulo não pode ser em branco")
    @Length(max = 50, message = "O titulo não pode ter mais que {max} caracteres")
    @Column(name = "titulo", length = 50, nullable = false) 
    private String titulo;
    
    @NotBlank(message = "O resumo não pode ser em branco")
    @Length(max = 200, message = "O resumo não pode ter mais que {max} caracteres")
    @Column(name = "resumo", length = 200, nullable = false) 
    private String resumo;
    
    @NotBlank(message = "A editora não pode ser em branco")
    @Length(max = 50, message = "A editora não pode ter mais que {max} caracteres")
    @Column(name = "editora", length = 50, nullable = false) 
    private String editora;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de publicação deve ser informada")
    @Column(name = "data_publicacao", nullable = false)
    private Calendar dataPublicacao;
    
    @ManyToMany
    @JoinTable(name = "livro_autor",
            // se refere a classe usuário
            joinColumns = 
                    @JoinColumn(name = "isbn", referencedColumnName = "isbn", 
                            nullable = false),
            // se refere ao tipo da lista <Permissao>
            inverseJoinColumns = 
                    @JoinColumn(name = "autor", referencedColumnName = "id", 
                            nullable = false)
            )            
    private Set<Autor> autores = new HashSet<>();
    
    public LivroBasico(){
        
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String Isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.isbn);
        return hash;
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
        final LivroBasico other = (LivroBasico) obj;
        return Objects.equals(this.isbn, other.isbn);
    }
    
    
}
