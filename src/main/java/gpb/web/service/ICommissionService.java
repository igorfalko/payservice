package gpb.web.service;

import java.math.BigDecimal;

public interface ICommissionService {
    BigDecimal calcCommission(BigDecimal amount);
}
