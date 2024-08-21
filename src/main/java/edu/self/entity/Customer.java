package edu.self.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_customer")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer {

	public Customer(String firstName, String lastName, String email, Date insertDate, String insertName, Date updateDate, String updateName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.insertDate = insertDate;
		this.insertName = insertName;
		this.updateDate = updateDate;
		this.updateName = updateName; 
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", nullable=false)
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "int_date")
	private Date insertDate;

	@Column(name = "int_name")
	private String insertName;
	
	@Column(name = "upd_date")
	private Date updateDate;

	@Column(name = "upd_name")
	private String updateName;
}
