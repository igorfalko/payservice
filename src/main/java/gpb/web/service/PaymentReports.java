package gpb.web.service;

import gpb.report.IReport;
import gpb.report.IReportBuilder;
import gpb.web.dto.Payment;

import java.util.Collection;
import java.util.List;

public class PaymentReports {
    private IReportBuilder<IReport> reportBuilder;

    public String parse(List<Payment> paymentList, IReportBuilder<IReport> reportBuilder) {
        Collection<IReport> reportCollection = reportBuilder.build(paymentList);
        StringBuilder json = new StringBuilder("{\"" + reportBuilder.getReportName() + "\":[");
        for (IReport report : reportCollection) {
            json.append(report.toJson());
            json.append(",");
        }
        if (!reportCollection.isEmpty())
            json.deleteCharAt(json.lastIndexOf(","));
        json.append("]}");
        return json.toString();
    }

    public String parse(List<Payment> paymentList, IReportBuilder[] reportBuilders) {
        StringBuilder json = new StringBuilder("{\"reports\":[");
        for (IReportBuilder<IReport> reportBuilder : reportBuilders) {
            json.append(parse(paymentList, reportBuilder));
            json.append(",");
        }
        json.deleteCharAt(json.lastIndexOf(","));
        json.append("]}");
        return json.toString();
    }
}
