package com.example.dz_8_course_project_rest_api.entity;

//import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
//import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "price")
    private int servicePrice;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "service")
    private List<Order> orderList = new ArrayList<>();

    public Service() {
    }

    public Service(Service service) {
        this.id = service.getId();
    }

    public Service(String serviceName, int servicePrice) {
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
    }

    public int getId() {
        return id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    //@JsonManagedReference
    public List<Order> getOrderList() {
        return orderList;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", servicePrice=" + servicePrice +
                '}';
    }

    public void addOrder(Order order){
        orderList.add(order);
        order.setService(this);
    }
}
