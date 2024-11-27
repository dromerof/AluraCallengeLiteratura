package com.alura.callenge.literatura.model;

import jakarta.persistence.*;


@Entity
@Table(name = "books")
public class LibroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(name = "download_count")
    private Integer downloadCount;

    private String languages;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AutorEntity author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public AutorEntity getAuthor() {
        return author;
    }

    public void setAuthor(AutorEntity author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "---------Libro --------------\n" +
                "Titulo: " + title + '\n' +
                "Descargas: " + downloadCount + '\n' +
                "Lenguaje: " + languages + '\n' +
                "Autor: " + author.getName() + '\n' +
                "------------------------------\n";
    }
}
