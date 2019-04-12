package Repository;

import Domain.Invoice;
import Domain.InvoiceValidator;
import com.sun.org.apache.bcel.internal.generic.InvokeInstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceRepository {
    private Map<String, Invoice > storage = new HashMap <>(  );
    private InvoiceValidator validator;


    public InvoiceRepository(Map < String, Invoice > storage, InvoiceValidator validator) {
        this.storage = storage;
        this.validator = validator;
    }

    public InvoiceRepository (InvoiceValidator invoiceValidator){

    }
    public void insert (Invoice invoice){
        if( storage.containsKey( invoice.getId())){
            throw new RuntimeException( String.format( "There already is an invoice with id=%s ", invoice.getId()) );
        }

        validator.validate( invoice );
        storage.put(invoice.getId(), invoice);
    }

    public List<Invoice> getAll(){
        return new ArrayList <>( storage.values() );
    }
}
