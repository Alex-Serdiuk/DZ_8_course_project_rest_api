package com.example.dz_8_course_project_rest_api.entity;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

//import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="brands")
public class Brand {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String brandName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "country_id")
    @JsonIgnore
    private Country country;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "brand")
    private List<Car> cars = new ArrayList<>();

    public Brand() {
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public int getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    //@JsonBackReference
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    //@JsonManagedReference
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                '}';
    }

    public void addCar(Car car){
        cars.add(car);
        car.setBrand(this);
    }
}
