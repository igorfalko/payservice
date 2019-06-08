package gpb.web.service;

import gpb.web.dto.Payment;
import gpb.web.dto.PaymentInfo;

public interface IPaymentService {

    PaymentInfo processPayment(Payment payment);

    String getPaymentStats();
}
