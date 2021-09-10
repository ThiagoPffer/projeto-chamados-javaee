package com.thiagobetha.projeto.chamados.javaee.resources;

import com.thiagobetha.projeto.chamados.javaee.data.Chamado;
import com.thiagobetha.projeto.chamados.javaee.enums.chamados.Status;
import com.thiagobetha.projeto.chamados.javaee.enums.chamados.Tipo;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
@Transactional
public class ChamadoResource {
    
    @PersistenceContext
    private EntityManager em;

    public Long inserir(Chamado chamado) {
        chamado.setDataRegistro(new Date());
        chamado.setStatus(Status.NOVO);
        chamado.setTipo(Tipo.SOLICITACAO);
        chamado.setUsuario(UsuarioResource.selecionarAluno());
        chamado.setUsuarioStatus(UsuarioResource.selecionarAluno());

        em.persist(chamado);
        return chamado.getId();
    }

    public void alterar(Chamado chamado) {
        em.merge(chamado);
    }

    public void excluir(long id) {
        Chamado c = selecionar(id);

        em.remove(c);
    }

    public Chamado selecionar(long id) {
        return em.find(Chamado.class, id);
    }

    public List<Chamado> listar() {
        return em.createQuery("SELECT c FROM chamado c", Chamado.class).getResultList();
    }
}