package dramaplays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import static org.approvaltests.Approvals.verify;

public class FactorPrinterTest {

    @Test
    void testPrintInvoiceNoPlay() {
        // Create an empty invoice
        Invoice invoice = new Invoice("Customer", new ArrayList<>());

        // Create an empty map of plays
        Map<String, Play> plays = new HashMap<>();

        // Create a FactorPrinter instance
        FactorPrinter printer = new FactorPrinter();

        // Verify that the result is as expected
        assertEquals("Factor for Customer\nAmount owed is $0.00\nYou earned 0 credits\n", printer.print(invoice, plays));
    }


    @Test
    void testWithNewPlayTypes() {

        HashMap<String, Play> plays = new HashMap<>();
        plays.put("henry-v",  new Play("Henry V", "history"));
        plays.put("as-like",  new Play("As You Like It", "pastoral"));

        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("henry-v", 53),
                new Performance("as-like", 55)));

        FactorPrinter factorPrinter = new FactorPrinter();
        assertThrows(Error.class, () -> {factorPrinter.print(invoice, plays);
        });
    }

    //comedy
    @Test
    void testPrintInvoicePlayComedy0Audience()
    {
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("as-like",  new Play("As You Like It", "comedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("as-like", 0)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  As You Like It: $300.00 (0 seats)\n" +
                "Amount owed is $300.00\n" +
                "You earned 0 credits\n");
    }
    @Test
    void testPrintInvoicePlayComedy20Audience()    {
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("as-like",  new Play("As You Like It", "comedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("as-like", 20)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  As You Like It: $360.00 (20 seats)\n" +
                "Amount owed is $360.00\n" +
                "You earned 4 credits\n");
    }
    @Test
    void testPrintInvoicePlayComedyLessThan20Audience()    {
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("as-like",  new Play("As You Like It", "comedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("as-like", 15)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  As You Like It: $345.00 (15 seats)\n" +
                "Amount owed is $345.00\n" +
                "You earned 3 credits\n");
    }
    @Test
    void testPrintInvoicePlayComedyMoreThan30Audience()    {
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("as-like",  new Play("As You Like It", "comedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("as-like", 60)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  As You Like It: $780.00 (60 seats)\n" +
                "Amount owed is $780.00\n" +
                "You earned 42 credits\n");
    }
    @Test
    void testPrintInvoicePlayComedyOver20Under30Audience()    {
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("as-like",  new Play("As You Like It", "comedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("as-like", 25)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  As You Like It: $500.00 (25 seats)\n" +
                "Amount owed is $500.00\n" +
                "You earned 5 credits\n");
    }

    @Test
    void testPrintInvoicePlayComedy21Audience()    {
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("as-like",  new Play("As You Like It", "comedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("as-like", 21)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  As You Like It: $468.00 (21 seats)\n" +
                "Amount owed is $468.00\n" +
                "You earned 4 credits\n");
    }

    //tragedy
    @Test
    void testPrintInvoicePlayTragedy0Audience()    {
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("hamlet",  new Play("Hamlet", "tragedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("hamlet", 0)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  Hamlet: $400.00 (0 seats)\n" +
                "Amount owed is $400.00\n" +
                "You earned 0 credits\n");
    }
    @Test
    void testPrintInvoicePlayTragedy30Audience(){
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("hamlet",  new Play("Hamlet", "tragedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("hamlet", 30)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  Hamlet: $400.00 (30 seats)\n" +
                "Amount owed is $400.00\n" +
                "You earned 0 credits\n");
    }
    @Test
    void testPrintInvoicePlayTragedyLessThan30Audience(){
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("hamlet",  new Play("Hamlet", "tragedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("hamlet", 15)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  Hamlet: $400.00 (15 seats)\n" +
                "Amount owed is $400.00\n" +
                "You earned 0 credits\n");
    }
    @Test
    void testPrintInvoicePlayTragedyMoreThan30Audience(){
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("hamlet",  new Play("Hamlet", "tragedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("hamlet", 60)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  Hamlet: $700.00 (60 seats)\n" +
                "Amount owed is $700.00\n" +
                "You earned 30 credits\n");
    }
    @Test
    void testPrintInvoicePlayTragedyOver20Under30Audience(){
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("hamlet",  new Play("Hamlet", "tragedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("hamlet", 25)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  Hamlet: $400.00 (25 seats)\n" +
                "Amount owed is $400.00\n" +
                "You earned 0 credits\n");
    }

    @Test
    void testPrintPlayTragedy31Audience(){
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("hamlet",  new Play("Hamlet", "tragedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("hamlet", 31)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  Hamlet: $410.00 (31 seats)\n" +
                "Amount owed is $410.00\n" +
                "You earned 1 credits\n");
    }
    //comedy and tragedy
    @Test
    void testPrintInvoicePlayTragedyandComedy0Audience()
    {
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("hamlet",  new Play("Hamlet", "tragedy"));
        plays.put("as-like",  new Play("As You Like It", "comedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("hamlet", 0),
                new Performance("as-like", 0)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  Hamlet: $400.00 (0 seats)\n" +
                "  As You Like It: $300.00 (0 seats)\n" +
                "Amount owed is $700.00\n" +
                "You earned 0 credits\n");
    }
    @Test
    void testPrintInvoicePlayTragedyandComedyOver30Audience()
    {
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("hamlet",  new Play("Hamlet", "tragedy"));
        plays.put("as-like",  new Play("As You Like It", "comedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("hamlet", 60),
                new Performance("as-like", 60)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  Hamlet: $700.00 (60 seats)\n" +
                "  As You Like It: $780.00 (60 seats)\n" +
                "Amount owed is $1,480.00\n" +
                "You earned 72 credits\n");
    }
    @Test
    void testPrintInvoicePlayTragedyandComedyOver20Under30Audience()    {
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("hamlet",  new Play("Hamlet", "tragedy"));
        plays.put("as-like",  new Play("As You Like It", "comedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("hamlet", 25),
                new Performance("as-like", 25)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  Hamlet: $400.00 (25 seats)\n" +
                "  As You Like It: $500.00 (25 seats)\n" +
                "Amount owed is $900.00\n" +
                "You earned 5 credits\n");
    }
    @Test
    void testPrintInvoicePlayTragedyandComedyUnder20Audience()    {
        HashMap<String, Play> plays = new HashMap<>();
        plays.put("hamlet",  new Play("Hamlet", "tragedy"));
        plays.put("as-like",  new Play("As You Like It", "comedy"));
        Invoice invoice = new Invoice("BigCo", List.of(new Performance("hamlet", 10),
                new Performance("as-like", 15)));
        FactorPrinter factorPrinter = new FactorPrinter();
        var result = factorPrinter.print(invoice, plays);
        assertEquals(result,"Factor for BigCo\n" +
                "  Hamlet: $400.00 (10 seats)\n" +
                "  As You Like It: $345.00 (15 seats)\n" +
                "Amount owed is $745.00\n" +
                "You earned 3 credits\n");
    }

}
