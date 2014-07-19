package com.stagegage.rankingService.service;

import com.stagegage.festivalService.communication.FestivalServiceCommunicator;
import com.stagegage.festivalService.dto.response.FestivalResponse;
import com.stagegage.rankingService.dto.RankingDto;
import com.stagegage.rankingService.dto.request.RankingRequest;
import com.stagegage.rankingService.repository.RankingRepository;
import com.stagegage.services.dto.ArtistDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Scott on 7/13/14.
 *
 * @author Scott Hendrickson
 */
@Component
@Configuration
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    private FestivalServiceCommunicator festivalServiceCommunicator = new FestivalServiceCommunicator();


    public List<ArtistDto> getTopRankings(String genre, int num_rankings) {
        if (genre == null || StringUtils.isBlank(genre)) {
            return rankingRepository.getTopRankings(num_rankings);
        } else {
            return rankingRepository.getTopRankingsByGenre(genre, num_rankings);
        }
    }

    public RankingDto addRanking(RankingRequest rankingRequest) {

        FestivalResponse festivalResponse = festivalServiceCommunicator.getFestivalShows(rankingRequest.getFestivalName());

        if(rankingRequest.matches(festivalResponse)) {
            return rankingRepository.addRanking(rankingRequest);
        } else {
            return null;
        }
    }
}
