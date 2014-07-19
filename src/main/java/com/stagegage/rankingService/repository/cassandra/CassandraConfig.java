package com.stagegage.rankingService.repository.cassandra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.CqlTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;

@Configuration
@PropertySource(value = { "classpath:cassandra.properties" })
public class CassandraConfig extends AbstractCassandraConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(com.stagegage.services.repository.cassandra.CassandraConfig.class);

    @Autowired
    private Environment env;


    @Bean
    public CqlTemplate CqlTemplate() {
        try {
            return new CqlTemplate(session().getObject());
        } catch (Exception e) {
            LOG.error("Could not get cassandra session");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected String getKeyspaceName() {
        return env.getProperty("cassandra.keyspace");
    }
}
