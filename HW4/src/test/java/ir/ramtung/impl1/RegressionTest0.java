import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test01() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test01");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        java.util.List<java.lang.String> strList1 = library0.availableTitles();
        // The following exception was thrown during execution in test generation
        try {
            library0.returnDocument("", "hi!");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: The document is not in member's loan");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strList1);
    }

    @Test
    public void test02() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test02");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        java.util.List<java.lang.String> strList1 = library0.availableTitles();
        // The following exception was thrown during execution in test generation
        try {
            int int3 = library0.getTotalPenalty("");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Cannot find member");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strList1);
    }

    @Test
    public void test03() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test03");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        // The following exception was thrown during execution in test generation
        try {
            library0.extend("", "");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: The document is not in member's loan");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test04() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test04");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        // The following exception was thrown during execution in test generation
        try {
            library0.addBook("", 100);
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Documents with empty title are not allowed");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test05() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test05");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        java.util.List<java.lang.String> strList1 = library0.availableTitles();
        // The following exception was thrown during execution in test generation
        try {
            int int3 = library0.getTotalPenalty("hi!");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Cannot find member");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strList1);
    }

    @Test
    public void test06() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test06");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        java.util.List<java.lang.String> strList1 = library0.availableTitles();
        // The following exception was thrown during execution in test generation
        try {
            library0.addReference("", (int) 'a');
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Documents with empty title are not allowed");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strList1);
    }

    @Test
    public void test07() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test07");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        // The following exception was thrown during execution in test generation
        try {
            library0.borrow("", "");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Cannot find document to borrow");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test08() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test08");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        java.lang.Class<?> wildcardClass3 = library0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass3);
    }

    @Test
    public void test09() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test09");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        // The following exception was thrown during execution in test generation
        try {
            library0.addMagazine("", (int) 'a', (int) (short) 0, 100);
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Documents with empty title are not allowed");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test10() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test10");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        java.util.List<java.lang.String> strList1 = library0.availableTitles();
        // The following exception was thrown during execution in test generation
        try {
            library0.extend("", "hi!");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: The document is not in member's loan");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strList1);
    }

    @Test
    public void test11() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test11");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        java.util.List<java.lang.String> strList1 = library0.availableTitles();
        // The following exception was thrown during execution in test generation
        try {
            library0.addBook("", (int) 'a');
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Documents with empty title are not allowed");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strList1);
    }

    @Test
    public void test12() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test12");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        // The following exception was thrown during execution in test generation
        try {
            library0.borrow("hi!", "");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Cannot find document to borrow");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test13() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test13");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        // The following exception was thrown during execution in test generation
        try {
            library0.returnDocument("hi!", "");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: The document is not in member's loan");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test14() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test14");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        java.util.List<java.lang.String> strList1 = library0.availableTitles();
        // The following exception was thrown during execution in test generation
        try {
            library0.extend("hi!", "");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: The document is not in member's loan");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strList1);
    }

    @Test
    public void test15() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test15");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        java.util.List<java.lang.String> strList1 = library0.availableTitles();
        // The following exception was thrown during execution in test generation
        try {
            library0.borrow("hi!", "hi!");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Cannot find document to borrow");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strList1);
    }

    @Test
    public void test16() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test16");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        java.util.List<java.lang.String> strList1 = library0.availableTitles();
        // The following exception was thrown during execution in test generation
        try {
            library0.borrow("", "hi!");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Cannot find document to borrow");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strList1);
    }

    @Test
    public void test17() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test17");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        // The following exception was thrown during execution in test generation
        try {
            library0.addProfMember("");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Empty member name not allowed");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test18() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test18");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        java.util.List<java.lang.String> strList1 = library0.availableTitles();
        java.lang.Class<?> wildcardClass2 = strList1.getClass();
        org.junit.Assert.assertNotNull(strList1);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test19() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test19");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        // The following exception was thrown during execution in test generation
        try {
            library0.addProfMember("");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Empty member name not allowed");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test20() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test20");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        library0.timePass(0);
        library0.addReference("hi!", (int) 'a');
        // The following exception was thrown during execution in test generation
        try {
            library0.addProfMember("");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Empty member name not allowed");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test21() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test21");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.timePass((int) ' ');
        // The following exception was thrown during execution in test generation
        try {
            library0.extend("", "hi!");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: The document is not in member's loan");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test22() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test22");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        java.util.List<java.lang.String> strList1 = library0.availableTitles();
        java.lang.Class<?> wildcardClass2 = library0.getClass();
        org.junit.Assert.assertNotNull(strList1);
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test23() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test23");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.timePass((int) ' ');
        // The following exception was thrown during execution in test generation
        try {
            library0.addProfMember("");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Empty member name not allowed");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test24() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test24");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        // The following exception was thrown during execution in test generation
        try {
            library0.extend("hi!", "");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: The document is not in member's loan");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test25() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test25");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        // The following exception was thrown during execution in test generation
        try {
            library0.borrow("hi!", "hi!");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Cannot find document to borrow");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test26() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test26");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        library0.timePass(0);
        // The following exception was thrown during execution in test generation
        try {
            library0.extend("", "hi!");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: The document is not in member's loan");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test27() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test27");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        // The following exception was thrown during execution in test generation
        try {
            library0.timePass((-1));
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Cannot go back in time");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test28() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test28");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        library0.timePass(0);
        library0.addReference("hi!", (int) 'a');
        library0.timePass((int) (byte) 100);
        java.util.List<java.lang.String> strList12 = library0.availableTitles();
        // The following exception was thrown during execution in test generation
        try {
            library0.returnDocument("hi!", "hi!");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: The document is not in member's loan");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strList12);
    }

    @Test
    public void test29() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test29");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        library0.addReference("hi!", (int) (byte) 10);
    }

    @Test
    public void test30() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test30");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        library0.timePass(0);
        library0.addReference("hi!", (int) 'a');
        library0.timePass((int) (short) 100);
        // The following exception was thrown during execution in test generation
        try {
            library0.addProfMember("");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Empty member name not allowed");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test31() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test31");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        library0.timePass(0);
        library0.addReference("hi!", (int) 'a');
        library0.timePass((int) (byte) 100);
        // The following exception was thrown during execution in test generation
        try {
            library0.addStudentMember("hi!", "");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Empty member name not allowed");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test32() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test32");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        library0.timePass(0);
        library0.addReference("hi!", (int) 'a');
        library0.timePass((int) (byte) 100);
        // The following exception was thrown during execution in test generation
        try {
            library0.addReference("hi!", (int) (short) 0);
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Negative or zero copies of a document cannot be added");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test33() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test33");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        java.lang.Class<?> wildcardClass5 = library0.getClass();
        org.junit.Assert.assertNotNull(wildcardClass5);
    }

    @Test
    public void test34() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test34");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        // The following exception was thrown during execution in test generation
        try {
            library0.extend("hi!", "hi!");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: The document is not in member's loan");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test35() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test35");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        // The following exception was thrown during execution in test generation
        try {
            library0.addStudentMember("", "");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Empty member name not allowed");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test36() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test36");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        library0.timePass(0);
        library0.addReference("hi!", (int) 'a');
        library0.timePass((int) (short) 100);
        // The following exception was thrown during execution in test generation
        try {
            library0.addReference("hi!", 10);
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.DuplicateDocumentEx; message: Document with the same title exists");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test37() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test37");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.timePass((int) ' ');
        // The following exception was thrown during execution in test generation
        try {
            library0.extend("", "");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: The document is not in member's loan");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test38() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test38");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        // The following exception was thrown during execution in test generation
        try {
            library0.addBook("", (int) (byte) 0);
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: Documents with empty title are not allowed");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
    }

    @Test
    public void test39() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test39");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        java.util.List<java.lang.String> strList1 = library0.availableTitles();
        // The following exception was thrown during execution in test generation
        try {
            library0.returnDocument("hi!", "hi!");
            org.junit.Assert.fail("Expected exception of type ir.ramtung.impl1.InvalidArgumentEx; message: The document is not in member's loan");
        } catch (ir.ramtung.sts01.LibraryException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(strList1);
    }

    @Test
    public void test40() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test40");
        ir.ramtung.impl1.Library library0 = new ir.ramtung.impl1.Library();
        library0.addProfMember("hi!");
        library0.timePass(100);
        int int6 = library0.getTotalPenalty("hi!");
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 0 + "'", int6 == 0);
    }
}

