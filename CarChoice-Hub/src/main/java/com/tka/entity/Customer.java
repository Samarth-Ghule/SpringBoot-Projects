package com.tka.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String fullName;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = true)
	private String phoneNumber;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String pinCode;

	@Column(nullable = false)
	private LocalDate enquiryDate;

	@Column(nullable = false)
	private String paymentMethod;

	private String testDriveInterest;

	private LocalDate testDriveDate;

	private String testDriveResult;

	@Column(nullable = false)
	private Double downPaymentAmount;

	@Column(nullable = false)
	private String loanProvider;

	@Column(nullable = false)
	private String loanApprovalStatus;

	private Double monthlyInstallmentBudget;

	private String customerCategory;

	@ManyToOne
	@JoinColumn(name = "cid")
	private Car car;

}
