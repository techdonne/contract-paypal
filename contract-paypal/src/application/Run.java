package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.OlinePaymentService;
import model.services.PaypalService;

public class Run {
  
    public static void main(String[] args) {
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        LocalDate date = LocalDate.parse("25/06/2018", format);
        
        Contract contract = new Contract(2028, date, 600.0);
        
        OlinePaymentService paymentService = new PaypalService();
        
        ContractService service = new ContractService(paymentService);
        
        service.processContract(contract, 3);
        
        List<Installment> installments = contract.getInstallments();
        
        System.out.println("Installments");
        
        for (Installment installment: installments){
            System.out.println(installment);
        }
    }
    
}
