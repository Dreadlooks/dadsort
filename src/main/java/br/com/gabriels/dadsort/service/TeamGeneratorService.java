package br.com.gabriels.dadsort.service;

import org.springframework.stereotype.Service;

import java.util.*;
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

    public List<String> teamA(List<String> players, int middle) {

//        int middle = getMiddle(players);

        List<String> teamA = players.subList(0, middle);
        return teamA;
    }

    public List<String> teamB(List<String> players, int middle) {

//        int middle = getMiddle(players);

        List<String> teamB = players.subList(middle, players.size());
        return teamB;
    }

    public int getMiddle(List<String> players) {
        randomize(players);
        int middle = players.size() / 2;

        if(players.size() % 2 != 0) {
            System.out.println("impar");
            int random = new Random().nextInt(2);
            middle += random;
        }
        return middle;
    }
}
