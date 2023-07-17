package com.example.AniDaze;


import javax.persistence.*;

@Entity
@Table(name="animes")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long Id;

    @Column(name="title", nullable = true)
    private String title;

    @Column(name="overview", nullable = true)
    private String overview;

    @Column(name="release", nullable = true)
    private String release;

    @Column(name="poster", nullable = true)
    private String poster;

    @Column(name="backdrop", nullable = true)
    private String backdrop;

    public Anime(String title, String overview, String release, String poster, String backdrop) {
        this.title = title;
        this.overview = overview;
        this.release = release;
        this.poster = poster;
        this.backdrop = backdrop;
    }

    public Anime(){
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }
}
