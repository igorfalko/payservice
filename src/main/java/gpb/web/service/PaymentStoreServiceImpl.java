package gpb.web.service;

import gpb.web.dto.Payment;
import gpb.web.dto.PaymentInfo;
import gpb.web.dto.PaymentStats;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentStoreServiceImpl implements IPaymentStoreService {
    private final AtomicLong counter = new AtomicLong();
    private List<Payment> paymentList = new ArrayList<>();

    @Override
    public PaymentInfo storePayment(Payment payment) {
        payment.setId(counter.incrementAndGet());
        paymentList.add(payment);
        return new PaymentInfo(payment);
    }

    @Override
    public PaymentStats getPaymentStats() {
        return new PaymentStats();
    }
}
