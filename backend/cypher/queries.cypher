MATCH (m:Movie)-[:DIRECTED_BY]->(d:Person)                 // movies with&directors
RETURN
    m.title AS title,
    m.year AS year,
    d.name AS director,
    m.genre AS genre
ORDER BY m.year DESC;



MATCH (m:Movie {title: 'Inception'})-[:ACTED_IN]->(a:Person)                //actors for movies
RETURN
    m.title AS movie,
    a.name AS actor
ORDER BY a.name;



MATCH (m:Movie)-[:DIRECTED_BY]->(d:Person {name: 'Christopher Nolan'})                     //movies directed by director
RETURN
    m.title AS title,
    m.year AS year,
    m.genre AS genre;





MATCH (m:Movie)-[:ACTED_IN]->(a:Person)                  //movies with cast
RETURN
    m.title AS movie,
    collect(a.name) AS actors
ORDER BY m.title;







MATCH (m:Movie {title: 'Inception'})-[r]-(p:Person)                   //people --- movies
RETURN
    m.title AS movie,
    type(r) AS relationship,
    p.name AS person;





MATCH (m1:Movie), (m2:Movie)                         //movies ---- same genre
WHERE m1.genre = m2.genre
  AND m1.title < m2.title
RETURN
    m1.title AS movie1,
    m2.title AS movie2,
    m1.genre AS genre;