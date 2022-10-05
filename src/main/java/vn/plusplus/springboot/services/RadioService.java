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

    public static void main(String[] args) {
        String path = "uploads/claim/2021101V01002DI0000004/ANOTHER_VEHICLE_THIRD_PARTY_DRIVING.png";
        int index = path.lastIndexOf("/");
        String pathString = path.substring(0, index);
        String fileName = "ABC".concat(path.substring(index + 1));
        String a = pathString.concat("/").concat(fileName);
        System.out.println(a);
    }


}
