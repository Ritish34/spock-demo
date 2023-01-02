package groovyTest.controller

import com.example.demo1.controller.Hello
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class HelloTest extends Specification {
    @MockBean
    def cont = new Hello()

    MockMvc mvc = MockMvcBuilders.standaloneSetup(cont).build()

    def "when get is performed then the response has status 200 and content is 'Hello world!'"() {
        expect: "Status is 200 and the response is 'Hello world!'"
        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(status().isOk())
                .andReturn()
                .response
                .contentAsString == "Hello World! "
    }
}