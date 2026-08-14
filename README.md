# CineGraph

CineGraph is a graph-powered movie explorer built using Spring Boot, Neo4j/CognoDB, and a lightweight HTML/CSS/JavaScript frontend.

## Use Case

CineGraph allows users to explore movies and the people connected to them, such as directors and actors.

Instead of treating movies as isolated records, the application models movies and people as nodes and their relationships as graph connections.

## Why a Graph Database?

A graph database is useful for CineGraph because movies naturally contain relationships.

For example:

Movie → DIRECTED_BY → Person

Movie → ACTED_IN → Person

This makes relationship-based queries easier to express and extend as the application grows.

## Technology Stack

### Backend
- Java 21
- Spring Boot
- Maven
- Neo4j Java Driver

### Database
- CognoDB / Neo4j-compatible graph database
- Cypher

### Frontend
- HTML
- CSS
- JavaScript

## Graph Data Model

### Nodes

- `Movie`
  - title
  - year
  - genre

- `Person`
  - name

### Relationships

- `Movie -[:DIRECTED_BY]-> Person`
- `Movie -[:ACTED_IN]-> Person`

Example:

```text
Christopher Nolan
       ↑
       │ DIRECTED_BY
       │
   Inception
       │
       │ ACTED_IN
       ↓
Leonardo DiCaprio