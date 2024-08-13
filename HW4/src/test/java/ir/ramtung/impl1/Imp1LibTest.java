package ir.ramtung.impl1;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import ir.ramtung.sts01.LibraryException;
import org.junit.runner.RunWith;
import java.util.List;


import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;
import org.junit.Before;

import ir.ramtung.sts01.LibraryException;

@RunWith(JUnitQuickcheck.class)
public class Imp1LibTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Property
    public void testAddStudentMember(String studentId, String studentName) {
        try {
            library.addStudentMember(studentId, studentName);
        } catch (LibraryException e) {
            if (studentId.isEmpty() || studentName.isEmpty()) {
                assert(e instanceof InvalidArgumentEx);
            } else {
                assert(e instanceof DuplicateMemberEx);
            }
        }
    }

    @Property
    public void testAddProfMember(String profName) {
        try {
            library.addProfMember(profName);
        } catch (LibraryException e) {
            if (profName.isEmpty()) {
                assert(e instanceof InvalidArgumentEx);
            } else {
                assert(e instanceof DuplicateMemberEx);
            }
        }
    }

    @Property
    public void testAddBook(String title, int copies) {
        try {
            library.addBook(title, copies);
        } catch (LibraryException e) {
            if (title.isEmpty() || copies <= 0) {
                assert(e instanceof InvalidArgumentEx);
            } else {
                assert(e instanceof DuplicateDocumentEx);
            }
        }
    }

    @Property
    public void testAddMagazine(String title, int year, int number, int copies) {
        try {
            library.addMagazine(title, year, number, copies);
        } catch (LibraryException e) {
            if (title.isEmpty() || year <= 0 || number <= 0 || copies <= 0) {
                assert(e instanceof InvalidArgumentEx);
            } else {
                assert(e instanceof DuplicateDocumentEx);
            }
        }
    }

    @Property
    public void testAddReference(String title, int copies) {
        try {
            library.addReference(title, copies);
        } catch (LibraryException e) {
            if (title.isEmpty() || copies <= 0) {
                assert(e instanceof InvalidArgumentEx);
            } else {
                assert(e instanceof DuplicateDocumentEx);
            }
        }
    }

    @Property
    public void testBorrow(String memberName, String documentTitle) {
        try {
            library.borrow(memberName, documentTitle);
        } catch (LibraryException e) {
            if (memberName.isEmpty() || documentTitle.isEmpty()) {
                assert(e instanceof InvalidArgumentEx);
            } else {
                assert(e instanceof CannotBorrowEx);
            }
        }
    }

    @Property
    public void testExtend(String memberName, String documentTitle) {
        try {
            library.extend(memberName, documentTitle);
        } catch (LibraryException e) {
            if (memberName.isEmpty() || documentTitle.isEmpty()) {
                assert(e instanceof InvalidArgumentEx);
            } else {
                assert(e instanceof CannotExtendEx);
            }
        }
    }

    @Property
    public void testReturnDocument(String memberName, String documentTitle) {
        try {
            library.returnDocument(memberName, documentTitle);
        } catch (LibraryException e) {
            if (memberName.isEmpty() || documentTitle.isEmpty()) {
                assert(e instanceof InvalidArgumentEx);
            }
        }
    }

    @Property
    public void testTotalPenalty(String memberName) {
        try {
            int penalty = library.getTotalPenalty(memberName);
            assert(penalty >= 0);
        } catch (LibraryException e) {
            if (memberName.isEmpty()) {
                assert(e instanceof InvalidArgumentEx);
            }
        }
    }

    @Property
    public void testTimePass(int days) {
        try {
            library.timePass(days);
        } catch (LibraryException e) {
            if (days < 0) {
                assert(e instanceof InvalidArgumentEx);
            }
        }
    }

    @Property
    public void testAvailableTitles() {
        List<String> titles = library.availableTitles();
        assert(titles != null);
    }
    @Property
    public void illegalityOfExtendAtDayOfBorrowing(String memberName, String documentTitle)
    {
        try {
            library.borrow(memberName,documentTitle);
        } catch (LibraryException ignored) {
            return;
        }

        try {
            library.extend(memberName,documentTitle);
            fail("Expected exception while extending at day of borrowing");
        } catch (LibraryException ignored) {
        } catch (Exception ignored) {
            fail("Got an unexpected error");
        }
    }


    @Property
    public void checkExtend() throws InvalidArgumentEx, DuplicateMemberEx, CannotBorrowEx, DuplicateDocumentEx, CannotExtendEx {
        Library library = new Library();
        library.addStudentMember("st1", "124");
        library.addStudentMember("st2", "123");
        library.addBook("Batman", 2);
        library.borrow("124", "Batman");
        library.timePass(1);
        library.extend("124", "Batman");
        library.timePass(1);
        library.extend("124", "Batman");

        try {
            library.extend("124", "Batman");
            fail("Expected exception while extending more than twice");
        } catch (CannotExtendEx ignored) {
        } catch (LibraryException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Property
    public void checkExtendOnce() throws InvalidArgumentEx, DuplicateMemberEx, CannotBorrowEx, DuplicateDocumentEx, CannotExtendEx {
        Library library = new Library();
        library.addStudentMember("st1", "124");
        library.addStudentMember("st2", "123");
        library.addBook("Batman", 2);
        library.borrow("124", "Batman");
        library.timePass(1);
        library.extend("124", "Batman");

        try {
            library.extend("124", "Batman");
        } catch (LibraryException e) {
            fail("Unexpected exception while extending for the second time: " + e.getMessage());
        }
    }

    @Property
    public void checkNoExtend() throws InvalidArgumentEx, DuplicateMemberEx, CannotBorrowEx, DuplicateDocumentEx {
        Library library = new Library();
        library.addStudentMember("st1", "124");
        library.addStudentMember("st2", "123");
        library.addBook("Batman", 2);
        library.borrow("124", "Batman");

        try {
            library.timePass(1);
            // No extend operation performed here
        } catch (LibraryException e) {
            fail("Unexpected exception while time passing without extending: " + e.getMessage());
        }
    }

    @Property
    public void checkExtendBeforeBorrow() throws InvalidArgumentEx, DuplicateMemberEx, DuplicateDocumentEx {
        Library library = new Library();
        library.addStudentMember("st1", "124");
        library.addBook("Batman", 2);

        try {
            library.extend("124", "Batman");
            fail("Expected exception while extending a book before borrowing it");
        } catch (CannotExtendEx ignored) {
        } catch (LibraryException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }


    @Property
    public void checkExtendForMagazine() throws InvalidArgumentEx, DuplicateMemberEx, CannotBorrowEx, DuplicateDocumentEx {
        Library library = new Library();
        library.addStudentMember("st1", "124");
        library.addMagazine("Magazine", 1400, 1,10);
        try {
            library.extend("124", "Magazine");
            fail("Expected exception while extending a magazine");
        } catch (CannotExtendEx ignored) {
        } catch (LibraryException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Property
    public void checkPenaltyForReferenceBook() throws InvalidArgumentEx, DuplicateMemberEx, CannotBorrowEx, DuplicateDocumentEx {
        Library library = new Library();
        library.addStudentMember("st1", "124");
        library.addReference("ReferenceBook", 1);
        library.borrow("124", "ReferenceBook");

        // Time passes to create a late return scenario
        library.timePass(8); // 3 days late

        try {
            int penalty = library.getTotalPenalty("124");
            int expectedPenalty = (3 * 5000); // 3 days * 5000
            assertEquals(expectedPenalty, penalty);
        } catch (LibraryException e) {
            fail("Got exception while calculating penalty for reference book: " + e.getMessage());
        }

        library.timePass(2); // 5 days late in total

        try {
            int penalty = library.getTotalPenalty("124");
            int expectedPenalty = (3 * 5000) + (2 * 7000); // 3 days * 5000 + 2 days * 7000
            assertEquals(expectedPenalty, penalty);
        } catch (LibraryException e) {
            fail("Got exception while calculating penalty for reference book: " + e.getMessage());
        }
    }

    @Property
    public void checkPenaltyForOrdinaryBook() throws InvalidArgumentEx, DuplicateMemberEx, CannotBorrowEx, DuplicateDocumentEx {
        Library library = new Library();
        library.addStudentMember("st1", "124");
        library.addBook("OrdinaryBook", 1);
        library.borrow("124", "OrdinaryBook");

        // Time passes to create a late return scenario
        library.timePass(17); // 7 days late

        try {
            int penalty = library.getTotalPenalty("124");
            int expectedPenalty = (7 * 2000); // 7 days * 2000
            assertEquals(expectedPenalty, penalty);
        } catch (LibraryException e) {
            fail("Got exception while calculating penalty for ordinary book: " + e.getMessage());
        }

        library.timePass(7); // 14 days late in total

        try {
            int penalty = library.getTotalPenalty("124");
            int expectedPenalty = (7 * 2000) + (7 * 3000); // 7 days * 2000 + 7 days * 3000
            assertEquals(expectedPenalty, penalty);
        } catch (LibraryException e) {
            fail("Got exception while calculating penalty for ordinary book: " + e.getMessage());
        }

        library.timePass(10); // 24 days late in total

        try {
            int penalty = library.getTotalPenalty("124");
            int expectedPenalty = (7 * 2000) + (14 * 3000) + (3 * 5000); // 7 days * 2000 + 14 days * 3000 + 3 days * 5000
            assertEquals(expectedPenalty, penalty);
        } catch (LibraryException e) {
            fail("Got exception while calculating penalty for ordinary book: " + e.getMessage());
        }
    }


    @Property
    public void testPenaltyForMultipleBooks()throws InvalidArgumentEx, DuplicateMemberEx, CannotBorrowEx, DuplicateDocumentEx {

    Library library = new Library();
    library.addProfMember("124");
    library.addBook("OrdinaryBook", 1);
    library.addBook("Book1", 5);
    library.addBook("Book2", 4);
    library.addBook("Book3", 3);
    library.borrow("124", "OrdinaryBook");
    library.borrow("124", "Book1");
    library.borrow("124", "Book2");
    library.borrow("124", "Book3");
    try {
        library.timePass(3); // Advance time to incur penalty
        library.returnDocument("124", "Book1");
        int penalty1 = library.getTotalPenalty("124");
        assertEquals(penalty1, 0); // Check penalty for each book

        library.timePass(3); // Advance time to incur penalty
        library.returnDocument("124", "Book2");
        int penalty2 = library.getTotalPenalty("124");
        assertEquals(penalty2, 0); // Check penalty for each book

        library.timePass(19); // Advance time to incur penalty
        library.returnDocument("124", "Book3");
        library.returnDocument("124", "OrdinaryBook");
        int penalty3 = library.getTotalPenalty("124");
        assertEquals(penalty3, 7 * 2000 + 11 * 3000); // Check penalty for each book
    } catch (LibraryException e) {
            fail("Got exception while calculating penalty for magazine before 1390: " + e.getMessage());
        }
    }
    @Property
    public void checkPenaltyForMagazineBefore1390() throws InvalidArgumentEx, DuplicateMemberEx, CannotBorrowEx, DuplicateDocumentEx {
        Library library = new Library();
        library.addStudentMember("st1", "124");
        library.addMagazine("MagazineBefore1390", 1, 1389,10);
        library.borrow("124", "MagazineBefore1390");

        // Time passes to create a late return scenario
        library.timePass(4); // 2 days late

        try {
            int penalty = library.getTotalPenalty("124");
            int expectedPenalty = 2 * 2000; // 2 days * 2000
            assertEquals(expectedPenalty, penalty);
        } catch (LibraryException e) {
            fail("Got exception while calculating penalty for magazine before 1390: " + e.getMessage());
        }
    }

    @Property
    public void checkPenaltyForMagazineAfter1390() throws InvalidArgumentEx, DuplicateMemberEx, CannotBorrowEx, DuplicateDocumentEx {
        Library library = new Library();
        library.addStudentMember("st1", "124");
        library.addMagazine("MagazineAfter1390", 1, 1391,10);
        library.borrow("124", "MagazineAfter1390");

        // Time passes to create a late return scenario
        library.timePass(4); // 2 days late

        try {
            int penalty = library.getTotalPenalty("124");
            int expectedPenalty = 2 * 3000; // 2 days * 3000
            assertEquals(expectedPenalty, penalty);
        } catch (LibraryException e) {
            fail("Got exception while calculating penalty for magazine after 1390: " + e.getMessage());
        }
    }

    @Property
    public void testProfessorBorrowLimit() throws InvalidArgumentEx, DuplicateMemberEx, DuplicateDocumentEx {
        Library library = new Library();
        library.addProfMember("Prof. Ali");
        library.addBook("Book1", 1);
        library.addBook("Book2", 1);
        library.addBook("Book3", 1);
        library.addBook("Book4", 1);
        library.addBook("Book5", 1);
        library.addBook("Book6", 1);

        try {
            library.borrow("Prof. Ali", "Book1");
            library.borrow("Prof. Ali", "Book2");
            library.borrow("Prof. Ali", "Book3");
            library.borrow("Prof. Ali", "Book4");
            library.borrow("Prof. Ali", "Book5");
        } catch (CannotBorrowEx e) {
            fail("Professor should be able to borrow up to 5 books.");
        } catch (LibraryException e) {
            fail("Unexpected exception: " + e.getMessage());
        }

        try {
            library.borrow("Prof. Ali", "Book6");
            fail("Expected exception when borrowing more than 5 books.");
        } catch (CannotBorrowEx e) {
            // Expected exception
        } catch (LibraryException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Property
    public void testStudentBorrowLimit() throws InvalidArgumentEx, DuplicateMemberEx, DuplicateDocumentEx {
        Library library = new Library();
        library.addStudentMember("st1", "Student Ali");
        library.addBook("Book1", 1);
        library.addBook("Book2", 1);
        library.addBook("Book3", 1);

        try {
            library.borrow("Student Ali", "Book1");
            library.borrow("Student Ali", "Book2");
        } catch (CannotBorrowEx e) {
            fail("Student should be able to borrow up to 2 books.");
        } catch (LibraryException e) {
            fail("Unexpected exception: " + e.getMessage());
        }

        try {
            library.borrow("Student Ali", "Book3");
            fail("Expected exception when borrowing more than 2 books.");
        } catch (CannotBorrowEx e) {
            // Expected exception
        } catch (LibraryException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Property
    public void testMultipleCopiesAvailability() throws InvalidArgumentEx, DuplicateMemberEx, DuplicateDocumentEx {
        Library library = new Library();
        library.addStudentMember("st1", "Student1");
        library.addStudentMember("st2", "Student2");
        library.addStudentMember("st3", "Student3");
        library.addBook("Book", 2); // Adding 2 copies of the book

        try {
            // Two students borrow the same book
            library.borrow("Student1", "Book");
            library.borrow("Student2", "Book");
        } catch (CannotBorrowEx e) {
            fail("Two students should be able to borrow two copies of the same book.");
        } catch (LibraryException e) {
            fail("Unexpected exception: " + e.getMessage());
        }

        try {
            // A third student tries to borrow the book but all copies are on loan
            library.borrow("Student3", "Book");
            fail("Expected exception when borrowing a book with all copies on loan.");
        } catch (CannotBorrowEx e) {
            // Expected exception
        } catch (LibraryException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
