package com.test.aprendizado.model.error;

public class ErroMenssage {

    private String titulo;

    private String status;

    private String menssage;

    

    public ErroMenssage(String titulo, String status, String menssage) {
        this.titulo = titulo;
        this.status = status;
        this.menssage = menssage;
    }

    public ErroMenssage(String titulo2, int value, String message) {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }
    
}
