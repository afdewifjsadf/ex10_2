
package service2;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "studentWebService", targetNamespace = "http://services/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StudentWebService {


    /**
     * 
     * @param id
     * @return
     *     returns service2.Student
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findStudentById", targetNamespace = "http://services/", className = "service2.FindStudentById")
    @ResponseWrapper(localName = "findStudentByIdResponse", targetNamespace = "http://services/", className = "service2.FindStudentByIdResponse")
    @Action(input = "http://services/studentWebService/findStudentByIdRequest", output = "http://services/studentWebService/findStudentByIdResponse")
    public Student findStudentById(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @param name
     * @param gpa
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createStudent", targetNamespace = "http://services/", className = "service2.CreateStudent")
    @ResponseWrapper(localName = "createStudentResponse", targetNamespace = "http://services/", className = "service2.CreateStudentResponse")
    @Action(input = "http://services/studentWebService/createStudentRequest", output = "http://services/studentWebService/createStudentResponse")
    public String createStudent(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "gpa", targetNamespace = "")
        double gpa);

    /**
     * 
     * @param name
     * @param gpa
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateStudent", targetNamespace = "http://services/", className = "service2.UpdateStudent")
    @ResponseWrapper(localName = "updateStudentResponse", targetNamespace = "http://services/", className = "service2.UpdateStudentResponse")
    @Action(input = "http://services/studentWebService/updateStudentRequest", output = "http://services/studentWebService/updateStudentResponse")
    public String updateStudent(
        @WebParam(name = "id", targetNamespace = "")
        int id,
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "gpa", targetNamespace = "")
        double gpa);

    /**
     * 
     * @param id
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteStudent", targetNamespace = "http://services/", className = "service2.DeleteStudent")
    @ResponseWrapper(localName = "deleteStudentResponse", targetNamespace = "http://services/", className = "service2.DeleteStudentResponse")
    @Action(input = "http://services/studentWebService/deleteStudentRequest", output = "http://services/studentWebService/deleteStudentResponse")
    public String deleteStudent(
        @WebParam(name = "id", targetNamespace = "")
        int id);

    /**
     * 
     * @return
     *     returns java.util.List<service2.Student>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAllStudent", targetNamespace = "http://services/", className = "service2.FindAllStudent")
    @ResponseWrapper(localName = "findAllStudentResponse", targetNamespace = "http://services/", className = "service2.FindAllStudentResponse")
    @Action(input = "http://services/studentWebService/findAllStudentRequest", output = "http://services/studentWebService/findAllStudentResponse")
    public List<Student> findAllStudent();

}
