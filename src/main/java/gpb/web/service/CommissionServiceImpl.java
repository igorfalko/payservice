package gpb.web.service;

import gpb.web.dto.Payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CommissionServiceImpl implements ICommissionService {
    private final static BigDecimal RATE = new BigDecimal("0.0015");

    @Override
    public BigDecimal calcCommission(Payment payment) {
        return payment.getAmount().multiply(RATE).setScale(2, RoundingMode.HALF_EVEN);
    }
}
