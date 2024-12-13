package com.msrapunzel;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class EntityRepository {
    @PersistenceContext(unitName = "JakartaEELocal")
    private EntityManager entityManager;

    @Transactional
    public Users create(Users entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Users findById(Long id) {
        return entityManager.find(Users.class, id);
    }

    public List<Users> getEntities() {
        return entityManager.createNamedQuery("Users.findAll", Users.class)
                .getResultList();
    }

    @Transactional
    public Users update(Users entity) {
        return entityManager.merge(entity);
    }

    @Transactional
    public void delete(Long id) {
        Users user = findById(id);
        if (user != null) {
            entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
        }
    }

}