package ua.kharkov.nure.sharaban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.kharkov.nure.sharaban.method.ConfirmLeaderGame;
import ua.kharkov.nure.sharaban.model.*;
import ua.kharkov.nure.sharaban.service.AlternativeService;
import ua.kharkov.nure.sharaban.service.CriterionService;
import ua.kharkov.nure.sharaban.service.MarkService;
import ua.kharkov.nure.sharaban.service.VectorService;
import ua.kharkov.nure.sharaban.service.decision.individual.IndividualDecisionHelper;
import ua.kharkov.nure.sharaban.service.normalization.MarkNormalizationService;

import javax.servlet.http.HttpServletRequest;
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
    private MarkNormalizationService normalizationService;

    @Autowired
    private IndividualDecisionHelper individualDecisionHelper;

    @Autowired
    private ConfirmLeaderGame leaderGame;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String view(ModelMap model) {
        List<Criterion> criteria = criterionService.getAllCriteria();
        model.addAttribute("criteria", criteria);

        return "decision";
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
                mark.setRange(priority);
                mark.setUser((LPR) model.get("user"));
                mark = markService.saveOrUpdateMark(mark);

                Vector vector = new Vector();
                vector.setAlternative(alternative);
                vector.setMark(mark);
                vectorService.saveOrUpdateVector(vector);
            }
        }

        return "redirect:/decide/methods";
    }

    @RequestMapping(value = "/methods", method = RequestMethod.GET)
    public String methods() {
        return "methods";
    }

    @RequestMapping(value = "/methods/{id}/result", method = RequestMethod.GET)
    public String view(@PathVariable int id, ModelMap model) {
        if (id == 1) {
            List<Alternative> alternatives = alternativeService.getAllAlternatives();

            //normalizationService.doNormalization();
            individualDecisionHelper.makeDecision((LPR) model.get("user"));
        } else if (id == 2) {
            leaderGame.confirmLeader((LPR) model.get("user")); //TODO stub
        }

        return "result";
    }
}
