const API_URL = "/api/movies";

const movieGrid = document.getElementById("movie-grid");
const loading = document.getElementById("loading");
const error = document.getElementById("error");
const empty = document.getElementById("empty");
const movieCount = document.getElementById("movie-count");

async function loadMovies() {

    loading.classList.remove("hidden");
    error.classList.add("hidden");
    empty.classList.add("hidden");
    movieGrid.innerHTML = "";

    try {

        const response = await fetch(API_URL);

        if (!response.ok) {
            throw new Error("Failed to load movies");
        }

        const movies = await response.json();

        loading.classList.add("hidden");

        if (movies.length === 0) {
            empty.classList.remove("hidden");
            movieCount.textContent = "0 movies";
            return;
        }

        movieCount.textContent = `${movies.length} movie${movies.length === 1 ? "" : "s"}`;

        movies.forEach(movie => {

            const card = document.createElement("article");

            card.className = "movie-card";

            card.innerHTML = `<div class="movie-year">${movie.year}</div>
                                <h3>${movie.title}</h3>

                                <div class="movie-info">
                                    <div>
                                        <strong>Director:</strong>
                                        ${movie.director || "Unknown"}
                                    </div>

                                    <div>
                                        <strong>Genre:</strong>
                                        ${movie.genre || "Unknown"}
                                    </div>
                                </div>

                                <span class="genre">${movie.genre || "Movie"}</span>`;

            movieGrid.appendChild(card);
        });

    } catch (err) {

        loading.classList.add("hidden");
        error.classList.remove("hidden");

        console.error(err);
    }
}

loadMovies();