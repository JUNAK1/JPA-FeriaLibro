package com.uptc.frw.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORIY;
    static {
        ENTITY_MANAGER_FACTORIY = Persistence.createEntityManagerFactory("feria");

    }
    public static EntityManager getEntityManager(){
        return ENTITY_MANAGER_FACTORIY.createEntityManager();
    }
}
