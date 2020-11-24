package com.epam.yoke.attender.dao;

import com.epam.yoke.attender.model.rq.AttenderEventBody;
import com.epam.yoke.attender.model.rs.AttenderEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotifierDao {

  @Value("${yoke.notify.url}")
  private String notifierUrl;

  @Autowired
  private RestTemplate restTemplate;

  public AttenderEventResponse addAttender(AttenderEventBody event) {
    ResponseEntity<AttenderEventResponse> response = restTemplate
        .postForEntity(notifierUrl + "/attender/", event, AttenderEventResponse.class);
    return response.getBody();
  }

  public void deleteAttender(String eventId, String email) {
    restTemplate.delete(notifierUrl + "/" + eventId + "/attender/" + email);
  }
}
