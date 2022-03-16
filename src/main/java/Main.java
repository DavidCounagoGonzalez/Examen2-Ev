import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

public class Main {
    public static void main (final String[]args ){
        final String token =args[2];
        final DiscordClient cliente = DiscordClient.create(token);
        final GatewayDiscordClient puerto = cliente.login().block();

        puerto.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            if ("!Ping".equals(message.getContent())) {
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage("Pong!").block();
            }
        });

        puerto.onDisconnect().block();
    }
}
