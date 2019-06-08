package gpb;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PaymentControllerTests {
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPay() throws Exception {

        String paymentJson = "{\n" +
                "\t\"paymentDate\": \"2019-01-01\",\n" +
                "    \"paymentTime\": \"00:00:01\",\n" +
                "    \"amount\": 1000.20,\n" +
                "    \"office\": \"Office\"\n" +
                "}";

        this.mockMvc.perform(post("/pay").contentType(CONTENT_TYPE).content(paymentJson))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(post("/pay").contentType(CONTENT_TYPE).content(paymentJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
//                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.commissionAmount", is(1.5)))
                .andExpect(jsonPath("$.id", is(2)));
    }

    @Test
    @Ignore
    public void testStat() throws Exception {

        this.mockMvc.perform(get("/stat"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stat").value("Hoho"));
    }
}
