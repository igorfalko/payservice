package gpb.web.service;

import gpb.report.IReport;
import gpb.report.IReportBuilder;
import gpb.web.dto.Payment;

import java.util.Collection;
import java.util.List;

public class PaymentReports {
//1. По каждой точке продаж:
//    * точка продаж
//    * количество платежей
//    * сумма платежей
//    * сумма комиссии
//2. По каждой дате:
//    * дата
//    * количество платежей
//    * сумма платежей
//    * сумма комиссии
    private IReportBuilder<IReport> reportBuilder;

    public String getStat() {
        return "Hoho";
    }

    public PaymentReports parse(IReportBuilder reportBuilder, List<Payment> paymentList) {
        Collection<IReport> report = reportBuilder.build(paymentList);
        return null;
    }
}
