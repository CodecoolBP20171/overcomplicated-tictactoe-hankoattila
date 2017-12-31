package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.Player;
import com.codecool.enterprise.overcomplicated.model.TicTacToeGame;
import com.codecool.enterprise.overcomplicated.service.TicTacToeService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@SessionAttributes({"player", "game"})
public class GameController {

    Player player;
    TicTacToeGame ticTacToeGame;
    TicTacToeService ticTacToeService;

    public GameController(Player player, TicTacToeGame ticTacToeGame, TicTacToeService ticTacToeService) {
        this.player = player;
        this.ticTacToeGame = ticTacToeGame;
        this.ticTacToeService = ticTacToeService;

    }

    @ModelAttribute("player")
    public Player getPlayer() {
        return player;
    }

    @ModelAttribute("game")
    public TicTacToeGame getGame() {
        return ticTacToeGame;
    }

    @ModelAttribute("avatar_uri")
    public String getAvatarUri() throws IOException {
        return ticTacToeService.getAvatar(player.getUserName());
    }

    @ModelAttribute("funfact")
    public String getFunFact() throws IOException {
        return ticTacToeService.getFunFact();
    }

    @ModelAttribute("comic_uri")
    public String getComicUri() throws IOException {
        return ticTacToeService.getComics();
    }

    @GetMapping("/tictactoe-api/{board}/{symbol}")
    @ResponseBody
    public String getAi(@PathVariable("board") String board,
                            @PathVariable("symbol") String symbol) throws IOException {
        return ticTacToeService.getAi(board, symbol);

    }


    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute Player player) {
        return "welcome";
    }

    @PostMapping(value = "/changeplayerusername")
    public String changPlayerUserName(@ModelAttribute Player player) {
        return "redirect:/game";
    }

    @GetMapping(value = "/game")
    public String gameView(@ModelAttribute("player") Player player) {
        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("move") int move) {
        return "redirect:/game";
    }

}
