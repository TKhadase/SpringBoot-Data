package com.tushar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.tushar.Entity.StudentDetails;
import com.tushar.service.iStudentService;

@SpringBootApplication
public class SbData10ClobBlobApplication {

	public static void main(String[] args)  {
	ApplicationContext ctx =	  SpringApplication.run(SbData10ClobBlobApplication.class, args);
	iStudentService service = ctx.getBean("studentService",iStudentService.class);
	try {
		InputStream is=new FileInputStream("C:\\Users\\Tushar\\Downloads\\thought.jpg");
		byte[] photoData=new byte[is.available()];
		photoData=is.readAllBytes();
		//prepare  char[] representing biodata file content
		File file=new File("E:\\c\\cmd_wifi.txt");
		Reader reader=new FileReader(file);
		char bioDataContent[]=new char[(int) file.length()];
		reader.read(bioDataContent);
		
	StudentDetails Student = new StudentDetails("Tushar", photoData, bioDataContent);
	int id =service.registerStudent(Student);
	System.out.println("Student enrolled with ID#"+id);
	
	System.out.println("-------------------Display saved student Details-------------------------");
	Optional<StudentDetails> opt = service.getStudentById(id);
	if(opt.isPresent()) {
		StudentDetails s1 = opt.get();
		System.out.println("StudentDetails:: "+s1.getSID()+" "+s1.getSNAME());
		
		OutputStream os = new FileOutputStream("C:\\Users\\Tushar\\Downloads\\"+id+".jpg");
		os.write(s1.getPHOTO());
		os.flush();
		Writer writer = new FileWriter("C:\\Users\\Tushar\\Downloads\\"+id+"_resume.txt");
		writer.write(s1.getRESUME());
		writer.flush();
		os.close();
		writer.close();
		System.out.println("-------------------Displayed student Details also saved-------------------------");
	}
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	((ConfigurableApplicationContext) ctx).close();
	}

}

