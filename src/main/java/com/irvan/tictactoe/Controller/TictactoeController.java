package com.irvan.tictactoe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irvan.tictactoe.Service.TictactoeService;

@RestController
@RequestMapping("/tictactoe")
public class TictactoeController {
    @Autowired
    private TictactoeService tictactoeService;

    @PostMapping("/start")
    public String gameStart(@RequestParam int size){
        return tictactoeService.gameStart(size);
    }
    
    @PostMapping("/show_board")
    public String gameBoard(){
        return tictactoeService.getBoard();
    }

    @PostMapping("/move")
    public String gameMove(@RequestParam int col, @RequestParam int row){
        return tictactoeService.gameMove(row, col);
    }

}
