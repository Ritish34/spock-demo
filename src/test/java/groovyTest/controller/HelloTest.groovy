package groovyTest.controller

import com.example.demo1.Demo1Application
import com.example.demo1.controller.Hello
import com.example.demo1.service.HelloService
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ContextConfiguration(classes = Demo1Application)
@WebMvcTest
class HelloTest extends Specification {
    @Autowired
    protected MockMvc mvc
    @SpringBean
    HelloService helloService = Stub(){
        greeting() >> "Stubbed data"
    }

    def "when get is performed then the response has status 200 and content is 'Hello world!'"() {
        expect: "Status is 200 and the response is 'Hello world!'"
        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(status().isOk())
                .andReturn()
                .response
                .contentAsString == "Hello World! "
    }

    def "when get is performed then the response has status 200 and service method calls"() {

        when : "Calls Method"
        def result = mvc.perform(MockMvcRequestBuilders.get("/greeting"))

        then : "check value"
            result.andExpect(status().isOk())
        and : "check for stubbed string"
            result.andReturn().response.contentAsString == "Stubbed data"
    }
}