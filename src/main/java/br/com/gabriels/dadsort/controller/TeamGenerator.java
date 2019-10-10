package br.com.gabriels.dadsort.controller;

import br.com.gabriels.dadsort.service.TeamGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller("/")
public class TeamGenerator {

    @Autowired
    private TeamGeneratorService teamGeneratorService;

    @GetMapping
    public String form() {
        return "form.html";
    }

    @PostMapping
    public String random(String players, Model model) {
        List<String> playersNames = teamGeneratorService.getPlayersNames(players);
        int middle = teamGeneratorService.getMiddle(playersNames);

        List<String> teamA = teamGeneratorService.teamA(playersNames, middle);
        List<String> teamB = teamGeneratorService.teamB(playersNames, middle);

        model.addAttribute("players", players);
        model.addAttribute("teamA", teamA);
        model.addAttribute("teamB", teamB);

        return "list.html";
    }
}
