package vn.plusplus.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RadioService {

    @Autowired
    RestTemplate restTemplate;

    public Object getAPIUsingRestTemplate(){
        HttpEntity request = new HttpEntity(null);
        String url = "http://www.emprender15.com/RadioP/admin_RSwedEn/api/api.php?method=getRadios&api_key=eHJhZGlvcGVyZmVjdGFwcA&offset=0&limit=1000&is_feature=1";
        ResponseEntity<Object> response = restTemplate.exchange(url,
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<Object>() {
                });
        Object data = response.getBody();
        return data;
    }

}
