package pl.wlodarczyk.kolokwium.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FigureController {
    @GetMapping("/licz")
    public int licz(@RequestParam String figure, @RequestParam Integer height, @RequestParam Integer width, @RequestParam(required = false) Integer c ){
        if (figure.equalsIgnoreCase("Rectangle")){
            return 2*height + 2*width;
        }
        if (figure.equalsIgnoreCase("Triangle")){
            return height + width + c;
        }
        else
            return -1;
    }
}
