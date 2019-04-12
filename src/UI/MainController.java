package UI;

import Domain.Invoice;
import Service.InvoiceService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController {

    public TableView tblInvoice;
    public TableColumn colIdInvoice;
    public TableColumn colAmount;
    public TableColumn colBriefing;
    public TableColumn colDate;
    public TextField txtId;
    public TextField txtAmount;
    public TextField txtBriefing;
    public TextField txtDate;
    public Button btnAddInvoice;

    private InvoiceService invoiceService;

    private ObservableList < Invoice > invoices = FXCollections.observableArrayList();
    public void setServices(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            invoices.addAll(invoiceService.getAll());
            tblInvoice.setItems(invoices);
        });
    }

    public void btnAddInvoiceClick(ActionEvent actionEvent) {
        try{
            String id = txtId.getText();
            double amount = Double.parseDouble( txtAmount.getText() );
            String briefing = txtBriefing.getText();
            String date = txtDate.getText();

            invoiceService.insert( id,amount, briefing, date );

            invoices.clear();
            invoices.addAll( invoiceService.getAll() );
        }
        catch (RuntimeException rex){
            Common.showValidationError( rex.getMessage() );
        }
    }
}
