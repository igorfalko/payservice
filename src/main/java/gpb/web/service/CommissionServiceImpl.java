package gpb.web.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CommissionServiceImpl implements ICommissionService {
    private final static BigDecimal RATE = new BigDecimal("0.0015");

    @Override
    public BigDecimal calcCommission(BigDecimal amount) {
        return amount.multiply(RATE).setScale(2, RoundingMode.HALF_EVEN);
    }
}
