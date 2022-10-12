package com.example.Practical3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Beauty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Текст должен быть больше 1 символа")
    private String nazvanie;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Текст должен быть больше 1 символа")
    private String Sostav;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Текст должен быть больше 1 символа")
    private String kolwo;

    private int views;


    public Beauty( String nazvanie, String Sostav, String TypeClothes) {
        this.nazvanie = nazvanie;
        this.Sostav = Sostav;
        this.kolwo = kolwo;
    }

    public Beauty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public String getSostav() {
        return Sostav;
    }

    public void setSostav(String Sostav) {
        this.Sostav = Sostav;
    }

    public String getKolwo() {
        return kolwo;
    }

    public void setKolwo(String kolwo) {
        this.kolwo = kolwo;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}