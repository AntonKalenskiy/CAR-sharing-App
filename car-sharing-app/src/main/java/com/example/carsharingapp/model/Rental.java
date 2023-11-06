package com.example.carsharingapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
@Table(name = "rentals")
@SQLDelete(sql = "UPDATE rentals SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Rental {
    @Id
    @GeneratedValue(generator = "rental_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "rental_id_seq", sequenceName = "rental_id_seq", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private LocalDate actualReturnDate;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(nullable = false)
    private boolean isDeleted;
}
