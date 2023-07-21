package model.services;

import java.time.LocalDate;
import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
    
    private final OlinePaymentService paymentService;

    public ContractService(OlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }
    
    public void processContract(Contract contract, Integer months){
        double amount = contract.getTotalValue() / months; 
        
        for (int i = 1; i < months; i++){
            double interest = amount + paymentService.insterest(amount, i);
            double paymentFee = interest + paymentService.paymentFee(interest);
            
            LocalDate dueDate = contract.getDate().plusMonths(i);
            
            Installment installment = new Installment(dueDate, paymentFee);
            
            contract.addInstallment(installment);
        }
    }
}
