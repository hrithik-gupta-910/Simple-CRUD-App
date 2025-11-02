package com.love2code.cruddemo;

import com.love2code.cruddemo.dao.StudentDAO;
import com.love2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
            //createStudent(studentDAO);
            //retrieveStudent(studentDAO);

            //queryForStudent(studentDAO);

            //queryForStudentByLastName(studentDAO);

            //updateStudent(studentDAO);

            //deleteStudent(studentDAO);

            deleteAllStudent(studentDAO);
        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        int numberRowsDeleted = studentDAO.deleteAll();
        System.out.println(numberRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int theId = 3;

        System.out.println("deleting the student with id: " +theId);

        studentDAO.delete(theId);

    }

    private void updateStudent(StudentDAO studentDAO) {
        int id = 1;
        Student theStudent = studentDAO.findId(id);

        //change the firstname of id:
        theStudent.setFirstName("Scooby");

        //update the student
        studentDAO.update(theStudent);

        // display

        System.out.println("Updated name: " +theStudent);
    }

    private void queryForStudentByLastName(StudentDAO studentDAO) {

        //get the list of student

        List<Student> theStudents = studentDAO.findByLastName("Shaw");

        // display the list:

        for(Student student: theStudents){
            System.out.println(student);
        }
    }

    private void queryForStudent(StudentDAO studentDAO) {
        // get a list of student
        List<Student> theStudents = studentDAO.findAll();

        // display the list of student

        for(Student tempStudent: theStudents){
            System.out.println(tempStudent);
        }
    }

    private void retrieveStudent(StudentDAO studentDAO) {
        // creating student
        System.out.println("The student object is created");
        Student tempStudent = new Student("Priya","Singh","priya1234@gmail.com");

        // save student
        studentDAO.save(tempStudent);

        //Display the id of the student
        int id = tempStudent.getId();
        System.out.println("Displaying the Student :" +id);

        //retrieve the student
        Student myStudent = studentDAO.findId(id);
        System.out.println("The retieve student: "+ myStudent);
    }

    private void createStudent(StudentDAO studentDAO) {

        // Creating student

        System.out.println("The student object is created:");
        Student tempStudent = new Student("Raj", "Shaw", "raj159shaw@yahoo.com");


        // save the student object
        System.out.println("Saving the student");
        studentDAO.save(tempStudent);


        // display the student object
        System.out.println("Displaying the student: " +tempStudent.getId());


    }
}
