import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CaptchaPlugin implements CommandExecutor {
    private Map<Player, Integer> captchaMap = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("captcha")) {
            int captcha = generateCaptcha();
            captchaMap.put(player, captcha);
            player.sendMessage(ChatColor.GREEN + "Please solve the following math problem: " + captcha);
            return true;
        } else if (command.getName().equalsIgnoreCase("verify")) {
            if (!captchaMap.containsKey(player)) {
                player.sendMessage(ChatColor.RED + "No CAPTCHA to verify. Use /captcha first.");
                return true;
            }

            int captcha = captchaMap.get(player);
            int answer;

            try {
                answer = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED + "Invalid answer. Please enter a number.");
                return true;
            }

            if (answer == captcha) {
                player.sendMessage(ChatColor.GREEN + "CAPTCHA validation successful!");
            } else {
                player.sendMessage(ChatColor.RED + "CAPTCHA validation failed. Please try again.");
            }

            captchaMap.remove(player);
            return true;
        }

        return false;
    }

    private int generateCaptcha() {
        Random random = new Random();
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        int operator = random.nextInt(2); // 0 for addition, 1 for subtraction

        if (operator == 0) {
            return num1 + num2;
        } else {
            return num1 - num2;
        }
    }
}
