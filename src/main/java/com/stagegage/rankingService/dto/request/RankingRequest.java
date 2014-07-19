package com.stagegage.rankingService.dto.request;

import com.stagegage.festivalService.dto.response.FestivalResponse;
import com.stagegage.festivalService.dto.response.ShowResponse;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Scott on 7/13/14.
 *
 * @author Scott Hendrickson
 */
public class RankingRequest {

    private String festivalName;
    private UUID[] showIds;


    public RankingRequest(String festivalName, UUID[] showIds) {
        this.festivalName = festivalName;
        this.showIds = showIds;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public UUID[] getShowIds() {
        return showIds;
    }

    public boolean matches(FestivalResponse festivalResponse) {
        if (!festivalName.equals(festivalResponse.getName()))
            return false;

        Set<UUID> validShows = new HashSet<UUID>();
        for(ShowResponse show : festivalResponse.getShows()) {
            validShows.add(show.getShowId());
        }

        Set<UUID> observedShows = new HashSet<UUID>();
        for(UUID id : showIds) {
            observedShows.add(id);
        }

        for(UUID id : showIds) {
            observedShows.remove(id);
            if(!validShows.remove(id)) {
                return false;
            }
        }

        if(!validShows.isEmpty())
            return false;

        return true;
    }
}
