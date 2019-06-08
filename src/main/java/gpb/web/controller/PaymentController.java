package gpb.web.controller;

import gpb.web.dto.Payment;
import gpb.web.dto.PaymentInfo;
import gpb.web.service.IPaymentService;
import gpb.web.service.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private IPaymentService paymentService = new PaymentServiceImpl();

    @PostMapping(value = "/pay", consumes = "application/json", produces = "application/json")
    public PaymentInfo addPayment(@RequestBody Payment payment) {
        return paymentService.processPayment(payment);
    }

    @GetMapping(value = "/stat", produces = "application/json")
    public String getStats() {
        return paymentService.getPaymentStats();
    }

}
