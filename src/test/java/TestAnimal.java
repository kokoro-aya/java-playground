import org.example.Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAnimal {
    @Test
    void test1() {
        var animal = new Animal();
        assertEquals("Meow", animal.makeSound());
    }
}
