import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class ListFlatterTest {

    private ListFlatter listFlatter;

    @BeforeEach
    void setup(){
        this.listFlatter = new ListFlatter();
    }

    @Test
    void addFlatList(){
        List <Object> testList = new ArrayList(asList("blabla", 1, 4, 4.0f, new Integer(5)));
        this.listFlatter.flatten(testList);
        assertEquals(this.listFlatter.getFlatArray(), testList);
    }

    @Test
    void checkNestedList() {
        Integer[] elem1 = {1, 3, 4, 5};
        Float[] elem2 = {0.9f, 1f, 7f};
        String[] elem3 = {"bla", "bla"};
        List<Object> testList = asList(elem1, elem2, elem3);
        this.listFlatter.flatten(testList);
        assertEquals("[1, 3, 4, 5, 0.9, 1.0, 7.0, bla, bla]", this.listFlatter.getFlatArray().toString());

    }

    @Test
    void checkDoublyNestedList(){
        Integer[] tab1 = {4, 5};
        Float[] tab2 = {9f, 18f};
        List <Object []> elem = new ArrayList<>(Arrays.asList(tab1, tab2));
        this.listFlatter.flatten(elem);
        assertEquals("[4, 5, 9.0, 18.0]", this.listFlatter.getFlatArray().toString() );
    }

    @Test
    void checkMapAsListElement(){
        Map map = new HashMap();
        List <Map> testList = new ArrayList<>();
        testList.add(map);
        this.listFlatter.flatten(testList);
        assertTrue(this.listFlatter.getFlatArray().get(0) instanceof UnknownObject);
    }

}