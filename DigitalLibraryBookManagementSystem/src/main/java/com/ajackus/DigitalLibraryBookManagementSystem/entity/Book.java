package com.ajackus.DigitalLibraryBookManagementSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Title cannot be blank")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Author cannot be blank")
    private String author;

    private String genre;

    @Pattern(regexp = "Available|Checked Out", message = "Availability Status must be 'Available' or 'Checked Out'")
    private String availabilityStatus;

}
