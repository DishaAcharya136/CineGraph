package com.cinegraph.backend.repository;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.stereotype.Repository;

@Repository
public class CognoDBRepository{

    private final Driver driver;

    public CognoDBRepository(Driver driver){
        this.driver = driver;
    }

    public String testConnection(){
        try (Session session = driver.session()) {
            return session.executeRead(tx ->
                    tx.run("RETURN 'CognoDB connection successful' AS message")
                            .single()
                            .get("message")
                            .asString()
            );
        }
    }
}