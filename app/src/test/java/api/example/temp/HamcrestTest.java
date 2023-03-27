package api.example.temp;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
Core
anything - always matches, useful if you don’t care what the object under test is
describedAs - decorator to adding custom failure description
is - decorator to improve readability - see “Sugar”, below
Logical
allOf - matches if all matchers match, short circuits (like Java &&)
anyOf - matches if any matchers match, short circuits (like Java ||)
not - matches if the wrapped matcher doesn’t match and vice versa

Object
equalTo - test object equality using Object.equals
hasToString - test Object.toString
instanceOf, isCompatibleType - test type
notNullValue, nullValue - test for null
sameInstance - test object identity

Collections
array - test an array’s elements against an array of matchers
hasEntry, hasKey, hasValue - test a map contains an entry, key or value
hasItem, hasItems - test a collection contains elements
hasItemInArray - test an array contains an element

Number
closeTo - test floating point values are close to a given value
greaterThan, greaterThanOrEqualTo, lessThan, lessThanOrEqualTo - test ordering

Text
equalToIgnoringCase - test string equality ignoring case
equalToIgnoringWhiteSpace - test string equality ignoring differences in runs of whitespace
containsString, endsWith, startsWith - test string matching
 */
public class HamcrestTest {
    private static Logger LOG = LoggerFactory.getLogger(HamcrestTest.class);

    /**
     *  anything() : Creates a matcher that always matches, regardless of the examined object.
     */
    @Test
    public void test_anything() {
        LOG.info("Test for anything()");
        String name = "xyz";
        MatcherAssert.assertThat(name, Matchers.is(Matchers.anything()));
    }
    /**
     * hasEntry() :  Creates a matcher for Maps, matching when the examined
     * 			   Map contains at least one entry whose key equals the specified key
     * 			   and whose value equals the specified value.
     */
    @Test
    public void test_hasEntry() throws Exception {

        LOG.info("Test for hasEntry()");
        Integer id = 1;
        String val = "one";

        Map<Integer, String> testMap = new HashMap<>();
        testMap.put(id, val);
        MatcherAssert.assertThat(testMap, Matchers.hasEntry(1, "one"));
    }

    /**
     * anyOf() : Creates a matcher that matches if the examined object matches ANY of the specified matchers.
     *           For example: assertThat("myValue", anyOf(startsWith("foo"), containsString("Val")))
     */
    @Test
    public void test_anyOf() throws Exception {

        LOG.info("Test for anyOf()");
        String check = "It's a great day today!";
        MatcherAssert.assertThat(check, Matchers.anyOf(Matchers.containsString("great"), Matchers.containsString("bad")));

    }
    /**
     * instanceOf() : Creates a matcher that matches when the examined object is an instance of the specified type.
     */
    @Test
    public void test_instanceOf() throws Exception {
        LOG.info("Test for instanceOf()");
        Object string = "hello!";
        MatcherAssert.assertThat(string, Matchers.instanceOf(String.class));
    }

    /**
     * nullValue() :Creates a matcher that matches if examined object is null.
     For example: assertThat(cheese, is(nullValue())
     */
    @Test
    public void test_nullValue() throws Exception {

        LOG.info("Test for nullValue()");
        String nullString = null;
        MatcherAssert.assertThat(nullString, Matchers.nullValue());

    }

    /**
     * hasItem() : Creates a matcher that matches the item in the Iterable.
     */
    @Test
    public void test_hasItem() throws Exception {

        LOG.info("Test for hasItem()");
        List<String> testList = Arrays.asList("one","two","three","four");
        MatcherAssert.assertThat(testList, Matchers.hasItem("two"));
    }
    /**
     * hasItemInArray() : A shortcut to the frequently used hasItemInArray(equalTo(x)).
     */
    @Test
    public void test_hasItemInArray() throws Exception {

        LOG.info("Test for hasItemInArray()");
        Integer[] check = {1,2,3,4,5,6};
        MatcherAssert.assertThat(check, Matchers.hasItemInArray(2));
    }

    /**
     *  greaterThan(), greaterThanOrEqual() : Creates a matcher for comparison.
     */
    @Test
    public void test_greaterThan() throws Exception {

        LOG.info("Test for greaterThan() and greaterThanOrEqual()");
        int testValue = 5;
        MatcherAssert.assertThat(testValue, Matchers.is(Matchers.greaterThan(3)));
        MatcherAssert.assertThat(testValue, Matchers.is(Matchers.greaterThanOrEqualTo(5)));
    }

    /**
     * equalToIgnoringCase() : Creates a matcher of String that matches when the examined
     * 						 string is equal to the specified expectedString, ignoring case.
     */
    @Test
    public void test_equalToIgnoringCase() throws Exception {

        LOG.info("Test for equalToIgnoringCase()");
        String check = "hello";
        MatcherAssert.assertThat(check, Matchers.equalToIgnoringCase("heLLO"));
    }
}