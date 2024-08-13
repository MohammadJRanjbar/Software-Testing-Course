package dramaplays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

public class InvoiceTest {

    @Test
    public void testInvoiceCreation() {
        String customer = "Theater Company XYZ";

        // Create some sample performances
        Performance performance1 = new Performance("Hamlet", 1000);
        Performance performance2 = new Performance("Romeo and Juliet", 800);

        List<Performance> performances = new ArrayList<>();
        performances.add(performance1);
        performances.add(performance2);

        Invoice invoice = new Invoice(customer, performances);

        // Check if invoice is not null
        assertNotNull(invoice);

        // Check number of performances
        assertEquals(2, invoice.performances.size());

        assertEquals(customer, invoice.customer);
        assertEquals(performances, invoice.performances);
    }

    @Test
    public void testEmptyInvoice() {
        String customer = "Empty Theater";

        List<Performance> emptyPerformances = new ArrayList<>();
        Invoice emptyInvoice = new Invoice(customer, emptyPerformances);

        assertEquals(customer, emptyInvoice.customer);
        assertEquals(emptyPerformances, emptyInvoice.performances);
    }
}
