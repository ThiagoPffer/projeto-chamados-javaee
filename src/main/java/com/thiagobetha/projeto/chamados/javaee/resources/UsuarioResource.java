package com.thiagobetha.projeto.chamados.javaee.resources;

import com.thiagobetha.projeto.chamados.javaee.data.Usuario;
import com.thiagobetha.projeto.chamados.javaee.enums.usuarios.Tipo;
import com.thiagobetha.projeto.chamados.javaee.infra.HibernateUtil;
import java.util.Date;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsuarioResource {
    // TODO Remover método temporario

    public static Usuario selecionarAluno() {
        Usuario aluno = (Usuario) HibernateUtil.getSessionFactory()
                .openSession()
                .createQuery("from Usuario where login = :login")
                .setString("login", "aluno")
                .uniqueResult();

        if (aluno == null) {
            aluno = new Usuario(
                    "aluno", 
                    DigestUtils.sha256Hex("123"), 
                    "Thiago Piffer", 
                    true, 
                    new Date(), 
                    Tipo.SUPORTE);

            UsuarioResource usuarioResource = new UsuarioResource();
            usuarioResource.inserir(aluno);
        }

        return aluno;
    }

    public Long inserir(Usuario usuario) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(usuario);
        t.commit();
        return usuario.getId();
    }

    public Usuario selecionar(long id) {
        return (Usuario) HibernateUtil.getSessionFactory()
                .openSession()
                .get(Usuario.class, id);
    }
}
