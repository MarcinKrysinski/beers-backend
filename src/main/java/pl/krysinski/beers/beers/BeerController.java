package pl.krysinski.beers.beers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.krysinski.beers.beers.model.BeersInfo;

@RestController
public class BeerController {

    private BeersInfo[] getBeersInfo(){
        RestTemplate restTemplate = new RestTemplate();
        BeersInfo[] beersInfoObject = restTemplate.getForObject("https://api.punkapi.com/v2/beers", BeersInfo[].class);
        return beersInfoObject;
    }

    @GetMapping("/beers-info")
    public BeersInfo[] get(){
        BeersInfo[] test = getBeersInfo();
        return test;
    }
}
