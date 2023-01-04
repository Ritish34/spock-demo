package groovyTest.controller

import com.example.demo1.controller.StudentReportGenerator
import com.example.demo1.service.StudentDatabase
import spock.lang.Specification


class StudentReportGeneratorSpyTest extends Specification {

    def "illustrate spies"() {
        
        given:
        StudentDatabase spiedStudentDatabase = Spy(StudentDatabase.class)
        def studentReportGenerator = new  StudentReportGenerator(spiedStudentDatabase)
        
        when:
        def grade = studentReportGenerator.calculateStudentGrade("123")
        
        then:
        grade == "A"
        1*spiedStudentDatabase.getStudentGrade(_ as String) >> "A"
    }

    def "illustrate spies with real method call"() {
        
        given:
        StudentDatabase spiedStudentDatabase = Spy(StudentDatabase.class)
        def studentReportGenerator = new  StudentReportGenerator(spiedStudentDatabase)
        
        when:
        def grade = studentReportGenerator.calculateStudentGrade("123")
        
        then:
        grade == "B"
        1*spiedStudentDatabase.getStudentGrade("123")
    }
}