package be.nielsdelestinne.goldenempire.api.land;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = LandResource.LAND_BASE_URL)
public class LandResource {

    static final String LAND_BASE_URL = "/api/lands";

    @RequestMapping(
            value = "/test-land",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getTestLand() {
        return "Hello, I'm testland!";
    }

}
