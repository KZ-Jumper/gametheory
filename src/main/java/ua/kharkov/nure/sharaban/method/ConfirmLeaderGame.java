package ua.kharkov.nure.sharaban.method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kharkov.nure.sharaban.model.LPR;
import ua.kharkov.nure.sharaban.service.AlternativeService;

@Component
public class ConfirmLeaderGame {

    @Autowired
    private AlternativeService alternativeService;

    public void confirmLeader(LPR user) {

    }
}
