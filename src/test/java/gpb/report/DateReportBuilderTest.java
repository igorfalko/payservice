package gpb.report;

import gpb.web.dto.Payment;
import gpb.web.service.CommissionServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class DateReportBuilderTest {

    @Test
    public void test() {
        DateReportBuilder dateReportBuilder = new DateReportBuilder();
        List<Payment> paymentList = new ArrayList<>();

        Payment payment = new Payment(LocalDate.now(), null, new BigDecimal("100.00"), "O1");
        payment.setCommissionAmount(new CommissionServiceImpl().calcCommission(payment));
        paymentList.add(payment);

        payment = new Payment(LocalDate.now(), null, new BigDecimal("200.00"), "O1");
        payment.setCommissionAmount(new CommissionServiceImpl().calcCommission(payment));
        paymentList.add(payment);

        payment = new Payment(LocalDate.now(), null, new BigDecimal("150.00"), "O2");
        payment.setCommissionAmount(new CommissionServiceImpl().calcCommission(payment));
        paymentList.add(payment);

        dateReportBuilder.build(paymentList);
        assertTrue(true);
    }
}
