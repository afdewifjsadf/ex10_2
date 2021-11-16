/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentsoapclient;

import static java.lang.System.in;
import java.util.ArrayList;
import java.util.List;
import service2.Student;

/**
 *
 * @author ub
 */
public class StudentSoapClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Student> student_list = findAllStudent();
        System.out.println("find all student");
        System.out.println("==============================");
        for (Student std : student_list) {
            System.out.print(std.getId() + " ");
            System.out.print(std.getName() + " ");
            System.out.println(std.getGpa() + " ");
        }

        System.out.println("\ncreate student");
        System.out.println("==============================");
        String s = createStudent(3, "QQQQQQQQQ", 2.5);
        System.out.println("create <3, QQQQQQQQQ, 2.5> : " + s);

        System.out.println("\nfind student by id");
        System.out.println("==============================");
        Student std = findStudentById(3);
        System.out.println("find id <3> : " + std.getName() + " " + std.getGpa());

        System.out.println("\nupdate student");
        System.out.println("==============================");
        s = updateStudent(3, "PPPPPP", 3.5);
        System.out.println("update <3, PPPPPP, 3.5> : " + s);

        System.out.println("\nfind student by id");
        System.out.println("==============================");
        std = findStudentById(3);
        System.out.println("find id <3> : " + std.getName() + " " + std.getGpa());

        System.out.println("\ndelete student");
        System.out.println("==============================");
        s = deleteStudent(3);
        System.out.println("delete <3> : " + s);

        student_list = findAllStudent();
        System.out.println("\nfind all student");
        System.out.println("==============================");
        for (Student std1 : student_list) {
            System.out.print(std1.getId() + " ");
            System.out.print(std1.getName() + " ");
            System.out.println(std1.getGpa() + " ");
        }

    }

    private static java.util.List<service2.Student> findAllStudent() {
        service2.StudentWebService_Service service = new service2.StudentWebService_Service();
        service2.StudentWebService port = service.getStudentWebServicePort();
        return port.findAllStudent();
    }

    private static Student findStudentById(int id) {
        service2.StudentWebService_Service service = new service2.StudentWebService_Service();
        service2.StudentWebService port = service.getStudentWebServicePort();
        return port.findStudentById(id);
    }

    private static String createStudent(int id, java.lang.String name, double gpa) {
        service2.StudentWebService_Service service = new service2.StudentWebService_Service();
        service2.StudentWebService port = service.getStudentWebServicePort();
        return port.createStudent(id, name, gpa);
    }

    private static String deleteStudent(int id) {
        service2.StudentWebService_Service service = new service2.StudentWebService_Service();
        service2.StudentWebService port = service.getStudentWebServicePort();
        return port.deleteStudent(id);
    }

    private static String updateStudent(int id, java.lang.String name, double gpa) {
        service2.StudentWebService_Service service = new service2.StudentWebService_Service();
        service2.StudentWebService port = service.getStudentWebServicePort();
        return port.updateStudent(id, name, gpa);
    }

}
