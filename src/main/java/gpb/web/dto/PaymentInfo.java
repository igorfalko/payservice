package gpb.web.dto;

import java.math.BigDecimal;

public class PaymentInfo {
    private BigDecimal commissionAmount;
    private Long id;

    public PaymentInfo(Payment payment) {
        this.commissionAmount = payment.getCommissionAmount();
        this.id = payment.getId();
    }

    public BigDecimal getCommissionAmount() {
        return commissionAmount;
    }

    public Long getId() {
        return id;
    }
}
