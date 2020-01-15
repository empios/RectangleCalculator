package pl.wlodarczyk.kolokwium.reader;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.wlodarczyk.kolokwium.models.Retangle;
import pl.wlodarczyk.kolokwium.service.RetangleService;

@Service
public class RectangleReader {

    private RetangleService retangleService;

    @Autowired
    public RectangleReader(RetangleService retangleService) {
        this.retangleService = retangleService;
    }

    @Value("${a1}")
    private int a1;

    @Value("${a2}")
    private int a2;

    @Value("${b1}")
    private int b1;

    @Value("${b2}")
    private int b2;

    public RectangleReader() {
    }


    @EventListener(ApplicationReadyEvent.class)
    public void addRectangle(){

        Retangle retangle = new Retangle(a1, a2);
        retangleService.add(retangle);
        Retangle retangle2 = new Retangle(b1, b2);
        retangleService.add(retangle2);

    }


}
