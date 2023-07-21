package model.services;

public class PaypalService implements OlinePaymentService{

    @Override
    public Double paymentFee(Double amount) {
        return amount * 0.2f;
    }

    @Override
    public Double insterest(Double amount, Double months) {
        return amount * 0.1f * months;
    }
    
}
