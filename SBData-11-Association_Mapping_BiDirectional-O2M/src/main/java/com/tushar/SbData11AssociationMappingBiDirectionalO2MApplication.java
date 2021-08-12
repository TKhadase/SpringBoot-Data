package com.tushar;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tushar.entity.ContactDetails;
import com.tushar.entity.Person;
import com.tushar.service.PersonMgmtServiceImpl;
import com.tushar.service.iPersonMgmtService;

@SpringBootApplication
public class SbData11AssociationMappingBiDirectionalO2MApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(SbData11AssociationMappingBiDirectionalO2MApplication.class, args);
		
		iPersonMgmtService service = ctx.getBean("PersonService", PersonMgmtServiceImpl.class);
		
		/*System.out.println("---------PARENT to CHILD----------registerPerson_withContact-------------------");
		ContactDetails p1Cd1 = new ContactDetails("Personal", "Vodafone","7798488512");
		ContactDetails p1Cd2 = new ContactDetails("Home","Airtel", "7798488513");
		Person person1 = new Person("Tushar","Khadse","Ytl MH");
		person1.setNumbers(Set.of(p1Cd1,p1Cd2));
		System.out.println(service.registerPerson_withContact(person1));
		
		System.out.println("--------PARENT to CHILD-----------getAllPerson_withContact-------------------");
		List<Person>  listP2 =service.getAllPerson_withContact();
		listP2.forEach(person->{
			System.out.println(person);
			Set<ContactDetails> cd =person.getNumbers();
				cd.forEach(c->{
				System.out.println(c);
				});
		});
		
		System.out.println("---------CHILD to PARENT----------registerContact_withPerson-------------------");
		ContactDetails p2Cd1 = new ContactDetails("Personal", "Vodafone","7798488514");
		ContactDetails p2Cd2 = new ContactDetails("Home","Airtel", "7798488515");
		Person person2 = new Person("Priya","Khadse","GOA");
		p2Cd1.setPerson(person2);
		p2Cd2.setPerson(person2);
		Set<ContactDetails> setContactDetails = Set.of(p2Cd1, p2Cd2);
		person2.setNumbers(setContactDetails);
		System.out.println(service.registerContact_withPerson(setContactDetails));
		*/
		System.out.println("---------CHILD to PARENT----------getAllContact_withPerson-------------------");
		List<ContactDetails> cd =service.getAllContact_withPerson();
		cd.forEach( cdd ->{
			System.out.println(cdd);
			System.out.println(cdd.getPerson());
		} );
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
