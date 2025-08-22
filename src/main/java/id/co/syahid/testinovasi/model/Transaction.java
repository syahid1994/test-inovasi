package id.co.syahid.testinovasi.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "transaction_id")
	private String transactionID;
	
	@Column(name = "product_id")
	private String productID;
	
	@Column(name = "product_name")
	private String productName;

	@Column(name = "amount")
	private Long amount;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "transaction_date")
	private Date transactionDate;
	
	@Column(name = "create_by")
	private String createBy;
	
	@Column(name = "create_on")
	private Date createOn;
}
