package br.com.gabriels.dadsort.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamGeneratorService {

    public List<String> getPlayersNames(String players) {
        String[] split = players.replaceAll("\r\n", "").split("(-)+\\s?");
        List<String> names = Arrays.asList(split);
        return names.stream().filter(name -> !name.equals("")).collect(Collectors.toList());
    }

    public void randomize(List<String> players) {
        Collections.shuffle(players);
        Collections.shuffle(players);
        Collections.shuffle(players);
        Collections.shuffle(players);
        Collections.shuffle(players);
        Collections.shuffle(players);
        Collections.shuffle(players);
    }

    public List<String> teamA(List<String> players) {
        randomize(players);
        List<String> teamA = new ArrayList<>();

        float middle = (float) players.size() / 2;
        int middleCorrect = Math.round(middle);

        for (int i = 0; i < middleCorrect; i++) {
            teamA.add(players.get(i));
        }

        return teamA;
    }

    public List<String> teamB(List<String> players) {
        List<String> teamB = new ArrayList<>();
        float middle = players.size() / 2;
        int remnantPlayers = (int) (players.size() - middle);


        for (int i = remnantPlayers; i < players.size(); i++) {
            teamB.add(players.get(i));
        }

        return teamB;
    }

}
