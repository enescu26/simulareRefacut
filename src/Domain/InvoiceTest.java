package Domain;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
class InvoiceTest {
    private Invoice InvoiceTest = new Invoice ("1", 20.5, "market", "13.04.2019");

@Test
    void getIDShouldReturnCorrectID(){
    assertEquals ("1", InvoiceTest.getId());
}
@Test
void setIDShouldSetCorrectly(){
    InvoiceTest.setId("2");
    assertEquals ("2", InvoiceTest.getId());
}
   @Test
    void getValueShouldReturnCorrectValue() {
    assertEquals( 20.5, InvoiceTest.getAmount() );
   }
   @Test
    void getDateReturnCorrectDate(){
    assertEquals( "13.04.2019", InvoiceTest.getDate() );
   }

    @Test
    void setValueShouldSetCorrectly(){
        InvoiceTest.setDate("15.12.2019");
        assertEquals(15.0, InvoiceTest.getAmount());
    }


    @Test
    void setDateShouldSetCorrectly() {
        InvoiceTest.setDate("05.12.2019");
        assertEquals("05.12.2019", InvoiceTest.getDate());
    }
}
