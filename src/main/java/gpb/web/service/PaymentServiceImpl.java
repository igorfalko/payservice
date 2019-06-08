package gpb.web.service;

import gpb.web.dto.Payment;
import gpb.web.dto.PaymentInfo;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements IPaymentService {
    private IPaymentStoreService paymentStore = new PaymentStoreServiceImpl();

    @Override
    public PaymentInfo processPayment(Payment payment) {
        return paymentStore.storePayment(payment);
    }

    @Override
    public String getPaymentStats() {
        return paymentStore.getPaymentStats();
    }

}
