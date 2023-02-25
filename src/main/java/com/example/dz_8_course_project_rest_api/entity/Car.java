package com.example.dz_8_course_project_rest_api.entity;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
//import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model")
    private String modelName;

    @Column(name = "vin")
    private String vinNumber;

    @Column(name = "license_number")
    private String licenseNumber;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "brand_id")
    @JsonIgnore
    private Brand brand;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "car")
    private List<Order> orderList = new ArrayList<>();

    public Car() {
    }

    public Car(Car car) {
        this.id = car.id;
    }

    public Car(String modelName, String vinNumber, String licenseNumber) {
        this.modelName = modelName;
        this.vinNumber = vinNumber;
        this.licenseNumber = licenseNumber;
    }

    public int getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    //@JsonBackReference
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    //@JsonManagedReference
    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", vinNumber='" + vinNumber + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", brand=" + brand.getBrandName() +
                '}';
    }

    public void addOrder(Order order){
        orderList.add(order);
        order.setCar(this);
    }
}
