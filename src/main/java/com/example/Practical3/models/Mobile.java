package com.example.Practical3.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 5, message = "Текст должен быть больше 5 символов")
    private String modelsTel;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 5, message = "Текст должен быть больше 5 символов")
    private String number;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 5, message = "Текст должен быть больше 5 символов")
    private String memory;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 5, message = "Текст должен быть больше 5 символов")
    private String memoryGB;
    @NotBlank(message = "Поле не должно быть пустым")
    @Size(min = 5, message = "Текст должен быть больше 5 символов")
    private String operator;
    private int views;


    public Mobile(String modelsTel, String number, String memory, String memoryGB, String operator) {
        this.modelsTel = modelsTel;
        this.number = number;
        this.memory = memory;
        this.memoryGB = memoryGB;
        this.operator = operator;
    }

    public Mobile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelsTel() {
        return modelsTel;
    }

    public void setModelsTel(String modelsTel) {
        this.modelsTel = modelsTel;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMemoryGB() {
        return memoryGB;
    }

    public void setMemoryGB(String memoryGB) {
        this.memoryGB = memoryGB;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
