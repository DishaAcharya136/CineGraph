CREATE
(d1:Person {name: 'Christopher Nolan'}),
(d2:Person {name: 'Denis Villeneuve'}),
(d3:Person {name: 'Bong Joon Ho'}),

(a1:Person {name: 'Leonardo DiCaprio'}),
(a2:Person {name: 'Joseph Gordon-Levitt'}),
(a3:Person {name: 'Timothée Chalamet'}),
(a4:Person {name: 'Rebecca Ferguson'}),
(a5:Person {name: 'Song Kang-ho'}),
(a6:Person {name: 'Choi Woo-shik'}),

(m1:Movie {
    title: 'Inception',
    year: 2010,
    genre: 'Sci-Fi'
}),

(m2:Movie {
    title: 'Dune',
    year: 2021,
    genre: 'Sci-Fi'
}),

(m3:Movie {
    title: 'Parasite',
    year: 2019,
    genre: 'Thriller'
}),

(m1)-[:DIRECTED_BY]->(d1),
(m1)-[:ACTED_IN]->(a1),
(m1)-[:ACTED_IN]->(a2),

(m2)-[:DIRECTED_BY]->(d2),
(m2)-[:ACTED_IN]->(a3),
(m2)-[:ACTED_IN]->(a4),

(m3)-[:DIRECTED_BY]->(d3),
(m3)-[:ACTED_IN]->(a5),
(m3)-[:ACTED_IN]->(a6);