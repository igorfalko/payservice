package gpb.report;

import gpb.web.dto.OfficeReport;
import gpb.web.dto.Payment;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OfficeReportBuilder implements IReportBuilder<OfficeReport>{

    @Override
    public List<OfficeReport> build(Collection<Payment> paymentCollection) {
        List<OfficeReport> officeReportList = new ArrayList<>();
        Set<String> officeList = paymentCollection.stream().map(Payment::getOffice).collect(Collectors.toSet());
        for (String office : officeList) {
            officeReportList.add(new OfficeReport(
                    office,
                    paymentCollection.stream().filter(payment -> office.equals(payment.getOffice())).count(),
                    paymentCollection.stream().filter(payment -> office.equals(payment.getOffice())).map(payment -> payment.getAmount()).reduce(BigDecimal::add).get(),
                    paymentCollection.stream().filter(payment -> office.equals(payment.getOffice())).map(payment -> payment.getCommissionAmount()).reduce(BigDecimal::add).get()
            ));
        }

        return officeReportList;
    }
}
