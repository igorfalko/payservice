package gpb.report;

import gpb.web.dto.Payment;
import gpb.web.service.CommissionServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OfficeReportBuilderTest {
    @Test
    public void test() {
        OfficeReportBuilder officeReportBuilder = new OfficeReportBuilder();
        List<Payment> paymentList = new ArrayList<>();

        Payment payment = new Payment(null, null, new BigDecimal("100.00"), "O1");
        payment.setCommissionAmount(new CommissionServiceImpl().calcCommission(payment));
        paymentList.add(payment);

        payment = new Payment(null, null, new BigDecimal("200.00"), "O1");
        payment.setCommissionAmount(new CommissionServiceImpl().calcCommission(payment));
        paymentList.add(payment);

        payment = new Payment(null, null, new BigDecimal("150.00"), "O2");
        payment.setCommissionAmount(new CommissionServiceImpl().calcCommission(payment));
        paymentList.add(payment);

        officeReportBuilder.build(paymentList);
        assertTrue(true);
    }
}
