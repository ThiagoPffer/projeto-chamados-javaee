package com.thiagobetha.projeto.chamados.javaee.data;

public class Chamado {
    
    private long id;
    private String assunto;
    private String mensagem;
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
        hash = 73 * hash + (int) (this.id ^ (this.id >>> 32));
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
    
}
