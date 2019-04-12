package Service;

import Domain.Invoice;
import Repository.InvoiceRepository;

import java.util.List;

public class InvoiceService {
    private InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }


    public void insert(String id, double amount, String briefing, String date) {
        for (Invoice i: repository.getAll()){
            if (i.getId().equals( id )){
                throw new RuntimeException( "This id is already in use." );
            }
        }

        Invoice invoice = new Invoice( id, amount, briefing, date );
        repository.insert( invoice );
    }

    public List <Invoice> getAll() {
        return repository.getAll();
    }
}