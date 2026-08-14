# CineGraph Graph Data Model

## Overview

CineGraph uses a graph data model to represent movies and the people connected to them.

## Nodes

### Movie

Properties:

- `title`
- `year`
- `genre`

### Person

Properties:

- `name`

## Relationships

```text
(Movie) ── DIRECTED_BY ──> (Person)
(Movie) ── ACTED_IN ─────> (Person)
```

## Example Graph

```text
                   DIRECTED_BY
Christopher Nolan <────────── Inception
                                  │
                                  │ ACTED_IN
                                  ↓
                         Leonardo DiCaprio


                  DIRECTED_BY
Denis Villeneuve <────────── Dune
                                  │
                                  │ ACTED_IN
                                  ↓
                           Timothée Chalamet


                    DIRECTED_BY
Bong Joon Ho <──────────── Parasite
                                  │
                                  │ ACTED_IN
                                  ↓
                            Song Kang-ho
```

## Cypher Representation

```text
(:Movie)-[:DIRECTED_BY]->(:Person)

(:Movie)-[:ACTED_IN]->(:Person)
```

## Why This Model?

The graph model represents relationships between movies and people directly.

This makes relationship-based queries such as finding a movie's director, finding its actors, or finding movies connected to the same person easier to express using Cypher.