package com.example.AniDaze.Repositories;

import com.example.AniDaze.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
    List<Anime> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT m FROM Anime m WHERE m.release BETWEEN :start AND :end")
    List<Anime> findAnimesBetweenDates(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
