package ch.mst.mockito;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getAText(String parameter) {
        return parameter + " bla";
    }
}
