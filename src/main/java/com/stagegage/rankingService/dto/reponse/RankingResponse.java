package com.stagegage.rankingService.dto.reponse;

import com.stagegage.festivalService.dto.response.ShowResponse;
import com.stagegage.rankingService.dto.RankingDto;

import java.util.List;

/**
 * Created by Scott on 7/13/14.
 *
 * @author Scott Hendrickson
 */
public class RankingResponse {

    private String festivalName;
    private List<ShowResponse> showResponses;

    public RankingResponse(String festivalName, List<ShowResponse> showResponses) {
        this.festivalName = festivalName;
        this.showResponses = showResponses;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public List<ShowResponse> getShowResponses() {
        return showResponses;
    }

    public static RankingResponse getResponses(RankingDto rankingDto) {
        if(rankingDto == null) return null;

        return new RankingResponse(rankingDto.getFestivalDto().getName(), rankingDto.getShowResponses());
    }
}
