package com.codingdojo.pokebook.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pokebook")
public class Pokebook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 1, max = 200, message="Expense cannot be blank")
	private String expense;
	@NotNull
	@Size(min = 1, max = 200, message="Vendor cannot be blank")
	private String vendor;
	@NotNull
	@Range(min = 1, message="Must be greater than $0")
	private Double amount;
	@NotNull
	@Size(min = 1, max = 200, message="Description cannot be blank")
	private String description;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	public Pokebook() {
		
	}
	
	public Pokebook( @NotNull @Size(min = 1, max = 200, message = "Expense cannot be blank") String expense,
			@NotNull @Size(min = 1, max = 200, message = "Vendor cannot be blank") String vendor,
			@NotNull @Range(min = 1, message = "Must be greater than $0") Double amount,
			@NotNull @Size(min = 1, max = 200, message = "Description cannot be blank") String description,
			Date createdAt, Date updatedAt) {
		super();
//		this.id = id;
		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist 
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
