//package com.example.carsharingapp.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import org.hibernate.annotations.SQLDelete;
//import org.hibernate.annotations.Where;
//
//import java.math.BigDecimal;
//import java.net.URL;
//
//@Data
//@Entity
//@Table(name = "payments")
//@SQLDelete(sql = "UPDATE payments SET is_deleted = true WHERE id = ?")
//@Where(clause = "is_deleted = false")
//public class Payment {
//    @Id
//    @GeneratedValue(generator = "payment_id_seq", strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name = "payment_id_seq", sequenceName = "payment_id_seq", allocationSize = 1)
//    private Long id;
//    private Status status;
//    private Type type;
//    private Rental rental;
//    private URL sessionURL;
//    private String sessionId;
//    private BigDecimal rentalPrice;
//
//    public enum Status {
//        PENDING, PAID
//    }
//    public enum Type {
//        PAYMENT, FINE
//    }
//}
