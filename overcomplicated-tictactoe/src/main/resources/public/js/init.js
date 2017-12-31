$(function () {
    let playerA = new MachinePlayer('X');
    let playerB = new HumanPlayer('O');
    let board = new Board();
    let game = new Game(board,playerA,playerB);
    game.start();
});