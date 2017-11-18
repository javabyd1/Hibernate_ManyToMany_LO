package com.sda.manytomany;

import com.sda.manytomany.model.Student;
import com.sda.manytomany.model.Subject;
import com.sda.manytomany.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
	public static void main(String[] args) {
		Student student1 = new Student();
		student1.setName("Jan");
        Student student2 = new Student();
        student2.setName("Igor");
        
        Subject subject1 = new Subject();
        subject1.setName("Physics");
        Subject subject2 = new Subject();
        subject2.setName("Politics");
        Subject subject3 = new Subject();
        subject3.setName("Economics");
 
        student1.getSubjects().add(subject1);
        student1.getSubjects().add(subject2);
        student1.getSubjects().add(subject3);
         
        student2.getSubjects().add(subject1);
        student2.getSubjects().add(subject2);
 
        Session session = HibernateUtil.getHibernateSession();
        session.beginTransaction();
 
        session.save(student1);
        session.save(student2);

        //Prosze zwrocic uwage na to, ze Subject jest zapisywany razem ze Studentami, bez oddzielnego wywolywania metody save na Subject
        //Dzieje sie tak, poniewaz korzystamy z cascade = CascadeType.ALL w encji studenta
        

        session.getTransaction().commit();
        session.close();  
	}
}
