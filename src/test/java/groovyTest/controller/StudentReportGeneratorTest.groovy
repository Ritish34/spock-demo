package groovyTest.controller

import com.example.demo1.controller.StudentReportGenerator
import com.example.demo1.service.StudentDatabase
import spock.lang.Specification


class StudentReportGeneratorTest extends Specification {
    def studentDatabase = Mock(StudentDatabase.class)
    def studentReportGenerator = new StudentReportGenerator(studentDatabase)

    def "illustrate mocks for interaction verification with arguments"() {

        when:
        studentReportGenerator.calculateStudentGrade("123");

        then:
        1 * studentDatabase.updateStudentGrade("123", "C")
        1 * studentDatabase.getStudentGrade("123")
    }

    def "illustrate mocks for interaction verification with generic matchers"() {
        
        when:
        studentReportGenerator.calculateStudentGrade("123");
        
        then:
        1*studentDatabase.updateStudentGrade(_ as String, "C")
        1*studentDatabase.getStudentGrade(_ as String)
    }

    def "illustrate mocks for validating order"() {
        
        when:
        studentReportGenerator.calculateStudentGrade("123");
        
        then:
        1*studentDatabase.getStudentGrade("123")
        
        then:
        1*studentDatabase.updateStudentGrade(_ as String, _ as String)
    }
    
    ////////////////////////////////////////////////////

    def "illustrate stubs with exact matchers"() {
        
        given:
        studentDatabase.getStudentScores("123") >> [20F, 30F, 50F]
        
        when:
        def grade = studentReportGenerator.calculateStudentGrade("123")
        
        then:
        grade == "A"
    }

    def "illustrate stubs with loose matchers"() {
        
        given:
        // '_ as {datatype}' is use as general matcher
        studentDatabase.getStudentScores(_ as String) >> [20F, 30F, 10F]
        
        when:
        def grade = studentReportGenerator.calculateStudentGrade("1234")
        
        then:
        grade == "C"
    }

    def "illustrate stubs with exceptions thrown"() {
        
        given:
        studentDatabase.getStudentScores(_ as String) >> {throw new RuntimeException()}
        
        when:
        studentReportGenerator.calculateStudentGrade("123")
        
        then:
        thrown(RuntimeException.class)
    }
}