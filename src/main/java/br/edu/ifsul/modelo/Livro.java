package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "livro")
public class Livro extends LivroBasico implements Serializable{
    
    @NotBlank(message = "O codigo de barras deve ser informado")
    @Length(max = 50, message = "O codigo de barras não pode ter mais que {max} caracteres")
    @Column(name = "codigo_barras", length = 50, nullable = false) 
    private String codigoBarras;
    
    @NotNull(message = "O número de paginas deve ser informado")
    @Column(name = "numero_paginas", length = 10, nullable = false) 
    private Integer numeroPaginas;
    
    @NotNull(message = "O campo ativo deve ser informado")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de cadastro deve ser informada")
    @Column(name = "data_cadastro", nullable = false)
    private Calendar dataCadastro;
    
    @Min(value = 0, message = "O valor não pode ser negativo")
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(4,2)") 
    private Double valor;
    
    @NotNull(message = "O formato deve ser informado")
    @ManyToOne
    @JoinColumn(name = "formato_id", referencedColumnName = "id", nullable = false) 
    private Formato formato;
    
    @NotNull(message = "O idioma deve ser informado")
    @ManyToOne
    @JoinColumn(name = "idioma_id", referencedColumnName = "id", nullable = false) 
    private Idioma idioma;
    
    @ManyToOne
    @JoinColumn(name = "catalogo_id", referencedColumnName = "id", nullable = false)    
    private Catalogo catalogo;
    
    public Livro(){
        
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.codigoBarras);
        return hash;
    }
    
    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
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
        final Livro other = (Livro) obj;
        return Objects.equals(this.codigoBarras, other.codigoBarras);
    }
    
}
