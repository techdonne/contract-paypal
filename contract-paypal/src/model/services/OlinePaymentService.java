package model.services;

public interface OlinePaymentService {
    Double paymentFee(Double amount);
    Double insterest(Double amount, Integer months);
}
