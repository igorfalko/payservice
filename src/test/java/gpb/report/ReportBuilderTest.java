package gpb.report;

import gpb.web.dto.DateReport;
import gpb.web.dto.OfficeReport;
import gpb.web.dto.Payment;
import gpb.web.service.CommissionServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

public class ReportBuilderTest {
    private List<Payment> paymentList = new ArrayList<>();

    @Before
    public void before() {
        Payment payment = new Payment(LocalDate.of(2000, 10, 1), null, new BigDecimal("100.00"), "O1");
        payment.setCommissionAmount(new CommissionServiceImpl().calcCommission(payment));
        paymentList.add(payment);

        payment = new Payment(LocalDate.of(2019, 1, 1), null, new BigDecimal("200.00"), "O1");
        payment.setCommissionAmount(new CommissionServiceImpl().calcCommission(payment));
        paymentList.add(payment);

        payment = new Payment(LocalDate.of(2019, 1, 1), null, new BigDecimal("150.00"), "O2");
        payment.setCommissionAmount(new CommissionServiceImpl().calcCommission(payment));
        paymentList.add(payment);
    }

    @Test
    public void testOfficeReportBuilder() {
        OfficeReportBuilder officeReportBuilder = new OfficeReportBuilder();
        assertThat(officeReportBuilder.build(paymentList),
                hasItems(
                        new OfficeReport("O1",Long.parseLong("2"), new BigDecimal("300.00"), new BigDecimal("0.45")),
                        new OfficeReport("O2",Long.parseLong("1"), new BigDecimal("150.00"), new BigDecimal("0.22"))
                )
        );
    }

    @Test
    public void testDateReportBuilder() {
        DateReportBuilder dateReportBuilder = new DateReportBuilder();
        assertThat(dateReportBuilder.build(paymentList),
                hasItems(
                        new DateReport(LocalDate.of(2000, 10, 1), Long.parseLong("1"), new BigDecimal("100.00"), new BigDecimal("0.15")),
                        new DateReport(LocalDate.of(2019, 1, 1), Long.parseLong("2"), new BigDecimal("350.00"), new BigDecimal("0.52"))
                )
        );
    }

}
