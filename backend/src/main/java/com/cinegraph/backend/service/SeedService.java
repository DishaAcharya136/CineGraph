package com.cinegraph.backend.service;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.stereotype.Service;

@Service
public class SeedService{

    private final Driver driver;

    public SeedService(Driver driver){
        this.driver = driver;
    }

    public String seedDatabase(){

        try (Session session = driver.session()){

            session.executeWrite(tx -> {

                tx.run("MATCH (n) DETACH DELETE n").consume();

                tx.run("""
                    CREATE
                    (nolan:Person {name: 'Christopher Nolan'}),
                    (villeneuve:Person {name: 'Denis Villeneuve'}),
                    (bong:Person {name: 'Bong Joon Ho'}),

                    (dicaprio:Person {name: 'Leonardo DiCaprio'}),
                    (gordon:Person {name: 'Joseph Gordon-Levitt'}),
                    (chalamet:Person {name: 'Timothée Chalamet'}),
                    (ferguson:Person {name: 'Rebecca Ferguson'}),
                    (song:Person {name: 'Song Kang-ho'}),
                    (choi:Person {name: 'Choi Woo-shik'}),

                    (inception:Movie {
                        title: 'Inception',
                        year: 2010,
                        genre: 'Sci-Fi'
                    }),

                    (dune:Movie {
                        title: 'Dune',
                        year: 2021,
                        genre: 'Sci-Fi'
                    }),

                    (parasite:Movie {
                        title: 'Parasite',
                        year: 2019,
                        genre: 'Thriller'
                    }),

                    (inception)-[:DIRECTED_BY]->(nolan),
                    (inception)-[:ACTED_IN]->(dicaprio),
                    (inception)-[:ACTED_IN]->(gordon),

                    (dune)-[:DIRECTED_BY]->(villeneuve),
                    (dune)-[:ACTED_IN]->(chalamet),
                    (dune)-[:ACTED_IN]->(ferguson),

                    (parasite)-[:DIRECTED_BY]->(bong),
                    (parasite)-[:ACTED_IN]->(song),
                    (parasite)-[:ACTED_IN]->(choi)
                """).consume();

                return null;
            });

            return "Database seeded successfully";
        }
    }
}