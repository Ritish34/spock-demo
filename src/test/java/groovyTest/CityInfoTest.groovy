package groovyTest

import com.example.demo1.CityInfo
import spock.lang.Specification


class CityInfoTest extends Specification {

    def "Assert multiple elements of list" () {
        given:
            def cityList = new LinkedList<CityInfo>()
            cityList.add(new CityInfo("Mumbai", 120))
            cityList.add(new CityInfo("Delhi", 80))
            cityList.add(new CityInfo("Chennai", 100))
        expect:
            /**
             *  using '*' you can check multiple fields
             *  it check all cases
             *  in example it check for all three field
             *  if one is not present than case fails and if more than test fails
             *  insertion order is also important
             * */
            cityList*.cityName == ["Mumbai", "Delhi", "Chennai"]
        and:
            /**
             * every() is check for every element
             * if condition false than fails testcase
             * */
            cityList.population.every() {
                it > 70
            }
    }

    def "cleanliness score throws runtime exception with message - method not implemented"() {
        given:
            CityInfo app = new CityInfo();
        when:
            app.cleanlinessScore()
        then:
            def e = thrown(RuntimeException)
            println(e.getMessage())
            e.message == "method not implemented"
    }
}