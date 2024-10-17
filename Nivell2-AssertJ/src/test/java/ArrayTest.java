import org.example.Address;
import org.example.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.com.github.dockerjava.core.dockerfile.DockerfileStatement;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ArrayTest {

    String string;
    Address address;
    Person person;

    @BeforeEach
    void init() {
        string = "Hello world!";
        address = new Address("city", "street");
        person = new Person("name", "surname", 16, address);
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
        List<Object> myList = new ArrayList<>();
        myList.add(address);
        myList.add(string);
        myList.add(person);

        assertThat(myList).containsExactly(address, string, person);
    }

    @Test
    public void verifyArrayListAnyOrder() {
        List<Object> myList = new ArrayList<>();
        myList.add(address);
        myList.add(string);
        myList.add(person);

        assertThat(myList).containsExactlyInAnyOrder(string, address, person);
    }

    @Test
    public void verifyArrayListAnyUniqueObject() {
        List<Object> myList = new ArrayList<>();
        myList.add(address);
        myList.add(string);
        myList.add(person);

        assertThat(myList).containsOnlyOnce(string);
    }

    @Test
    public void verifyArrayListDoesNotContainObject() {
        List<Object> myList = new ArrayList<>();
        myList.add(address);
        myList.add(string);

        assertThat(myList).doesNotContain(person);
    }

    @Test
    public void verifyKeyInMap() {
        Address address2 = new Address("city2", "street2");
        Map<String, Address> map = new HashMap<>();
        map.put("a", address);
        map.put("b", address2);

        assertThat(map).containsKey("a");
    }

    @Test
    public void verifyThrowsIndexOutOfBounds() {

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
        string = null;
        address = null;
        person = null;
    }
}