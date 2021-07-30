package dev.makarov.advisorylock;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

public class AdvisoryLockServiceImpl implements AdvisoryLockService {

    private static final String BLOCKING_QUERY_TXT = "SELECT count(*) FROM pg_advisory_xact_lock( :lockId )";

    private final EntityManager em;

    public AdvisoryLockServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional(value = Transactional.TxType.MANDATORY)
    public void transactionalLock(Long lockId) {
        // using transaction-level lock, which is released automatically at the end of the transaction
        Query query = em.createNativeQuery(BLOCKING_QUERY_TXT);
        query.setParameter("lockId", lockId);
        query.getSingleResult();
    }
}
