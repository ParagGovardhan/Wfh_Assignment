
package com.demo.controller;

import com.demo.entity.Insurance;
import com.demo.exception.ResourceNotFoundException;
import com.demo.exception.TypeMismatchException;
import com.demo.repos.InsuranceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class InsuranceController {

	@Autowired
	private InsuranceRepository InsuranceRepository;

	@GetMapping("/insurance")
	public List<Insurance> getAllInsurance() {
		return InsuranceRepository.findAll();
	}

	@GetMapping("/insurance/{id}")
	  public <T> ResponseEntity<Insurance> getInsuranceProvidersById(@PathVariable(value = "id") T insuranceId)
	      throws ResourceNotFoundException,TypeMismatchException,Exception {
	      long id;
	      String value;
	      value=(String) insuranceId;
	      try{
	          id=Long.parseLong(value);
	      }catch(Exception e) {
	          throw new TypeMismatchException("Data Type Mismatch on the given ID");
	      }
	           Insurance insurance =
	                        InsuranceRepository
	                      .findById(id)
	                      .orElseThrow(() -> new ResourceNotFoundException("Insurance Provider not found on :: " + id));
	              return ResponseEntity.ok().body(insurance);
	                 
	     
	  }
	@PostMapping("/insurance")
	public Insurance createUser(@Valid @RequestBody Insurance insurance) {
		return InsuranceRepository.save(insurance);
	}

	@PutMapping("/insurance/{id}")
	public ResponseEntity<Insurance> updateUser(@PathVariable(value = "id") Long insuranceId,
			@Valid @RequestBody Insurance userDetails) throws ResourceNotFoundException {

		Insurance insurance = InsuranceRepository.findById(insuranceId)
				.orElseThrow(() -> new ResourceNotFoundException("Insurance not found on :: " + insuranceId));

		insurance.setInsuranceValid(userDetails.getInsuranceValid());
		insurance.setInsuranceType(userDetails.getInsuranceType());
		insurance.setInsuranceCompany(userDetails.getInsuranceCompany());
		insurance.setAnnualPremium(userDetails.getAnnualPremium());
		final Insurance updatedInsurance = InsuranceRepository.save(insurance);
		return ResponseEntity.ok(updatedInsurance);
	}

	@DeleteMapping("/insurance/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long insuranceId) throws Exception {
		Insurance insurance = InsuranceRepository.findById(insuranceId)
				.orElseThrow(() -> new ResourceNotFoundException("Insurance not found on :: " + insuranceId));

		InsuranceRepository.delete(insurance);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
