package gpb.web.dto;

import gpb.report.IReport;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DateReport implements IReport {
//    * дата
//    * количество платежей
//    * сумма платежей
//    * сумма комиссии

    private final LocalDate date;
    private final Long paymentCount;
    private final BigDecimal paymentSum;
    private final BigDecimal paymentCommissionSum;

    public DateReport(LocalDate date, Long paymentCount, BigDecimal paymentSum, BigDecimal paymentCommissionSum) {
        this.date = date;
        this.paymentCount = paymentCount;
        this.paymentSum = paymentSum;
        this.paymentCommissionSum = paymentCommissionSum;
    }

    public LocalDate getDate() {
        return date;
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
