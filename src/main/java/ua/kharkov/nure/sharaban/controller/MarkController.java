package ua.kharkov.nure.sharaban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.kharkov.nure.sharaban.model.Criterion;
import ua.kharkov.nure.sharaban.model.Mark;
import ua.kharkov.nure.sharaban.service.CriterionService;
import ua.kharkov.nure.sharaban.service.MarkService;

import java.util.List;

@Controller
@RequestMapping("/marks")
public class MarkController {

    @Autowired
    private MarkService markService;

    @Autowired
    private CriterionService criterionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String view(ModelMap model) {
        List<Mark> marks = markService.getAllMarks();
        model.addAttribute("marks", marks);

        return "marks";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getEditPage(ModelMap model) {
        List<String> criteriaNames = criterionService.getAllCriteriaNames();
        model.addAttribute("criteriaNames", criteriaNames);

        return "mark_edit";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String getEditPage(@PathVariable long id, ModelMap model) {
        Mark mark = markService.getMarkById(id);
        List<String> criteriaNames = criterionService.getAllCriteriaNames();
        model.addAttribute("mark", mark);
        model.addAttribute("criteriaNames", criteriaNames);

        return "mark_edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String add(@ModelAttribute Mark mark) {
        Criterion criterion = criterionService.getCriterionByName(mark.getCriterion().getName());
        mark.setCriterion(criterion);
        markService.saveOrUpdateMark(mark);

        return "redirect:/marks";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        markService.deleteMark(id);

        return "redirect:/marks";
    }
}
