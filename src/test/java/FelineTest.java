import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private static final String EXPECTED_FAMILY = "Кошачьи";
    private static final int EXPECTED_KITTENS_COUNT = 1;
    private static final List<String> EXPECTED_FOOD = List.of("Животные", "Птицы", "Рыба");

    private Feline feline;

   @Before
   public void setUp() {
       feline = new Feline();
   }

    @Test
    public void eatMeatTest() throws Exception{
        List<String> food = feline.eatMeat();
        assertEquals(EXPECTED_FOOD, food);
    }

    @Test
    public void getFamilyTest() {
        assertEquals(EXPECTED_FAMILY, feline.getFamily());
    }

    @Test
    public void getKittensTest() {
        assertEquals(EXPECTED_KITTENS_COUNT, feline.getKittens());
    }

    @Test
    public void getKittensWithCountTest() {
        int kittensCount = 10;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}