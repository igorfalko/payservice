package gpb.report;

import gpb.web.dto.Payment;

import java.util.Collection;

public interface IReportBuilder <T extends IReport> {
    Collection<T> build(Collection<Payment> paymentCollection);
}
