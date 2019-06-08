package gpb.web.service;

import gpb.web.dto.Payment;
import gpb.web.dto.PaymentInfo;
import gpb.web.dto.PaymentStats;

public interface IPaymentService {

    PaymentInfo processPayment(Payment payment);

    PaymentStats getPaymentStats();
}
