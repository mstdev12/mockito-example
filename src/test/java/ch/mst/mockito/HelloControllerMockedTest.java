package ch.mst.mockito;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class HelloControllerMockedTest {

    @InjectMocks
    HelloController helloController;

    @Mock
    HelloService helloService;
    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        helloController = new HelloController(helloService);
    }

    @Test
    void helloWorld() {
        when(helloService.getAText(eq("myText"))).thenReturn("somethingElse");

        String greeting = helloController.hello("myName");

        assertThat(greeting).isEqualTo("Hello, myName somethingElse");

        verify(helloService).getAText(anyString());
        verifyNoMoreInteractions(helloService);
    }
}
