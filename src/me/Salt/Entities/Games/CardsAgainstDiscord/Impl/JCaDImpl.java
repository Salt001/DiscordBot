package me.Salt.Entities.Games.CardsAgainstDiscord.Impl;

import me.Salt.Entities.Games.CardsAgainstDiscord.Container.JCaDManager;
import me.Salt.Entities.Games.CardsAgainstDiscord.Container.CaDParser;
import me.Salt.Entities.Games.CardsAgainstDiscord.Exceptions.CaDException;
import me.Salt.Entities.Games.CardsAgainstDiscord.JCaD;
import me.Salt.Entities.Games.CardsAgainstDiscord.Util.GameEndType;
import me.Salt.Parser.Command.CommandParser;

/**
 * Created by 15122390 on 18/11/2016.
 */
public class JCaDImpl implements JCaD {

    private JCaDManager game;

    @Override
    public void createGame(CommandParser.CommandContainer cmd) throws CaDException {
        if (!(this.game==null)){
        this.game = new CaDParser().parse(cmd);
    } else {
        throw new CaDException("The game has already been created!");
        }
    }

    @Override
    public void endGame(GameEndType gameEndType) {
        for (CaDPlayer u : game.getPlayers()){
            u.getPlayer().getPrivateChannel().sendMessage("The game has finished!")
        }
    }

    @Override
    public JCaDManager getManager() {
        return game;
    }


}
