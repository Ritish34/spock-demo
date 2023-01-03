package groovyTest

import com.example.demo1.CalculatorApp
import spock.lang.Specification


class CalculatorAppTest extends Specification {

    /**
     * The def keyword is used to define the type-def
     * and can be used to declare a function as well as a field/variable.
    */
    def input1 = 50
    def input2 = 10
    def result = 0
    def static count = 0
    def app = new CalculatorApp()

    /**
     * Call only one time for all testcases
     * you can define spec for static or whole testcases have same value
     * */
    def setupSpec() {
        println("###in setup spec!")
        count = 1
    }
    /**
     * call only once at the end of all testcases
     * */
    def cleanupSpec() {
        println("###in cleanup spec!")
        count = 0
        println("count = "+count)
    }
    /**
     * call for every testcase
     * it call for every testcase before testcase
     * */
    def setup() {
        println(">>>in test setup!"+count)
    }
    /**
     * call for every testcase
     * it call for every testcase after testcase
     * */
    def cleanup() {
        println(">>>in test cleanup!"+count)
        count++
    }


    def "addition with valid inputs return expected result"() {
        println("add")
        when:
            result = app.add(input1, input2)
        then:
            result == 60
        }
    def "multiplication with valid inputs return expected result"() {
        println("multi")
        when:
            result = app.multiply(input1, input2)
        then:
            result == 500
        }
    def "division with valid inputs return expected result"() {
        println("div")
        when:
            result = app.divide(input1, input2)
        then:
            result == 5
        }
    def "subsctraction with valid inputs return expected result"() {
        println("sub")
        when:
            result = app.substract(input1, input2)
        then:
            result == 40
        }
}