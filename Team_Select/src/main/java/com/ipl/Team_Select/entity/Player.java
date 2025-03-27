package com.ipl.Team_Select.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Jersey number is required")
    @Min(value = 1, message = "Jersey number must be at least 1")
    @Column(nullable = false)
    private Integer jerseyNumber;

    @NotBlank(message = "Role is required")
    @Pattern(regexp = "Batsman|Bowler|All-rounder|Wicket-keeper", message = "Role must be Batsman, Bowler, All-rounder, or Wicket-keeper")
    @Column(nullable = false)
    private String role;

    @NotBlank(message = "Nationality is required")
    @Column(nullable = false)
    private String nationality;

    @Min(value = 0, message = "Matches played cannot be negative")
    @Column(nullable = false)
    private Integer matchesPlayed;

    @Min(value = 0, message = "Runs scored cannot be negative")
    @Column(nullable = false)
    private Integer runsScored;

    @Min(value = 0, message = "Wickets taken cannot be negative")
    @Column(nullable = false)
    private Integer wicketsTaken;

    @NotBlank(message = "Batting style is required")
    @Column(nullable = false)
    private String battingStyle;

    @NotBlank(message = "Bowling style is required")
    @Column(nullable = false)
    private String bowlingStyle;
    
    @ManyToOne
    @JoinColumn(name = "tid")
    private Team team;
    
}
