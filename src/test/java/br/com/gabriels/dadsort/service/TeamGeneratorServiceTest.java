package br.com.gabriels.dadsort.service;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeamGeneratorServiceTest {

    @Autowired
    private TeamGeneratorService teamGeneratorService;

    @Test
    public void shouldGiveTheExactlyNumberOfFormattedNames() {
        String players = "- Gabriel " +
                "- Veronica " +
                "- Yuri " +
                "Yuri " +
                "- Matheus";

        List<String> playersNames = teamGeneratorService.getPlayersNames(players);

        assertThat(4).isEqualTo(playersNames.size());
    }
}
