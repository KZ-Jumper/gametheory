package ua.kharkov.nure.sharaban.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kharkov.nure.sharaban.model.*;
import ua.kharkov.nure.sharaban.service.AlternativeService;
import ua.kharkov.nure.sharaban.service.MarkService;
import ua.kharkov.nure.sharaban.service.ResultService;

import java.util.List;

@Component
public class ConfirmLeaderGame {

    @Autowired
    private AlternativeService alternativeService;

    @Autowired
    private ResultService resultService;

    @Autowired
    private MarkService markService;

    public void confirmLeader(LPR user, int[] ids) {
        for (int id : ids) {
            Alternative alternative = alternativeService.getAlternativeById(id);
            int res = getDifference(alternative, user.getId());

            Result result = new Result();
            result.setAlternative(alternative);
            result.setRange(res);
            result.setLpr(user);
            resultService.saveOrUpdateResult(result);
        }

//        Alternative winner = alternatives.get(0);
//
//        int winnerRes = getDifference(winner, user.getId());
//
//        for (int i = 1; i < ids.length; i++) {
//            Alternative alternative = alternatives.get(i);
//            int res = getDifference(alternative, user.getId());
//            if (res > winnerRes) {
//                winner = alternative;
//                winnerRes = res;
//            }
//
//
//        }

    }

    private int getDifference(Alternative a, long userId) {
        List<Mark> marks = markService.findMarksByAlternativeIdAndUserId(a.getId(), userId);
        List<Build> builds = alternativeService.getBuildsByAlternativeId(a.getId());

        int markResult = 0;
        int buildResult = 0;
        for (Mark mark: marks) {
            int priority = mark.getRange();
            for (Build build: builds) {
                if (mark.getCriterion().getId() == build.getCriterion().getId()) {
                    markResult += mark.getMarkNumberEquivalent() * priority;
                    buildResult += build.getValue() * priority;
                }
            }
        }

        return Math.abs(markResult - buildResult);
    }
}
