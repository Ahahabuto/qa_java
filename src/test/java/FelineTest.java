import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private static final String EXPECTED_FAMILY = "Кошачьи";
    private static final int EXPECTED_KITTENS_COUNT = 1;

    private Feline feline;

   @Before
   public void setUp() {
       feline = new Feline();
   }

    @Test
    public void eatMeatTest() throws Exception{
        feline.eatMeat();
        verify(feline, times(1)).getFood("Хищник");
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