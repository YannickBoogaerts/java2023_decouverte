package be.technifutur.decouverte.mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * code de test venant du site
 * https://www.swtestacademy.com/unit-testing-mockito/
 */
public class MockWithAnnotation {
    @Mock
    PeopleDAO peopleDAO;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testPeopleDAO(){
        Mockito.when(peopleDAO.getPeopleById(1)).thenReturn(new Person("John Doe", 21));
        Person p = peopleDAO.getPeopleById(1);
        assert (p.getName().equals("John Doe"));
        assert (p.getAge() == 21);
    }
}
