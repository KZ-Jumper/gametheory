package ua.kharkov.nure.sharaban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.kharkov.nure.sharaban.method.ConfirmLeaderGame;
import ua.kharkov.nure.sharaban.model.*;
import ua.kharkov.nure.sharaban.service.*;
import ua.kharkov.nure.sharaban.service.decision.individual.IndividualDecisionHelper;
import ua.kharkov.nure.sharaban.service.normalization.MarkNormalizationService;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/decide")
@SessionAttributes("user")
public class DecisionController {

    @Autowired
    private CriterionService criterionService;

    @Autowired
    private MarkService markService;

    @Autowired
    private AlternativeService alternativeService;

    @Autowired
    private VectorService vectorService;

    @Autowired
    private ResultService resultService;

    @Autowired
    private MarkNormalizationService normalizationService;

    @Autowired
    private IndividualDecisionHelper individualDecisionHelper;

    @Autowired
    private ConfirmLeaderGame leaderGame;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String view(ModelMap model) {
        List<Alternative> alternatives = alternativeService.getAllAlternatives();
        Alternative first = alternatives.get(0);
        Alternative second = alternatives.get(1);
        model.addAttribute("altCount", 1);
        model.addAttribute("first", first);
        model.addAttribute("second", second);

        List<Vector> firstVectors = vectorService.findByAlternativeId(first.getId());
        List<Vector> secondVectors = vectorService.findByAlternativeId(second.getId());

        model.addAttribute("firstVectors", firstVectors);
        model.addAttribute("secondVectors", secondVectors);

        return "pairing";
    }

    @RequestMapping(value = "/compare", method = RequestMethod.POST)
    public String compare(@RequestParam int altCount,
                          @RequestParam int winnerId,
                          @RequestParam int firstId,
                          @RequestParam int secondId,
                          ModelMap model) {
        LPR user = (LPR) model.get("user");

        Alternative first = alternativeService.getAlternativeById(firstId);
        Alternative second = alternativeService.getAlternativeById(secondId);

        Alternative winner = first.getId() == winnerId ? first : second;

        Result result = resultService.findByAlternativeIdAndUserId(first.getId(), user.getId());
        if (result == null) {
            result = new Result();
        }
        result.setLpr(user);
        result.setAlternative(first);
        result.setWeight(result.getWeight() + (first.getId() == winnerId ? 1 : 0));
        resultService.saveOrUpdateResult(result);

        result = resultService.findByAlternativeIdAndUserId(second.getId(), user.getId());
        if (result == null) {
            result = new Result();
        }
        result.setLpr(user);
        result.setAlternative(second);
        result.setWeight(result.getWeight() + (second.getId() == winnerId ? 1 : 0));
        resultService.saveOrUpdateResult(result);

        List<Alternative> alternatives = alternativeService.getAllAlternatives();
        if (altCount == alternatives.size() - 1) {
            result = resultService.findByAlternativeIdAndUserId(winnerId, user.getId());
            result.setRange(1);
            resultService.saveOrUpdateResult(result);

            return "redirect:/decide/pairing-result";
        }

        model.addAttribute("altCount", ++altCount);
        model.addAttribute("first", winner);
        model.addAttribute("second", alternatives.get(altCount));

        List<Vector> firstVectors = vectorService.findByAlternativeId(first.getId());
        List<Vector> secondVectors = vectorService.findByAlternativeId(second.getId());

        model.addAttribute("firstVectors", firstVectors);
        model.addAttribute("secondVectors", secondVectors);

        return "pairing";
    }

    @RequestMapping("/pairing-result")
    public String resultPairing(ModelMap model) {
        List<Result> results = resultService.getAllResults();
        model.addAttribute("results", results);

        return "pairing-result";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam int[] marks,
                       ModelMap model,
                       HttpServletRequest request) {
        List<Alternative> alternatives = alternativeService.getAllAlternatives();
        List<Criterion> criteria = criterionService.getAllCriteria();
        for (Alternative alternative: alternatives) {
            for (int i = 0; i < criteria.size(); i++) {
                Mark mark = new Mark();
                int priority = Integer.valueOf(request.getParameter(criteria.get(i).getId() + "-priority"));
                mark.setCriterion(criteria.get(i));
                mark.setName("mark");
                mark.setMarkNumberEquivalent(marks[i]);

                normalizationService.doNormalization(alternative.getId(), criteria.get(i).getId(), mark);

                mark.setRange(priority);
                mark.setUser((LPR) model.get("user"));
                mark = markService.saveOrUpdateMark(mark);

                Vector vector = new Vector();
                vector.setAlternative(alternative);
                vector.setMark(mark);
                vectorService.saveOrUpdateVector(vector);
            }
        }

        model.addAttribute("alternatives", alternatives);

        return "methods";
    }

    @RequestMapping(value = "/methods", method = RequestMethod.GET)
    public String methods() {
        return "methods";
    }

    @RequestMapping(value = "/methods/{id}/result", method = RequestMethod.GET)
    public String view(@PathVariable int id, ModelMap model, @RequestParam(required = false) int[] ids) {
        LPR user = (LPR) model.get("user");

        if (id == 1) {
            individualDecisionHelper.makeDecision(user);
        } else if (id == 2) {
            leaderGame.confirmLeader(user, ids);
        }

        List<Result> results = resultService.getResultByUserId(user.getId());
        Collections.sort(results, new Comparator<Result>() {

            @Override
            public int compare(Result o1, Result o2) {
                return o1.getRange() - o2.getRange();
            }
        });
        model.addAttribute("results", results);

        return "result";
    }
}
