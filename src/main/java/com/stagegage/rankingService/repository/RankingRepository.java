package com.stagegage.rankingService.repository;

import com.stagegage.rankingService.dto.RankingDto;
import com.stagegage.rankingService.dto.request.RankingRequest;
import com.stagegage.services.dto.ArtistDto;

import java.util.List;

/**
 * Created by Scott on 7/13/14.
 *
 * @author Scott Hendrickson
 */
public class RankingRepository {


    public List<ArtistDto> getTopRankings(int num_rankings) {
        return null;
    }

    public List<ArtistDto> getTopRankingsByGenre(String genre, int num_rankings) {
        return null;
    }

    public RankingDto addRanking(RankingRequest rankingRequest) {
        return null;
    }
}
