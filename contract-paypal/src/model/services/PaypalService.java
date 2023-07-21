package model.services;

public class PaypalService implements OlinePaymentService{

    @Override
    public Double paymentFee(Double amount) {
        return amount * 0.02f;
    }

    @Override
    public Double insterest(Double amount, Integer months) {
        return amount * 0.01f * months;
    }
    
}
