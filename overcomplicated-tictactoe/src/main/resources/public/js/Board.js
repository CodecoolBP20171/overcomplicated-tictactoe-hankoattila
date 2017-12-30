function Board() {
    this.steps = [
        [null, null, null],
        [null, null, null],
        [null, null, null]
    ];
    this.symbols = {
        X: '<i class="fa fa-times" aria-hidden="true"></i>',
        O: '<i class="fa fa-circle-o" aria-hidden="true"></i>'
    };
}

/**
 * @param {string} symbol
 * @param {Step} step
 */
Board.prototype.step = function (symbol, step) {

    let me = this;
    console.log(step);
    return new Promise(function (resolve, reject) {
        if (me.steps[step.row][step.column] === null) {
            me.steps[step.row][step.column] = symbol;
            $('#btn-' + step.row + '-' + step.column).html(me.symbols[symbol]);
            resolve(me.getWinner());
        } else {
            reject("Invalid step");
        }

    });
};

/**
 * @returns {string[][]}
 */
Board.prototype.getSteps = function () {
    return JSON.parse(JSON.stringify(this.steps));
};

Board.prototype.getWinner = function () {
    //Todo check the winner. If no winner then return null else symbol

    return this.steps.every(function (columns) {
        return columns.every(function (column) {
            return column !== null;
        })
    })
};


