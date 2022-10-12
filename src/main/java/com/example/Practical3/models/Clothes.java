package com.example.Practical3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Текст должен быть больше 1 символа")
    private String nazvanie;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Текст должен быть больше 1 символа")
    private String Size;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Текст должен быть больше 1 символа")
    private String TypeClothes;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Текст должен быть больше 1 символа")
    private String Ves;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 1, message = "Текст должен быть больше 1 символа")
    private String Tkan;
    private int views;


    public Clothes( String nazvanie, String Size, String TypeClothes, String Ves, String Tkan) {
        this.nazvanie = nazvanie;
        this.Size = Size;
        this.TypeClothes = TypeClothes;
        this.Ves = Ves;
        this.Tkan = Tkan;
    }

    public Clothes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getTypeClothes() {
        return TypeClothes;
    }

    public void setTypeClothes(String TypeClothes) {
        this.TypeClothes = TypeClothes;
    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public String getVes() {
        return Ves;
    }

    public void setVes(String Ves) {
        this.Ves = Ves;
    }

    public String getTkan() {
        return Tkan;
    }

    public void setTkan(String Tkan) {
        this.Tkan = Tkan;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
