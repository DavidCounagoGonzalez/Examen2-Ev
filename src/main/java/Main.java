import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;

public class Main {
    public static void main (final String[]args ){
        final String token =args[2];
        final DiscordClient cliente = DiscordClient.create(token);
        final GatewayDiscordClient puerto = cliente.login().block();
    }
}
