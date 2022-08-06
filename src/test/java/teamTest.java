import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class teamTest {

    private static final String PATH_TO_TEAM_SHEET = "src/main/resources/TeamRCB.json";
    Team team = new Team();

    @BeforeTest
    public void before() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        team = objectMapper.readValue(new File(PATH_TO_TEAM_SHEET), Team.class);
    }

    @Test
    public void testForeignPlayerLimit() {
        List<Team.Player> playerList = team.getPlayerList();
        int numberOfForeignPlayers = 0;
        for (Team.Player player : playerList) {
            if (!player.getCountry().equalsIgnoreCase("India"))
                numberOfForeignPlayers += 1;
        }

        Assert.assertEquals(numberOfForeignPlayers, 4,
                "There are more than 4 foreign players");
    }

    @Test
    public void testIsThereKeeper() {
        List<Team.Player> playerList = team.getPlayerList();
        boolean isThereWK = false;
        for (Team.Player player : playerList) {
            if (player.getRole().equalsIgnoreCase("Wicket-keeper")) {
                isThereWK = true;
                break;
            }
        }
        Assert.assertEquals(isThereWK, true,
                "There are no wicket-keepers in the team");

    }
}
