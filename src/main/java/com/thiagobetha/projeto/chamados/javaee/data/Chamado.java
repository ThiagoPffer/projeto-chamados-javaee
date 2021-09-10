package com.thiagobetha.projeto.chamados.javaee.data;

import com.thiagobetha.projeto.chamados.javaee.enums.chamados.Status;
import com.thiagobetha.projeto.chamados.javaee.enums.chamados.Tipo;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Chamado implements Serializable{
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_registro", nullable = false, updatable = false)
    private LocalDateTime dataRegistro;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 16, nullable = false)
    private Tipo tipo;
    
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Usuario usuario;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_status", nullable = false)
    private Usuario usuarioStatus;
    
    @Column(length = 64, nullable = false)
    private String assunto;
    
    @Column(length = 2048, nullable = false)
    private String mensagem;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 8, nullable = false)
    private Status status;

    public Chamado() {
    }
    
    public Chamado(String assunto, String mensagem, Status status) {
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioStatus() {
        return usuarioStatus;
    }

    public void setUsuarioStatus(Usuario usuarioStatus) {
        this.usuarioStatus = usuarioStatus;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Chamado other = (Chamado) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chamado{" + "id=" + id + ", dataRegistro=" + dataRegistro + ", tipo=" + tipo + ", usuario=" + usuario + ", usuarioStatus=" + usuarioStatus + ", assunto=" + assunto + ", mensagem=" + mensagem + ", status=" + status + '}';
    }
    
}
