package com.mlutecki.demo;

import com.mlutecki.demo.entity.Course;
import com.mlutecki.demo.entity.Instructor;
import com.mlutecki.demo.entity.InstructorDetail;
import com.mlutecki.demo.entity.Review;
import com.mlutecki.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String args[]) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        //Transaction transaction;


        try {

            Instructor instructor = new Instructor("Johnny", "Wicky", "nother@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("https://youtube.com/trjrtyjtry", "ewrtrytulhf");
            Course course = new Course("Moj nowy domssss");
            Student stud = new Student("Adam", "Malysz", "a.malysz@gmail.com");
            Review rev = new Review("to jest moj komentarz");
            session.beginTransaction();

//            instructor.setInstructorDetail(instructorDetail);
//            instructor.add(course);
//            session.save(instructor);

//            course.addReview(rev);
//            course.addStudent(stud);
//            session.save(course);
//            Course course1 = session.get(Course.class, 13);
//            course1.addStudent(stud);




            int studentId = 13;
            //Student tempStudent = new Student("Adam","Pacaj","jakismail@gmail.com");
           // session.save(tempStudent);

            Course course1 = session.get(Course.class, 21);
            Student inst = session.get(Student.class, 10);

           session.delete(inst);
            //course1.addReview(new Review("A boże"));
//            // create more courses
//            Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
//            Course tempCourse2 = new Course("Atari 2600111 - Game Development");
            //session.save(course1);


            // save the courses
            System.out.println("\nSaving the courses ...");

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
