package com.example.AniDaze.Controllers;

import com.example.AniDaze.Anime;
import com.example.AniDaze.Repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AnimeController {

    @Autowired
    AnimeRepository animeRepository;

    @GetMapping(value = "/animes")
    public ResponseEntity<List<Anime>> getAllAnimes(){
        return new ResponseEntity<>(animeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/animes/{id}")
    public ResponseEntity getAnime(@PathVariable Long id){
        return new ResponseEntity<>(animeRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/animes/search/{title}")
    public  ResponseEntity<List<Anime>> getAnimesByTitle(@PathVariable String title){
        return new ResponseEntity<>(animeRepository.findByTitleContainingIgnoreCase(title), HttpStatus.OK);
    }

    @GetMapping(value = "/animes/search/dates")
    public ResponseEntity<List<Anime>> getAnimesByDates(@RequestParam String start, @RequestParam String end){
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return new ResponseEntity<>(animeRepository.findAnimesBetweenDates(startDate, endDate), HttpStatus.OK);
    }
    @PostMapping(value="/animes")
    public ResponseEntity<Anime> postAnime(@RequestBody Anime anime){
        animeRepository.save(anime);
        return new ResponseEntity<>(anime, HttpStatus.CREATED);
    }

}
