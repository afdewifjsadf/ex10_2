/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Student;

/**
 *
 * @author ub
 */
@WebService(serviceName = "studentWebService")
public class studentWebService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentSoapPU");

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findStudentById")
    public Student findStudentById(@WebParam(name = "id") int id) {
        EntityManager em = emf.createEntityManager();
        Student std = em.find(Student.class, id);
        return std;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createStudent")
    public String createStudent(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "gpa") double gpa) {
        EntityManager em = emf.createEntityManager();
        Student std = new Student();
        std.setId(id);
        std.setName(name);
        std.setGpa(gpa);
        String status = "";
        try {
            em.getTransaction().begin();
            em.persist(std);
            em.getTransaction().commit();
            status = "inset success";
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
        return status;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateStudent")
    public String updateStudent(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "gpa") double gpa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student std = em.find(Student.class, id);
            if (std == null) {
                return "update fail";
            }
            std.setName(name);
            std.setGpa(gpa);
            em.persist(std);
            em.getTransaction().commit();

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();

        } finally {
            em.close();
        }

        return "update success";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteStudent")
    public String deleteStudent(@WebParam(name = "id") int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student std = em.find(Student.class, id);
            if (std == null) {
                return "delete fail";
            }

            em.remove(std);
            em.getTransaction().commit();

        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();

        } finally {
            em.close();
        }
        return "delete success";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findAllStudent")
    public List<Student>  findAllStudent() {
        EntityManager em = emf.createEntityManager();
        List<Student> sList = (List<Student>) em.createNamedQuery("Student.findAll").getResultList();
        em.close();
        return sList;
    }
    
    
    
    
    
    

}
