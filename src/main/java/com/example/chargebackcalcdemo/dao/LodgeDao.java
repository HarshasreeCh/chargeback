package com.example.chargebackcalcdemo.dao;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.chargebackcalcdemo.models.LodgeComplaint;

public interface LodgeDao extends CrudRepository<LodgeComplaint, String> {
	 
	public LodgeComplaint findByBankaccountnumber(String bankaccountnumber);
	public  LodgeComplaint findBycustomerid(long customerId); 
    @Query("select customerid from LodgeComplaint")
	public Set<Long> getAllCutomerIds();
    public List<LodgeComplaint> findAll();
    public LodgeComplaint findBytransactionid(String tid);


}
