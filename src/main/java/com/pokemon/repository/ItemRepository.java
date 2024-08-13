package com.pokemon.repository;

import com.pokemon.entities.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public class ItemRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List findByPagination(Pageable pageable, boolean conLimit){
        Query q = entityManager.createNativeQuery("SELECT * FROM item " +
                (
                        conLimit
                                ? " LIMIT " + ( pageable.getPageSize() *  pageable.getPageNumber()) + ", " + pageable.getPageSize() + ";"
                                : ""
                        ), Item.class);
        return q.getResultList();
    }



}
