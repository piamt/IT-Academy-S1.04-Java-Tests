import org.example.Address;
import org.example.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    Address address;
    Person expected;
    Person actual;

    @BeforeEach
    void init() {
        address = new Address("Viladecans", "Francesc Macia");
        expected = new Person("mario", "perez", 30, address);
        actual = new Person("mario", "perez", 30, address);
    }

    @Test
    public void compareEqualPerson() {
        assertThat(actual)
                .isNotEqualTo(expected);
    }

    @Test
    public void compareNotEqualPerson() {
        expected.setName("antonio");
        assertThat(actual)
                .isNotEqualTo(expected);
    }

    @Test
    public void compareSamePerson() {
        Person expectedRef = actual;
        assertThat(actual)
                .isSameAs(expectedRef);
    }

    @Test
    public void compareNotSamePerson() {
        assertThat(actual)
                .isNotSameAs(expected);
    }

    @AfterEach
    void tearDown() {
        address = null;
        expected = null;
        actual = null;
    }
}
