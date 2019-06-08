package gpb;

import gpb.web.dto.Payment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
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
    private List<Payment> paymentList = new ArrayList<>();

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void before() {
        Payment payment = new Payment(LocalDate.of(2000, 10, 1), LocalTime.parse("00:00:01"), new BigDecimal("100.00"), "O1");
        paymentList.add(payment);

        payment = new Payment(LocalDate.of(2019, 1, 1), LocalTime.parse("00:00:01"), new BigDecimal("200.00"), "O1");
        paymentList.add(payment);

        payment = new Payment(LocalDate.of(2019, 1, 1), LocalTime.parse("00:00:01"), new BigDecimal("150.00"), "O2");
        paymentList.add(payment);
    }

    @Test
    public void testPay() throws Exception {

        this.mockMvc.perform(post("/pay").contentType(CONTENT_TYPE).content(paymentList.get(0).toJson()))
//                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(post("/pay").contentType(CONTENT_TYPE).content(paymentList.get(1).toJson()))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath("$.commissionAmount", is(0.3)))
                .andExpect(jsonPath("$.id", is(2)));
    }

    @Test
//    @Ignore
    public void testStat() throws Exception {

        for (Payment payment : paymentList) {
            this.mockMvc.perform(post("/pay").contentType(CONTENT_TYPE).content(payment.toJson()))
//                .andDo(print())
                .andExpect(status().isOk());
        }

        this.mockMvc.perform(get("/stat"))
//                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reports", hasSize(2)))
        ;

        this.mockMvc.perform(get("/stat"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reports", hasSize(2)))
                ;


/*
    {
        "reports":[
        {
            "dateReport":[
            {
                "date":"2019-01-01",
                    "paymentCount":"2",
                    "paymentSum":350.00,
                    "paymentCommissionSum":"0.52"
            },
            {
                "date":"2000-10-01",
                    "paymentCount":"1",
                    "paymentSum":100.00,
                    "paymentCommissionSum":"0.15"
            }
     ]
        },
        {
            "officeReport":[
            {
                "office":"O1",
                    "paymentCount":"2",
                    "paymentSum":300.00,
                    "paymentCommissionSum":"0.45"
            },
            {
                "office":"O2",
                    "paymentCount":"1",
                    "paymentSum":150.00,
                    "paymentCommissionSum":"0.22"
            }
     ]
        }
    ]
}
*/

    }
}
