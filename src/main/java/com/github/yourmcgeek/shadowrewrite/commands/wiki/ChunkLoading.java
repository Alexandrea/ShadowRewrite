package com.github.yourmcgeek.shadowrewrite.commands.wiki;

import com.github.yourmcgeek.shadowrewrite.ShadowRewrite;

import me.bhop.bjdautilities.command.annotation.Command;
import me.bhop.bjdautilities.command.annotation.Execute;
import me.bhop.bjdautilities.command.result.CommandResult;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

import java.awt.*;

@Command(label = {"chunkloading", "cl"}, usage = "cl", description = "Displays wiki link for ChunkLoading")
public class ChunkLoading {

    private ShadowRewrite main;

    public ChunkLoading(ShadowRewrite main) {
        this.main = main;

    }

    @Execute
    public CommandResult onExecute(Member member, TextChannel channel, Message message, String label, java.util.List<String> args) {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Chunk Loading")
                .setDescription("Use this link to see how to chunk load land\n" + main.mgr.getConfig().getCLURL())
                .setColor(new Color(main.mgr.getConfig().getColorRed(), main.mgr.getConfig().getColorGreen(), main.mgr.getConfig().getColorBlue()));

        main.getMessenger().sendEmbed(channel, embed.build(), 10);
        return CommandResult.success();
    }
}