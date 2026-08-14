package com.cinegraph.backend.service;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.Record;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MovieService{

    private final Driver driver;

    public MovieService(Driver driver){
        this.driver = driver;
    }

    public List<Map<String, Object>> getMovies(){

        try (Session session = driver.session()){

            return session.executeRead(tx ->
                    tx.run("""
                        MATCH (m:Movie)
                        OPTIONAL MATCH (m)-[:DIRECTED_BY]->(d:Person)
                        OPTIONAL MATCH (m)-[:ACTED_IN]->(a:Person)
                        RETURN m, d, collect(a) AS actors
                        ORDER BY m.title
                    """)
                    .list(this::mapMovie)
            );
        }
    }

    private Map<String, Object> mapMovie(Record record){

        var movie = record.get("m").asNode();
        var director = record.get("d");

        return Map.of(
                "title", movie.get("title").asString(),
                "year", movie.get("year").asInt(),
                "genre", movie.get("genre").asString(),
                "director", director.isNull()
                        ? ""
                        : director.asNode().get("name").asString()
        );
    }
}