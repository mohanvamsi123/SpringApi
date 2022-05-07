package com.accenture.lkm.entity;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="Cust_Payment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cust_Payment {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "Amount")
	private long Amount;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "created_at",updatable=true)
    @Temporal(TIMESTAMP)
    private Date transaction_date;
	

    
    @ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "Person_id", referencedColumnName = "U_id") 
    private Person person;
	
   

    
   
	
	

}
