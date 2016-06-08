package ua.kharkov.nure.sharaban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.kharkov.nure.sharaban.model.Alternative;
import ua.kharkov.nure.sharaban.model.LPR;
import ua.kharkov.nure.sharaban.service.AlternativeService;
import ua.kharkov.nure.sharaban.service.CriterionService;

import java.util.List;

@Controller
@RequestMapping("/alternatives")
public class AlternativeController {

    @Autowired
    private AlternativeService alternativeService;

    @Autowired
    private CriterionService criterionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String view(ModelMap model) {
        List<Alternative> alternatives = alternativeService.getAllAlternatives();
        model.addAttribute("alternatives", alternatives);

        return "alternatives";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getEditPage() {
        return "alternative_edit";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String getEditPage(@PathVariable long id, ModelMap model) {
        Alternative alternative = alternativeService.getAlternativeById(id);
        model.addAttribute("alternative", alternative);

        return "alternative_edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String add(@ModelAttribute Alternative alternative) {
        alternativeService.saveOrUpdateAlternative(alternative);

        return "redirect:/alternatives";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        alternativeService.deleteAlternative(id);

        return "redirect:/alternatives";
    }
}
