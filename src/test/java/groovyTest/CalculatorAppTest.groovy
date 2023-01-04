package groovyTest

import com.example.demo1.CalculatorApp
import spock.lang.Specification
import spock.lang.Unroll


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
            println("input1 = "+input1+" input2 = "+input2+" result = "+result)
        then:
            result == expectedResult
        /**
         * where is use to give multiple input to test cases
         * this is mostly used for overloading methods
         * for input use single pipeline ('|')
         * for output u can use single and double both
         * by convention you use single pipeline for input and double pipeline for output.
         * this method is called Datatables
         * data tables can be used to hold any type of variables, classes, objects, enums, etc.
        */
        where:
            input1|input2|expectedResult
            10|25|35
            -5|25||20
        }

    /**
     * Unroll annotation give different test case into report.
     * */
    @Unroll
    def "sample parameterized test"() {
        given:
        def app = new CalculatorApp()
        when:
        def resultSum = app.add(input1, input1)
        then:
        resultSum == 2 * input1
        where:
        input1 |input2  |expectedResult
        10     |15      |25
        -4     |6       |2
        -32    |12      |-20
    }

    def "size of #input1 should be #expectedCount"() {
        when:
        def actualCount = input1.size()
        then:
        actualCount == expectedCount
        where:
        input1                                      ||expectedCount
        ["hello","world","happy","programming"]     ||4
        ["spock","data-driven","testing"]           ||3
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