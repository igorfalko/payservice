package gpb.web.service;

import gpb.web.dto.Payment;

import java.math.BigDecimal;

public interface ICommissionService {
    BigDecimal calcCommission(Payment payment);
}
