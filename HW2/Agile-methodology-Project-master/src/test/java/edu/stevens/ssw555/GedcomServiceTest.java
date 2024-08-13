package edu.stevens.ssw555;

import static org.junit.Assert.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class GedcomServiceTest {

    private HashMap<String, Individual> individuals;
    private HashMap<String, Family> families;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");


    @BeforeEach
    public void setUp() throws IOException
    {
        // Create a test input file with sample GEDCOM data
        Gedcom_Service.Nulify();
    }

    @AfterEach
    public void tear_down() throws IOException {
        // Create a test input file with sample GEDCOM data
        Gedcom_Service.Nulify();
    }

    @Test
    public void testBirthBeforeDeathValidFILEWithoutfile() throws ParseException, FileNotFoundException, IOException {
        individuals = new HashMap<>();

        Gedcom_Service.Nulify();

        Individual indi = new Individual("I1");
        indi.setBirth("01/01/1990");
        individuals.put(indi.getId(), indi);

        Gedcom_Service.birthBeforeDeath(individuals);

        // No exception means test passed
    }


    @Test
    public void test_Mr() throws ParseException, FileNotFoundException, IOException {
        individuals = new HashMap<>();
        families = new HashMap<>();
        Gedcom_Service.Nulify();

        Individual indi = new Individual("I1");
        Individual indi2 = new Individual("I2");
        indi.setSpouseOf("I2");
        individuals.put(indi.getId(), indi);
        Family f1 = new Family("f1");
        families.put(f1.getId(), f1);
        f1.setHusb(String.valueOf(indi));
        f1.setWife(String.valueOf(indi2));
        Gedcom_Service.Marriagebeforedivorce(individuals,families);

        // No exception means test passed
    }

    @Test
    public void testReadAndParseFile() throws IOException
    {
        Gedcom_Service.Nulify();
        String TEST_INPUT_FILE = "gedcom_test_family.ged";
        Gedcom_Service.readAndParseFile(TEST_INPUT_FILE);
        assertEquals(11, Gedcom_Service.individuals.size());
        assertEquals(4, Gedcom_Service.families.size());
    }

    @Test
    public void testBirthBeforeDeath() throws IOException, ParseException
    {
        Gedcom_Service.Nulify();
        String TEST_INPUT_FILE = "gedcom_test_file.ged";
        try
        {
            Gedcom_Service.readAndParseFile(TEST_INPUT_FILE);
            Gedcom_Service.birthBeforeDeath(Gedcom_Service.individuals);
        }catch (NullPointerException ignored) {}


    }


    @Test
    public void TestParser() throws IOException, ParseException
    {
        Gedcom_Service.Nulify();
        String TEST_INPUT_FILE = "gedcom_test_file.ged";
        try
        {
            Gedcom_Service.readAndParseFile(TEST_INPUT_FILE);
            Gedcom_Service.individuals.forEach((key, value) -> {
                if (value.getName() == null || value.getName().trim().isEmpty() ||
                        value.getBirth() == null || value.getBirth().trim().isEmpty() ||
                        value.getId() == null || value.getId().trim().isEmpty() ||
                        value.getSex() == null || value.getSex().trim().isEmpty()) {
                    fail(value.toString());
                }
            });
        }catch (NullPointerException ignored) {}


    }
    @Test
    public void testMarriageBeforeDivorce() throws IOException, ParseException
    {   Gedcom_Service.Nulify();
        String TEST_INPUT_FILE = "gedcom_test_file.ged";
        try
        {
            Gedcom_Service.readAndParseFile(TEST_INPUT_FILE);
            Gedcom_Service.Marriagebeforedivorce(Gedcom_Service.individuals, Gedcom_Service.families);

        }catch (NullPointerException ignored) {}
        TEST_INPUT_FILE = "EarlyDivorce.ged";
        try
        {
            Gedcom_Service.readAndParseFile(TEST_INPUT_FILE);
            Gedcom_Service.Marriagebeforedivorce(Gedcom_Service.individuals, Gedcom_Service.families);

        }catch (NullPointerException ignored) {}

    }

    @Test
    public void testAuntsandUnclesname() throws IOException, ParseException {
        Gedcom_Service.Nulify();
        String TEST_INPUT_FILE = "gedcom_test_familyUniqueFamilynameBySpousesError.ged";
        try
        {
            Gedcom_Service.readAndParseFile(TEST_INPUT_FILE);
            Gedcom_Service.AuntsandUnclesname(Gedcom_Service.families);
        }catch (NullPointerException ignored) {}

        TEST_INPUT_FILE = "gedcom_test_familyUniqueFamilynameBySpousesError.ged";
        try
        {
            Gedcom_Service.readAndParseFile(TEST_INPUT_FILE);
            Gedcom_Service.AuntsandUnclesname(Gedcom_Service.families);
        }catch (NullPointerException ignored) {}


    }

    @Test
    public void TestUniqueNames() throws IOException, ParseException {
        Gedcom_Service.Nulify();
        Gedcom_Service.readAndParseFile("gedcom_test_family.ged");
        Gedcom_Service.uniqueFamilynameBySpouses(Gedcom_Service.individuals, Gedcom_Service.families);
        try {
            Gedcom_Service.readAndParseFile("gedcom_test_family_Ma.ged");
            Gedcom_Service.uniqueFamilynameBySpouses(Gedcom_Service.individuals, Gedcom_Service.families);

        } catch (NullPointerException ignored) {}

    }
    @Test
    public void testbbeforem() throws IOException {
        Gedcom_Service.Nulify();
        String TEST_INPUT_FILE = "gedcom_test_family_BirthBeforeMarriageOfParent.ged";
        try
        {
            Gedcom_Service.readAndParseFile(TEST_INPUT_FILE);
            Gedcom_Service.birthbeforemarriageofparent(Gedcom_Service.individuals, Gedcom_Service.families);
        }catch (NullPointerException ignored) {}
        TEST_INPUT_FILE = "T.ged";
        try
        {
            Gedcom_Service.Nulify();
            Gedcom_Service.readAndParseFile(TEST_INPUT_FILE);
            Gedcom_Service.birthbeforemarriageofparent(Gedcom_Service.individuals, Gedcom_Service.families);

        }catch (NullPointerException ignored) {}

    }

    @Test
    public void testMaleLastname() throws IOException, ParseException {
        Gedcom_Service.Nulify();
        String TEST_INPUT_FILE = "gedcom_test_file.ged";
        Gedcom_Service.readAndParseFile(TEST_INPUT_FILE);
        try
        {
            Gedcom_Service.readAndParseFile(TEST_INPUT_FILE);
            Gedcom_Service.Malelastname(Gedcom_Service.families);
        }catch (NullPointerException ignored) {}

        TEST_INPUT_FILE = "gedcom_test_family_d.ged";
        Gedcom_Service.readAndParseFile(TEST_INPUT_FILE);
        try
        {
            Gedcom_Service.Nulify();
            Gedcom_Service.readAndParseFile(TEST_INPUT_FILE);
            Gedcom_Service.Malelastname(Gedcom_Service.families);
        }catch (NullPointerException ignored) {}
    }
    @Test
    public void testGetMonth()
    {
        assertEquals(Gedcom_Service.getMonth("JAN"), "01");
        assertEquals(Gedcom_Service.getMonth("FEB"), "02");
        assertEquals(Gedcom_Service.getMonth("MAR"), "03");
        assertEquals(Gedcom_Service.getMonth("APR"), "04");
        assertEquals(Gedcom_Service.getMonth("MAY"), "05");
        assertEquals(Gedcom_Service.getMonth("JUN"), "06");
        assertEquals(Gedcom_Service.getMonth("JUL"), "07");
        assertEquals(Gedcom_Service.getMonth("AUG"), "08");
        assertEquals(Gedcom_Service.getMonth("SEP"), "09");
        assertEquals(Gedcom_Service.getMonth("OCT"), "10");
        assertEquals(Gedcom_Service.getMonth("NOV"), "11");
        assertEquals(Gedcom_Service.getMonth("DEC"), "12");

    }
}

