package groovyTest

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class Test1 extends Specification {

    def "testing"(){
        expect:
            1+1 == 2
    }
    def "check case-insensitive equality of 2 strings"() {
        given:"Given Two Input Strings"
            String str1 = "hello"
            String str2 = "HELLO"

        when:"Convert String to Lowercase"
            str1 = str1.toLowerCase()
            str2 = str2.toLowerCase()

        then:"Asser it for Equality"
            str1 == str2
    }
    def "check addition of 2 numbers"() {
        given:
            int input1 = 10
            int input2 = 25
        expect:
            input1.getClass().toString() == "class java.lang.Integer"
            input2.getClass().toString() == "class java.lang.Integer"
            input1 <= Integer.MAX_VALUE && input1 >= 0
            input2 <= Integer.MAX_VALUE && input2 >= 0
        when:
            int result = input1 + input2
        then:
            result == 35
    }
}