package gpb.web.dto;

import gpb.report.IReport;

import java.math.BigDecimal;

public class OfficeReport implements IReport {
//    * точка продаж
//    * количество платежей
//    * сумма платежей
//    * сумма комиссии

    private final String office;
    private final Long paymentCount;
    private final BigDecimal paymentSum;
    private final BigDecimal paymentCommissionSum;

    public OfficeReport(String office, Long paymentCount, BigDecimal paymentSum, BigDecimal paymentCommissionSum) {
        this.office = office;
        this.paymentCount = paymentCount;
        this.paymentSum = paymentSum;
        this.paymentCommissionSum = paymentCommissionSum;
    }

    public String getOffice() {
        return office;
    }

    public Long getPaymentCount() {
        return paymentCount;
    }

    public BigDecimal getPaymentSum() {
        return paymentSum;
    }

    public BigDecimal getPaymentCommissionSum() {
        return paymentCommissionSum;
    }
}
