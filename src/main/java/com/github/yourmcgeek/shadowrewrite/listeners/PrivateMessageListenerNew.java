package com.github.yourmcgeek.shadowrewrite.listeners;

import com.github.yourmcgeek.shadowrewrite.ShadowRewrite;
import com.google.gson.JsonElement;
import me.bhop.bjdautilities.ReactionMenu;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class PrivateMessageListenerNew extends ListenerAdapter {

    private ShadowRewrite main;
    private int userCount;

    public PrivateMessageListenerNew(ShadowRewrite main) {
        this.main = main;
    }

    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/YY");
        if (event.getAuthor().isBot()) return;
        Member member = event.getJDA().getGuildById(main.getGuildID()).getMember(event.getAuthor());

        for (Guild.Ban bans : event.getJDA().getGuildById(main.getGuildID()).getBanList().complete()) {
            if (bans.getUser().getIdLong() == member.getUser().getIdLong())
                return;
        }

        for (TextChannel channel : event.getJDA().getCategoryById(main.getConfig().getConfigValue("supportCategoryId").getAsLong()).getTextChannels()) {
            if (channel.getName().startsWith(member.getEffectiveName())) {
                userCount++;
                if (userCount == 1) {
                    member.getUser().openPrivateChannel().complete().sendMessage("No channel has been created because you already have a ticket open! Please respond within the ticket to resolve that issue first!").queue();
                    return;
                }
            }
        }

        String userMessage = null;
        userMessage = event.getMessage().getContentRaw();
        TextChannel supportChannel = (TextChannel) event.getJDA().getCategoryById(main.getConfig().getConfigValue("supportCategoryId").getAsLong())
                .createTextChannel(member.getEffectiveName() + "-" + ThreadLocalRandom.current().nextInt(99999)).complete();

        EmbedBuilder message = new EmbedBuilder()
                .addField("Author: ", member.getAsMention(), true)
                .addField("Ticket: ", userMessage, true)
                .addField("Username: ", "Run `" + main.getPrefix() + "username <Username>` to set this field", true)
                .addField("UUID: ", "Run `" + main.getPrefix() + "username <Username>` to set this field", true)
                .addField("Server:", "Run `" + main.getPrefix() + "server <Server>` to set this field", true)
                .setFooter("If you are finished, please click \u2705. All staff and developers can close the ticket also.", event.getJDA().getSelfUser().getEffectiveAvatarUrl())
                .setColor(new Color(main.getConfig().getConfigValue("Red").getAsInt(), main.getConfig().getConfigValue("Blue").getAsInt(), main.getConfig().getConfigValue("Green").getAsInt()));

        ReactionMenu supportMessage = new ReactionMenu.Builder(event.getJDA()).setEmbed(message.build()).addStartingReaction("\u2705").addStartingReaction("\uD83D\uDD12").buildAndDisplay(supportChannel);
        supportChannel.getManager().setTopic("Creation date: " + supportChannel.getCreationTime().format(dateFormat) + " Authors ID: " + event.getAuthor().getIdLong() + " Message ID: " + supportMessage.getMessage().getIdLong() + " Channel ID: " + supportChannel.getIdLong()).queue();
        for (Message.Attachment attachment : event.getMessage().getAttachments()) {
            String[] fileName = attachment.getFileName().split("\\.");
            for (JsonElement blacklistArray : main.getConfig().getConfigValue("blacklistFiles").getAsJsonArray()) {

                if (blacklistArray.getAsString().equalsIgnoreCase(fileName[1])) {
                    try {
                        if (!new File(main.getLogDirectory().toFile(), "attachments").exists()) {
                            new File(main.getLogDirectory().toFile(), "attachments").mkdir();
                        }
                        attachment.download(new File(main.getLogDirectory().toFile() + "/attachments/", attachment.getFileName() + ".log"));
                        supportChannel.sendFile(new File(main.getLogDirectory().toFile() + "/attachments/", attachment.getFileName() + ".log")).complete();
                        main.getMessenger().sendMessage(event.getChannel(), event.getMessage().getAuthor() + " has sent a file called " + attachment.getFileName() + ".log");
                    } catch (Exception e) {
                        main.getLogger().error("Error with PrivateMessageListener ", e);
                    }
                } else {
                    if (Files.exists(main.getAttachmentDir().resolve(attachment.getFileName()))) {
                        main.getLogger().info("Renaming attachment as one already exists!");
                        String rename = fileName[0] + ThreadLocalRandom.current().nextInt(99999) + "." + fileName[1];

                        attachment.download(new File(String.valueOf(main.getAttachmentDir().resolve(rename))));
                        supportChannel.sendFile(new File(String.valueOf(main.getAttachmentDir().resolve(rename)))).complete();
                        main.getLogger().info(attachment.getFileName() + " was renamed to " + rename);
                    } else {
                        attachment.download(new File(main.getLogDirectory().toFile() + "/attachments/", attachment.getFileName()));
                        supportChannel.sendFile(new File(main.getLogDirectory().toFile() + "/attachments/", attachment.getFileName())).complete();
                    }
                }
            }
        }
        supportMessage.getMessage().pin().complete();
        supportChannel.getHistory().retrievePast(1).queue(l -> l.forEach(m -> m.delete().queue()));
        event.getAuthor().openPrivateChannel().complete().sendMessage(new EmbedBuilder()
                .setTitle("Support Channel")
                .setDescription("https://discordapp.com/channels/" + main.getGuildID() + "/" + supportChannel.getIdLong())
                .setColor(new Color(main.getConfig().getConfigValue("Red").getAsInt(), main.getConfig().getConfigValue("Blue").getAsInt(), main.getConfig().getConfigValue("Green").getAsInt()))
                .build()).queue();


    }
}
