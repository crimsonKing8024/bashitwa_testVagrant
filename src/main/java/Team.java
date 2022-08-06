import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Team {
    private String name;
    private String location;

    static class Player {
        private String name;
        private String country;
        private String role;
        private String price_in_crores;

        public Player() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getPrice_in_crores() {
            return price_in_crores;
        }

        @JsonSetter("price-in-crores")
        public void setPrice_in_crores(String price_in_crores) {
            this.price_in_crores = price_in_crores;
        }
    }
    private List<Player> player = new ArrayList<>();

    public Team() {
        this.name = name;
        this.location = location;
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Player> getPlayerList() {
        return player;
    }

    @JsonSetter("player")
    public void setPlayerList(List<Player> playerList) {
        this.player = playerList;
    }
}
