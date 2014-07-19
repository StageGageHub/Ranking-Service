package com.stagegage.rankingService.dto;

import com.stagegage.festivalService.dto.FestivalDto;
import com.stagegage.festivalService.dto.response.ShowResponse;

import java.util.List;

/**
 * Created by Scott on 7/13/14.
 *
 * @author Scott Hendrickson
 */
public class RankingDto {

    private FestivalDto festivalDto;
    private List<ShowResponse> showResponses;

    public RankingDto(FestivalDto festivalDto, List<ShowResponse> showResponses) {
        this.festivalDto = festivalDto;
        this.showResponses = showResponses;
    }

    public FestivalDto getFestivalDto() {
        return festivalDto;
    }

    public List<ShowResponse> getShowResponses() {
        return showResponses;
    }
}
