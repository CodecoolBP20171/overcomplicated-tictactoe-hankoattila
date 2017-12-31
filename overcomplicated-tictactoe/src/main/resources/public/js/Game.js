/**
 * @param {Board} board
 * @param {Player} playerA
 * @param {Player} playerB
 * @constructor
 */
function Game(board, playerA, playerB) {
    this.board = board;
    this.playerA = playerA;
    this.playerB = playerB;
    this.currentPlayer = playerA;

}

Game.prototype.start = function () {
    this.turn(this.currentPlayer);
};

Game.prototype.getOpponent = function (player) {
    if (player === this.playerA) {
        return this.playerB;
    }

    if (player === this.playerB) {
        return this.playerA;
    }

    return null;
};

/**
 * @param {Player} player
 */
Game.prototype.turn = function (player) {
    let me = this;
    let proxy = me.board.getSteps();

    player.turn(proxy).then(function (step) {
        return me.board.step(player.symbol, step);
    }).then(function (winner) {
        if (winner) {
            setTimeout(function () {
                alert(winner);
            },10);
        } else {
            me.turn(me.getOpponent(player));
        }
    }).catch(function () {
        me.turn(player);
    });
};

