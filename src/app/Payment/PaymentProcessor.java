package app.Payment;

public class PaymentProcessor {
    private String paymentId;
    private PaymentStartegy startegy;
    private PaymentStatus paymentStatus;

    public PaymentProcessor(String paymentId, PaymentStartegy startegy) {
        this.paymentId = paymentId;
        this.startegy = startegy;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public void process(double amount) {
        try {
            startegy.pay(amount);
            paymentStatus = PaymentStatus.COMPLETD;
        } catch (Exception e) {
            paymentStatus = PaymentStatus.FAILED;
        }
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
