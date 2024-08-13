package uniapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Passchecktest {

    // Not Mehman
    @Test
    public void testPassedAllPreNotMehman() {
        List<Record> records = Arrays.asList(
                new Record(1, 101, 12.0, false),
                new Record(1, 102, 15.0, false),
                new Record(1, 103, 10.0, false)
        );
        Course course = new Course(104, Arrays.asList(101, 102, 103));
        assertTrue(Passcheck.hasPassedPre(records, course));
    }

    @Test
    public void testPassedThereIsNoPreNotMehman() {
        List<Record> records = Arrays.asList(
                new Record(1, 101, 12.0, false),
                new Record(1, 102, 15.0, false)
        );
        Course course = new Course(104, new ArrayList<>());
        assertTrue(Passcheck.hasPassedPre(records, course));
    }

    @Test
    public void testPassedNotAllPreNotMehman() {
        List<Record> records = Arrays.asList(
                new Record(1, 101, 12.0, false),
                new Record(1, 102, 8.0, false),
                new Record(1, 103, 10.0, false)
        );
        Course course = new Course(104, Arrays.asList(101, 102, 103));
        assertFalse(Passcheck.hasPassedPre(records, course));
    }

    @Test
    public void testFailedCoursesThereIsNoPreNotMehmanScoreBt0And9() {
        List<Record> records = Arrays.asList(
                new Record(1, 101, 8.0, false),
                new Record(1, 102, 7.0, false)
        );
        Course course = new Course(104, new ArrayList<>());
        assertTrue(Passcheck.hasPassedPre(records, course));
    }


    // Mehman
    @Test
    public void testPassedNoPreMehman() {
        List<Record> records = Arrays.asList(
                new Record(1, 101, 12.0, true),
                new Record(1, 102, 15.0, true)
        );
        Course course = new Course(104, new ArrayList<>());
        assertTrue(Passcheck.hasPassedPre(records, course));
    }

    @Test
    public void testPassedAllPreMehman() {
        List<Record> records = Arrays.asList(
                new Record(1, 101, 12.0, true),
                new Record(1, 102, 15.0, true),
                new Record(1, 103, 13.0, true)
        );
        Course course = new Course(104, Arrays.asList(101, 102, 103));
        assertTrue(Passcheck.hasPassedPre(records, course));
    }

    @Test
    public void testPassedNotAllPreMehman() {
        List<Record> records = Arrays.asList(
                new Record(1, 101, 12.0, true),
                new Record(1, 102, 9.0, true),
                new Record(1, 103, 13.0, true)
        );
        Course course = new Course(104, Arrays.asList(101, 102, 103));
        assertFalse(Passcheck.hasPassedPre(records, course));
    }

    @Test
    public void testPassedNoPreMehmanScoreBt10And12() {
        List<Record> records = Arrays.asList(
                new Record(1, 101, 10.0, true),
                new Record(1, 102, 11.0, true)
        );
        Course course = new Course(104, new ArrayList<>());
        assertTrue(Passcheck.hasPassedPre(records, course));
    }

    // both Mehman and Not Mehman
    @Test
    public void testHasNoRecords() {
        List<Record> records = new ArrayList<>();
        Course course = new Course(104, Arrays.asList(101, 102, 103));
        assertFalse(Passcheck.hasPassedPre(records, course));
    }

    @Test
    public void testPreNotInRecords() {
        List<Record> records = Arrays.asList(
                new Record(1, 101, 12.0, false),
                new Record(1, 102, 15.0, false)
        );
        Course course = new Course(104, Arrays.asList(103, 104));
        assertFalse(Passcheck.hasPassedPre(records, course));
    }

}

