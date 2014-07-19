package com.stagegage.rankingService.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stagegage.rankingService.dto.RankingDto;
import com.stagegage.rankingService.dto.request.RankingRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.Arrays;

/**
 * Created by Scott on 7/13/14.
 *
 * @author Scott Hendrickson
 */
@Component
public class ServiceCommunicator {


    public RankingDto verifyWithFestivalService(RankingRequest rankingRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        RestTemplate template = new RestTemplate();

        ObjectMapper mapper = new ObjectMapper();
        HttpEntity<String> requestEntity = null;

        try {
            requestEntity = new HttpEntity<String>(
                    mapper.writeValueAsString(rankingRequest), headers);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        ResponseEntity<RankingDto> entity = template.postForEntity(
                "http://localhost:8080/festivals/" + URLEncoder.encode(rankingRequest.getFestivalName() + "/checkShows"),
                requestEntity, RankingDto.class);


        return entity.getBody();
    }
}
