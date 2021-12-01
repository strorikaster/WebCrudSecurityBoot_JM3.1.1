package com.webcrudsecurityboot.webcrudsecurityboot.repository;

import com.webcrudsecurityboot.webcrudsecurityboot.model.Role;
import com.webcrudsecurityboot.webcrudsecurityboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

    //@PersistenceContext
    @Autowired
    EntityManager entityManager;


    @SuppressWarnings("unchecked")
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    public Role show(Long id) {
        return entityManager.find(Role.class, id);
    }


    public void save(Role role) {
        entityManager.persist(role);
    }


    public void update(Role updatedRole) {
        entityManager.merge(updatedRole);
    }


    public void delete(Long id) {
        Role role = show(id);
        entityManager.remove(role);
    }
}

