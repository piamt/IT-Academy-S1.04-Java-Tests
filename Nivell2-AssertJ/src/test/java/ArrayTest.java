import org.example.Address;
import org.example.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ArrayTest {

    @BeforeEach
    void init() {
    }

    @Test
    public void intArraysContainsExactly() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1,2, 3, 4, 5};

        assertThat(array1).containsExactly(array2);
    }

    @Test
    public void intArraysContains() {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2 = {1,2, 3, 4, 5, 6};

        assertThat(array1).contains(array2);
    }

    @Test
    public void verifyArrayListOrder() {
        String string = "Hello world!";
        Address address = new Address("city", "street");
        Person person = new Person("name", "surname", 16, address);

        List<Object> myList = new ArrayList<>();
        myList.add(address);
        myList.add(string);
        myList.add(person);

        assertThat(myList).containsExactly(address, string, person);
    }

    @Test
    public void verifyArrayListAnyOrder() {
        String string = "Hello world!";
        Address address = new Address("city", "street");
        Person person = new Person("name", "surname", 16, address);

        List<Object> myList = new ArrayList<>();
        myList.add(address);
        myList.add(string);
        myList.add(person);

        assertThat(myList).containsExactlyInAnyOrder(string, address, person);
    }

    @Test
    public void verifyArrayListAnyUniqueObject() {
        String string = "Hello world!";
        Address address = new Address("city", "street");
        Person person = new Person("name", "surname", 16, address);

        List<Object> myList = new ArrayList<>();
        myList.add(address);
        myList.add(string);
        myList.add(person);

        assertThat(myList).containsOnlyOnce(string);
    }

    @Test
    public void verifyArrayListDoesNotContainObject() {
        String string = "Hello world!";
        Address address = new Address("city", "street");
        Person person = new Person("name", "surname", 16, address);

        List<Object> myList = new ArrayList<>();
        myList.add(address);
        myList.add(string);

        assertThat(myList).doesNotContain(person);
    }

    @Test
    public void verifyKeyInMap() {
        Address address1 = new Address("city", "street");
        Address address2 = new Address("city2", "street2");
        Map<String, Address> map = new HashMap<>();
        map.put("a", address1);
        map.put("b", address2);

        assertThat(map).containsKey("a");
    }

    @Test
    public void verifyThrowsIndexOutOfBounds() {
        Address address = new Address("city", "street");
        Person person = new Person("name", "surname", 16, address);

        assertThatThrownBy(() -> {
            Address[] array = person.getAddress();
            Address address1 = array[1];
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 1 out of bounds for length 1");
    }

    @Test
    public void verifyEmptyOptional() {
        Optional<Address> empty = Optional.empty();
        assertThat(empty).isEmpty();
    }

    @AfterEach
    void tearDown() {
    }
}