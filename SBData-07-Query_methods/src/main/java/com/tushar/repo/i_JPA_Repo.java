package com.tushar.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.tushar.entity.Vaccines;


public interface i_JPA_Repo extends JpaRepository<Vaccines, Long> {
	
	@Query("FROM Vaccines WHERE price>=:min  AND price<=:max")
	public List<Vaccines> VacccineByPrice_named(Double min, Double max);
	
	@Query("FROM Vaccines WHERE price>=?1  AND price<=?2")
	public List<Vaccines> VacccineByPrice_ordincal(Double min, Double max);
	
	@Query("SELECT vname FROM Vaccines WHERE vid=:id")
	public String VacccineNameByid_ordincal(Long id );
	
	@Query("SELECT count(*), min(price), max(price), avg(price), sum(price) FROM Vaccines WHERE price>=:min  AND price<=:max")
	public Object VacccineAggregateDetailsByPrice(Double min, Double max);
	
	@Query("SELECT  vname, price,  manufacturer FROM Vaccines WHERE vid=:id")
	public Object VacccineDetailsById(Long id );
	
	@Modifying
	@Query("UPDATE  Vaccines SET vname=:name, price=:newPrice,  manufacturer=:newManufacturer,  doseCount=:doses WHERE vid=:id")
	@Transactional
	public int updateVacccineDetailsById(Long id, String name, Double newPrice, String newManufacturer, int doses);
	
	@Modifying
	@Query("DELETE FROM  Vaccines WHERE vid=:id")
	@Transactional
	public int deleteVacccineDetailsById(Long id);
	
	@Query(value="SELECT SYSDATE FROM DUAL", nativeQuery =  true)
	public Date  getSysDate();

	@Modifying
	@Query(value="DROP TABLE TEMP_NEW", nativeQuery =  true)
	@Transactional
	public int dropTable();
	
	@Modifying
	@Query(value="CREATE TABLE TEMP_NEW (id number(2), name varchar2(10))", nativeQuery =  true)
	@Transactional
	public int craeteTable();

	@Modifying
	@Query(value="INSERT INTO VACCINES (VID, VNAME, PRICE, MANUFACTURER, DOSE_COUNT) VALUES(?,?,?,?,?)", nativeQuery =  true)
	@Transactional
	public int insertVaccine(int id, String name, double price,  String manufacterName, int  doses);

	
}

