package groovyTest

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class Test1 extends Specification {

    def "testing"(){
        expect:
        1+1 == 2
    }
}