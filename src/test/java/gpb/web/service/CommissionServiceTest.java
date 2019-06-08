package gpb.web.service;

import gpb.web.dto.Payment;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CommissionServiceTest {
    private CommissionServiceImpl commissionService = new CommissionServiceImpl();

    @Test
    public void test() {
        assertEquals(
                commissionService.calcCommission(new Payment(null, null, new BigDecimal("100.00"), "")),
                new BigDecimal("0.15"));
    }
}
