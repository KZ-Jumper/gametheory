package ua.kharkov.nure.sharaban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.kharkov.nure.sharaban.model.CriteriaMarkDTO;
import ua.kharkov.nure.sharaban.model.Criterion;
import ua.kharkov.nure.sharaban.model.Mark;
import ua.kharkov.nure.sharaban.service.CriterionService;
import ua.kharkov.nure.sharaban.service.MarkService;

import java.util.List;

@Controller
@RequestMapping("/decide")
public class DecisionController {

    @Autowired
    private CriterionService criterionService;

    @Autowired
    private MarkService markService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String view(ModelMap model) {
        List<Criterion> criteria = criterionService.getAllCriteria();
        model.addAttribute("criteria", criteria);

        return "decision";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam int[] marks) {
        List<Criterion> criteria = criterionService.getAllCriteria();
        for (int i = 0; i < criteria.size(); i++) {
            Mark mark = new Mark();
            mark.setCriterion(criteria.get(i));
            mark.setName("mark");
            mark.setMarkNumberEquivalent(marks[i]);
            markService.saveOrUpdateMark(mark);
        }

        return "redirect:/decide/methods";
    }

    @RequestMapping(value = "/methods", method = RequestMethod.GET)
    public String methods() {
        return "methods";
    }

    @RequestMapping(value = "/methods/{id}/result", method = RequestMethod.GET)
    public String view(@PathVariable int id, ModelMap model) {
        return "result";
    }
}
