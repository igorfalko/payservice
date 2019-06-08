package gpb.web.service;

import gpb.web.dto.Payment;
import gpb.web.dto.PaymentInfo;

public interface IPaymentStoreService {
    PaymentInfo storePayment(Payment payment);

    String getPaymentStats();
}
