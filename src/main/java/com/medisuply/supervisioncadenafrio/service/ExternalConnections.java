package com.medisuply.supervisioncadenafrio.service;
import com.medisuply.supervisioncadenafrio.dto.EventDto;
import com.medisuply.supervisioncadenafrio.dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class ExternalConnections {

    private final RestTemplate restTemplate = new RestTemplate();


    private String apiUrl="http://127.0.0.1:8080";

    public void enviarAlerta(NotificationDTO notification) {
        String url = apiUrl + "/notifications";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<NotificationDTO> request = new HttpEntity<>(notification, headers);

        restTemplate.postForEntity(url, request, String.class);
    }
    public void enviarNormalidadTemperatura(EventDto eventdto) {
        String url = apiUrl + "/EnviarTrazabilidad";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<EventDto> request = new HttpEntity<>( eventdto,headers);
        restTemplate.postForEntity(url, request, String.class);
    }

}


