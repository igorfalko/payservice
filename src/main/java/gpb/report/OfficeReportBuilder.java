package gpb.report;

import gpb.web.dto.OfficeReport;
import gpb.web.dto.Payment;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OfficeReportBuilder implements IReportBuilder<OfficeReport>{

    @Override
    public List<OfficeReport> build(Collection<Payment> paymentCollection) {
        List<OfficeReport> officeReportList = new ArrayList<>();
        List<String> officeList = paymentCollection.stream().map(Payment::getOffice).distinct().sorted().collect(Collectors.toList());
        for (String office : officeList) {
            officeReportList.add(new OfficeReport(
                    office,
                    paymentCollection.stream().filter(payment -> office.equals(payment.getOffice())).count(),
                    paymentCollection.stream().filter(payment -> office.equals(payment.getOffice())).map(Payment::getAmount).reduce(BigDecimal::add).get(),
                    paymentCollection.stream().filter(payment -> office.equals(payment.getOffice())).map(Payment::getCommissionAmount).reduce(BigDecimal::add).get()
            ));
        }

        return officeReportList;
    }

    @Override
    public String getReportName() {
        return "officeReport";
    }
}
