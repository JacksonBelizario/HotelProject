/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelProject.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Jackson
 */

@Entity
@Table(name = "funcionario")
public class Funcionario implements AbstractEntity, Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo", unique=true, nullable = false)
    private Integer id;
    
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;
    
    @Column(name = "endereco", nullable = true, length = 255)
    private String endereco;
    
    @Column(name = "cidade", nullable = true, length = 255)
    private String cidade;
    
    @Column(name = "estado", nullable = true, length = 255)
    private String estado;
    
    @Column(name = "telefone", nullable = true, length = 255)
    private String telefone;


    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}