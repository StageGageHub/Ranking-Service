package com.stagegage.rankingService.resource;

import com.stagegage.rankingService.dto.RankingDto;
import com.stagegage.rankingService.dto.reponse.RankingResponse;
import com.stagegage.rankingService.dto.request.RankingRequest;
import com.stagegage.rankingService.service.RankingService;
import com.stagegage.services.dto.ArtistDto;
import com.stagegage.services.dto.response.ArtistResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Scott on 7/13/14.
 *
 * @author Scott Hendrickson
 */
@RestController
@RequestMapping("/rankings")
public class RankingResource {

    @Autowired
    private RankingService rankingService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ArtistResponse> getRankings(@RequestParam(required = false) String genre,
                                           @RequestParam(required = false, defaultValue = "10") int num_rankings) {

        List<ArtistDto> artistDtos = rankingService.getTopRankings(genre, num_rankings);

        return ArtistResponse.getResponses(artistDtos);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public RankingResponse addRanking(@RequestBody RankingRequest rankingRequest) {

        RankingDto rankingDtos = rankingService.addRanking(rankingRequest);

        return RankingResponse.getResponses(rankingDtos);
    }

}
