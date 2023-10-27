package com.example.carsharingapp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "cars")
@SQLDelete(sql = "UPDATE cars SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Car {
    @Id
    @GeneratedValue(generator = "car_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "car_id_seq", sequenceName = "car_id_seq", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String brand;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarType type;
    @Column(nullable = false)
    private int inventory;
    private BigDecimal dailyFee;
    @Column(nullable = false)
    private boolean isDeleted;

    public enum CarType {
        SEDAN, SUV, HATCHBACK, UNIVERSAL
    }
}
