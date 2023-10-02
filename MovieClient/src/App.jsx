import { useEffect, useState } from "react";
import api from "./api/axiosConfig";

const App = () => {
  const [movies, setMovie] = useState([]);

  //Get Request
  const getMovies = async () => {
    try {
      const response = await api.get("/api/v1/movies");
      console.log(response.data);
      setMovie(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    getMovies();
  }, []);

  return (
    <>
      <div className="container mt-5 text-center">
        <div className="title">
          {movies.map((movie) => {
            return (
              <div key={movie.id} className="my-5">
                <h1>{movie.title}</h1>
                <img src={movie.poster} alt="" />
                <p>Release Date: {movie.releaseDate}</p>
                <p>
                  Genres:
                  {movie.genres.map((g) => (
                    <span key={g.id}>
                      {""} {g} {""}
                    </span>
                  ))}
                </p>
                <h4>
                  Reviews
                  {movie.reviewIds.map((review) => (
                    <h5 key={review}>{review.body}</h5>
                  ))}
                </h4>
              </div>
            );
          })}
        </div>
      </div>
    </>
  );
};

export default App;
