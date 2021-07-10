package com.tushar;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.tushar.entity.Vaccines;
import com.tushar.service.iVaccineService;

@SpringBootApplication
public class SbData01CrudRepoApplication {

	public static void main(String[] args) {
		System.out.println("------------------------SbData01CrudRepoApplication.main() start------------------------");
		
		ApplicationContext ctx = SpringApplication.run(SbData01CrudRepoApplication.class, args);
		iVaccineService vService = ctx.getBean("VaccineService", iVaccineService.class);
		System.out.println("Vaccine Bean ready");

		try {
			// count
			System.out.println("------------------------GetCount------------------------");
			System.out.println(vService.Vaccines_Count());

			// delete
			System.out.println("------------------------delete------------------------");
			System.out.println(vService.deRegVaccine_deleteById(23L));

			Vaccines deletableVaccine = new Vaccines(27L, null, null, 0.0, 0);
			System.out.println(vService.deRegVaccine_deleteByObject(deletableVaccine));

			System.out.println(vService.deRegVaccine_deleteByIds(List.of(28L, 29L)));

			Vaccines deletableVaccine1 = new Vaccines(11L, null, null, 0.0, 0);
			Vaccines deletableVaccine2 = new Vaccines(22L, null, null, 0.0, 0);
			System.out.println(vService.deRegVaccine_deleteByObjects(List.of(deletableVaccine1, deletableVaccine2)));

			System.out.println(vService.deReg_deleteAll());

			// insert
			System.out.println("------------------------insert------------------------");
			Vaccines vaccineCoviShield = new Vaccines(null, "CoviShield", "Serum IND", 400.0, 2);
			System.out.println(vService.Vaccine_save(vaccineCoviShield));

			Vaccines vaccinePhizer = new Vaccines(null, "Phizer", "phizer EUP", 800.0, 2);
			System.out.println(vService.Vaccine_saveAll(List.of(vaccineCoviShield, vaccinePhizer)));

			// update
			System.out.println("------------------------update------------------------");
			Vaccines vaccinePhizerUpdated = new Vaccines(null, "Phizer", "phizer EURO", 700.0, 1);
			System.out.println(vService.Vaccine_save(vaccinePhizerUpdated));

			// select
			System.out.println("------------------------select------------------------");
			System.out.println(vService.Vaccine_FindAllByIds(List.of(1L, 2L, 3L)));
			System.out.println(vService.Vaccine_FindById(1L));
			System.out.println(vService.Vaccine_FindAll());
			System.out.println(vService.Vaccine_existByid(4L));
			
		} catch (DataAccessException a) {
			System.out.println("------------------------SbData01CrudRepoApplication.DataAccessException:");
			a.printStackTrace();
		} catch (Exception e) {
			System.out.println("------------------------SbData01CrudRepoApplication.Exception:");
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ctx).close();
		System.out.println("-----------------------------SbData01CrudRepoApplication.main() end-----------------------------");
	}

}
