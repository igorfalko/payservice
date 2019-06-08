package gpb.web.dto;

import gpb.report.IReport;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfficeReport that = (OfficeReport) o;
        return Objects.equals(office, that.office) &&
                Objects.equals(paymentCount, that.paymentCount) &&
                Objects.equals(paymentSum, that.paymentSum) &&
                Objects.equals(paymentCommissionSum, that.paymentCommissionSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(office, paymentCount, paymentSum, paymentCommissionSum);
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
