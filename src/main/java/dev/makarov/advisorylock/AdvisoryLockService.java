package dev.makarov.advisorylock;

public interface AdvisoryLockService {

    void transactionalLock(Long lockId);

}
