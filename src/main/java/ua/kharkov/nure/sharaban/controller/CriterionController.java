package ua.kharkov.nure.sharaban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.kharkov.nure.sharaban.enums.CriterionScaleType;
import ua.kharkov.nure.sharaban.enums.CriterionType;
import ua.kharkov.nure.sharaban.model.Criterion;
import ua.kharkov.nure.sharaban.service.CriterionService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/criteria")
public class CriterionController {

    @Autowired
    private CriterionService criterionService;

    private List<String> types;

    private List<String> scaleTypes;

    public CriterionController() {
        initialize();
    }

    private void initialize() {
        types = new ArrayList<>();
        types.add(CriterionType.QUALITY);
        types.add(CriterionType.QUANTITY);

        scaleTypes = new ArrayList<>();
        scaleTypes.add(CriterionScaleType.NUMBER);
        scaleTypes.add(CriterionScaleType.MARK);
        scaleTypes.add(CriterionScaleType.RANK);
        scaleTypes.add(CriterionScaleType.INTERVAL);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String view(ModelMap model) {
        List<Criterion> criteria = criterionService.getAllCriteria();
        model.addAttribute("criteria", criteria);

        return "criteria";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getEditPage(ModelMap model) {
        model.addAttribute("types", types);
        model.addAttribute("scaleTypes", scaleTypes);

        return "criterion_edit";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String getEditPage(@PathVariable long id, ModelMap model) {
        Criterion criterion = criterionService.getCriterionById(id);
        model.addAttribute("criterion", criterion);
        model.addAttribute("types", types);
        model.addAttribute("scaleTypes", scaleTypes);

        return "criterion_edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String add(@ModelAttribute Criterion criterion) {
        criterionService.saveOrUpdateCriterion(criterion);

        return "redirect:/criteria";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        criterionService.deleteCriterion(id);

        return "redirect:/criteria";
    }
}
