package ua.kharkov.nure.sharaban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.kharkov.nure.sharaban.model.LPR;
import ua.kharkov.nure.sharaban.service.LPRService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SessionAttributes({"user"})
public class UserController {

    @Autowired
    private LPRService lprService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model, HttpServletRequest request) {
        List<LPR> people = lprService.getAllPeople();
        model.addAttribute("people", people);

        return "people";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String name, ModelMap model) {
        LPR user = lprService.getPersonByName(name);
        if (user == null) {
            user = new LPR();
            user.setName(name);
            user = lprService.saveOrUpdatePerson(user);
        }

        model.addAttribute("user", user);

        return "redirect:/";
    }

}
