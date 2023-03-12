package me.valentesteban.survival.placeholder.types;

import me.valentesteban.survival.placeholder.Placeholder;
import org.bukkit.entity.Player;

public class UserPlaceholder
        implements Placeholder {

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String apply(Player player, String text) {

        if (player == null) {
            return "";
        }

        // TODO: ugly, refactor this
        switch (text) {
            case "nickname":
                return player.getDisplayName() + "";
            default:
                return "";
        }
    }
}