/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author Josieli
 */
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import javax.persistence.*;
import model.*;

public class PersistenciaJPA implements InterfaceBD {

    private EntityManager entity;
    private EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("pu-south-shop");
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        return entity != null && entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        if (entity != null && entity.isOpen()) {
            entity.close();
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        return getEntityManager().find(c, id);
    }

    @Override
    public void persist(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o);
            }
            entity.persist(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE,
                    "Erro ao persistir: " + o.getClass().getSimpleName(), e);
            throw e;
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o);
            }
            entity.remove(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE,
                    "Erro ao remover: " + o.getClass().getSimpleName(), e);
            throw e;
        }
    }

    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    public List<Usuario> getUsuarios() {
        entity = getEntityManager();
        try {
            TypedQuery<Usuario> query = entity.createQuery("SELECT c FROM Usuario c", Usuario.class);
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao buscar Usuarios", e);
            return null;
        }
    }

    public List<Produto> getProdutos() {
        entity = getEntityManager();
        try {
            TypedQuery<Produto> query = entity.createQuery("SELECT p FROM Produto p", Produto.class);
            List<Produto> lista = query.getResultList();
            return (lista != null) ? lista : new ArrayList<>();
        } catch (Exception e) {
            Logger.getLogger(PersistenciaJPA.class.getName()).log(Level.SEVERE, "Erro ao buscar produtos", e);
            return new ArrayList<>();
        }
    }

    public Usuario buscarUsuarioPorEmailESenha(String email, String senha) {
        EntityManager em = getEntityManager();
        TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Usuario.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        return query.getSingleResult();
    }

    public Carrinho buscarCarrinhoPorUsuario(Usuario usuario) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Carrinho c WHERE c.usuario = :usuario", Carrinho.class)
                    .setParameter("usuario", usuario)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
