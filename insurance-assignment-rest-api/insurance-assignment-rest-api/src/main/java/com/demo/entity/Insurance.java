
package com.demo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "insurance")
@EntityListeners(AuditingEntityListener.class)
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    
    private String insuranceCompany;

    
    private String insuranceType;

    
    private String insuranceValid;
    
    private long AnnualPremium;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getInsuranceValid() {
		return insuranceValid;
	}

	public void setInsuranceValid(String insuranceValid) {
		this.insuranceValid = insuranceValid;
	}

	public long getAnnualPremium() {
		return AnnualPremium;
	}

	public void setAnnualPremium(long AnnualPremium) {
		this.AnnualPremium = AnnualPremium;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", insuranceCompany=" + insuranceCompany + ", insuranceType=" + insuranceType
				+ ", insuranceValid=" + insuranceValid + ", AnnualPremium=" + AnnualPremium + "]";
	}



	

  
    


}
