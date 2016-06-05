package ua.kharkov.nure.sharaban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.kharkov.nure.sharaban.model.Alternative;
import ua.kharkov.nure.sharaban.model.Build;
import ua.kharkov.nure.sharaban.model.Criterion;
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
    public String getEditPage(ModelMap model) {
        List<String> names = criterionService.getAllCriteriaNames();
        model.addAttribute("criteria", names);

        return "alternative_edit";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String getEditPage(@PathVariable long id, ModelMap model) {
        Alternative alternative = alternativeService.getAlternativeById(id);
        List<Build> builds = alternativeService.getBuildsByAlternativeId(id);
        model.addAttribute("alternative", alternative);
        model.addAttribute("builds", builds);

        return "alternative_edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String add(@ModelAttribute Alternative alternative,
                      @RequestParam int[] values,
                      @RequestParam(required = false) Long[] buildIds) {
        alternative = alternativeService.saveOrUpdateAlternative(alternative);
        List<String> criteriaNames = criterionService.getAllCriteriaNames();
        for (int i = 0; i < values.length; i++) {
            Build build;
            if (buildIds == null) {
                build = new Build();
                Criterion criterion = criterionService.getCriterionByName(criteriaNames.get(i));
                build.setCriterion(criterion);
                build.setAlternative(alternative);
            } else {
                build = alternativeService.getBuildById(buildIds[i]);
            }
            build.setValue(values[i]);

            alternativeService.saveOrUpdateBuild(build);
        }

        return "redirect:/alternatives";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        alternativeService.deleteAlternative(id);

        return "redirect:/alternatives";
    }
}
