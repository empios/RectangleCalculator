package pl.wlodarczyk.kolokwium.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Retangle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int height;
    private int width;

    public Retangle() {
    }

    public Retangle(int height, int width){
        this.height = height;
        this.width = width;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int circute(int height, int width){
        this.height = height;
        this.width = width;
        return 2* height + 2*width;
    }
}
