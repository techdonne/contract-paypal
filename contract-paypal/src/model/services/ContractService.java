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
        double basicQuota = contract.getTotalValue() / months; ;
        
        for (int i = 1; i <= months; i++){
            double interest = paymentService.insterest(basicQuota , i);
            double fee = paymentService.paymentFee(interest + basicQuota);
            
            double quota = basicQuota + fee + interest;
            
            LocalDate dueDate = contract.getDate().plusMonths(i);
            
            Installment installment = new Installment(dueDate, quota);
            
            contract.addInstallment(installment);
        }
    }
}
