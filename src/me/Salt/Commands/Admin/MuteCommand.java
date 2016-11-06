package me.Salt.Commands.Admin;

import me.Salt.Parser.Admin.User.UserVoiceMuteContainer;
import me.Salt.Parser.Admin.User.UserVoiceMuteParser;
import me.Salt.Parser.CommandParser;
import me.Salt.Util.Command;
import me.Salt.Handlers.Main;
import net.dv8tion.jda.entities.User;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.exceptions.PermissionException;

import java.util.Iterator;

/**
 * Created by zuezy on 06/08/2016.
 */
public class MuteCommand implements Command {

    private UserVoiceMuteContainer c;
    @Override
    public boolean called(CommandParser.CommandContainer cmd) {
        c = new UserVoiceMuteParser().parse(cmd);
        return false;
    }

    @Override
    public void action(CommandParser.CommandContainer cmd) {
        cmd.getEvent().getTextChannel().sendMessage(c.getMutedUser().getUsername() + c.getMuteDuration().getTime() + c.getMutedVoiceChannel().getName() + c.getMuter().getUsername() + c.getMuteTime().getTime());
    }

    @Override
    public void executed(boolean success) {

    }

    @Override
    public String help() {
        return null;
    }
}
