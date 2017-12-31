function MachinePlayer(symbol) {
    this.symbol = symbol;
    // http://tttapi.herokuapp.com/api/v1/-O-----X-/O
    this.url = "http://localhost:8080/tictactoe-api/{board}/{symbol}";

}

/**
 *
 * @param {string[][]} board
 * @returns {Promise<Step>}
 */
MachinePlayer.prototype.turn = function (board) {
    let me = this;
    // {"game":"-O-----X-","player":"O","recommendation":8,"strength":0}
    let url = me.url.replace('{board}', me.boardToString(board)).replace('{symbol}', me.symbol.toUpperCase());

    return new Promise(function (resolve) {
        fetch(url).then(function (response) {
            return response.json();
        }).then(function (result) {
            resolve(me.numberToStep(result.recommendation));
        })
    });
};

/**
 * @param {string[][]} board
 * @returns {string}
 */
MachinePlayer.prototype.boardToString = function (board) {
    return board.reduce(function (string, row) {
        return string.concat(row.reduce(function (string, column) {
            return string.concat(column ? column.toUpperCase() : '-');
        }, ''));
    }, '');
};

/**
 * @param {number} number
 * @returns {Step}
 */
MachinePlayer.prototype.numberToStep = function (number) {
    let row, column;

    switch (number) {
        case 0:
        case 1:
        case 2:
            row = 0;
            column = number;
            break;
        case 3:
        case 4:
        case 5:
            row = 1;
            column = number - 3;
            break;
        case 6:
        case 7:
        case 8:
            row = 2;
            column = number - 6;
            break;
    }

    return new Step(row, column);
};