import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private static final String MALE = "Самец";
    private static final String TEXT_OF_EXCEPTION = "Используйте допустимые значения пола животного - самец или самка";
    private static final List<String> FOOD = List.of("Животные", "Птицы", "Рыба");
    private static final String UNSUPPORTED_SEX = "Неподдерживаемый пол";

    @Mock
    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion(feline, MALE);
    }

    @Test
    public void getKittensTest() {
        int kittensCount = 7;
        when(feline.getKittens()).thenReturn(kittensCount);
        assertThat(lion.getKittens()).isEqualTo(kittensCount);
    }

    @Test

    public void getKittensFelineTest() {
        lion.getKittens();
        verify(feline).getKittens();
    }

    @Test
    public void doesHaveManeExceptionTest() {
        Throwable throwable = catchThrowable(() -> new Lion(feline, UNSUPPORTED_SEX));
        assertThat(throwable).isInstanceOf(Exception.class).hasMessage(TEXT_OF_EXCEPTION);
    }

    @Test
    public void getFoodTest() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(FOOD);
        assertThat(lion.getFood()).isEqualTo(FOOD);
    }

    @Test
    public void getFoodFelineTest() throws Exception {
        lion.getFood();
        verify(feline).getFood("Хищник");
    }
}