package org.opens.kbaccess.entity.dao.reference;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.opens.kbaccess.entity.reference.Level;
import org.opens.kbaccess.entity.reference.LevelImpl;
import org.opens.tanaguru.sdk.entity.dao.jpa.AbstractJPADAO;

public class LevelDAOImpl extends AbstractJPADAO<Level, Long> implements
        LevelDAO {

    public LevelDAOImpl() {
        super();
    }

    @Override
    protected Class<LevelImpl> getEntityClass() {
        return LevelImpl.class;
    }

    @Override
    public Level findByCode(String code) {
        try {
            Query query = entityManager.createQuery("SELECT n FROM "
                    + getEntityClass().getName() + " n" + " WHERE n.code = :code");
            query.setParameter("code", code);
            return (Level) query.getSingleResult();
        } catch (NoResultException e) {
            // In case of query with no result, return null
            return null;
        }
    }

}
