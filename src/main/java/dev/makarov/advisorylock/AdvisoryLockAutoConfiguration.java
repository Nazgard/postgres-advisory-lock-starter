package dev.makarov.advisorylock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class AdvisoryLockAutoConfiguration {

    private final EntityManager em;

    public AdvisoryLockAutoConfiguration(EntityManager em) {
        this.em = em;
    }

    @Bean
    public AdvisoryLockService advisoryLockService() {
        return new AdvisoryLockServiceImpl(em);
    }

}
