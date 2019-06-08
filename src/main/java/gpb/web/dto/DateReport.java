package gpb.web.dto;

import gpb.report.IReport;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateReport that = (DateReport) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(paymentCount, that.paymentCount) &&
                Objects.equals(paymentSum, that.paymentSum) &&
                Objects.equals(paymentCommissionSum, that.paymentCommissionSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, paymentCount, paymentSum, paymentCommissionSum);
    }

    @Override
    public String toJson() {
        return
                "{" +
                        "\"date\":\"" + date + "\"," +
                        "\"paymentCount\":\""+ paymentCount +"\"," +
                        "\"paymentSum\":" + paymentSum + "," +
                        "\"paymentCommissionSum\":\"" + paymentCommissionSum + "\"" +
                        "}";
    }
}
