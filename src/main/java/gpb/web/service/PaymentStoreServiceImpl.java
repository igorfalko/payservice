package gpb.web.service;

import gpb.report.DateReportBuilder;
import gpb.report.IReportBuilder;
import gpb.report.OfficeReportBuilder;
import gpb.web.dto.Payment;
import gpb.web.dto.PaymentInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentStoreServiceImpl implements IPaymentStoreService {
    private final AtomicLong counter = new AtomicLong();
    private List<Payment> paymentList = new ArrayList<>();
    private ICommissionService commissionService = new CommissionServiceImpl();

    @Override
    public PaymentInfo storePayment(Payment payment) {
        payment.setCommissionAmount(commissionService.calcCommission(payment));
        payment.setId(counter.incrementAndGet());
        paymentList.add(payment);
        return new PaymentInfo(payment.getId(), payment.getCommissionAmount());
    }

    @Override
    public String getPaymentStats() {
        IReportBuilder[] reportBuilders = new IReportBuilder[] {new DateReportBuilder(), new OfficeReportBuilder()};
        String report = new PaymentReports().parse(paymentList, reportBuilders);
        paymentList.clear();
        return report;
    }
}
