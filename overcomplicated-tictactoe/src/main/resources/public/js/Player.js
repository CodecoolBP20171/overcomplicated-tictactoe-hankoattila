function Player(symbol) {
    this.symbol = symbol;

}

/**
 * @param {string[][]} board
 * @returns {Promise<Step>}
 */
Player.prototype.turn = function (board) {
    return new Promise(function (resolve, reject) {
        //Todo Make decision based on board then resolve with a step
    });
};