package gpb.report;

import gpb.web.dto.DateReport;
import gpb.web.dto.Payment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DateReportBuilder implements IReportBuilder<DateReport> {

    @Override
    public List<DateReport> build(Collection<Payment> paymentCollection) {

            List<DateReport> dateReportList = new ArrayList<>();
            Set<LocalDate> dateList = paymentCollection.stream().map(Payment::getPaymentDate).collect(Collectors.toSet());
            for (LocalDate date : dateList) {
                dateReportList.add(new DateReport(
                        date,
                        paymentCollection.stream().filter(payment -> date.compareTo(payment.getPaymentDate()) == 0).count(),
                        paymentCollection.stream().filter(payment -> date.compareTo(payment.getPaymentDate()) == 0).map(Payment::getAmount).reduce(BigDecimal::add).get(),
                        paymentCollection.stream().filter(payment -> date.compareTo(payment.getPaymentDate()) == 0).map(Payment::getCommissionAmount).reduce(BigDecimal::add).get()
                ));
            }

            return dateReportList;
        }
}
