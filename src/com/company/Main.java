import Domain.InvoiceValidator;
import Repository.InvoiceRepository;
import Service.InvoiceService;
import UI.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start (Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "UI/MainController.fxml"));
        Parent root = fxmlLoader.load();

        InvoiceValidator invoiceValidator = new InvoiceValidator();
        InvoiceRepository invoiceRepository = new InvoiceRepository(invoiceValidator);
        InvoiceService invoiceService = new InvoiceService( invoiceRepository );
        invoiceService.insert ("1", 12.50, "market", "05.11.2000");

        MainController  mainController = fxmlLoader.getController();
        mainController.setServices( invoiceService );

        primaryStage.setTitle( "Invoice Manager" );
        primaryStage.setScene( new Scene( root, 600, 500 ) );
        primaryStage.show();
    }
    public static void main (String[] args){launch( args );}
}
