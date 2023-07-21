package model.services;

import model.entities.Contract;

public class ContractService {
    
    private OlinePaymentService paymentService;

    public ContractService(OlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }
    
    public void processContract(Contract contract, Integer months){
        
    }
}
