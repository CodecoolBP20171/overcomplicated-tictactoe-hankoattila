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
    return new Promise(function (resolve, reject) {
        if (me.steps[step.row][step.column] === null) {
            me.steps[step.row][step.column] = symbol;
            $('#btn-' + step.row + '-' + step.column).html(me.symbols[symbol]);
            resolve(me.getWinner(step, symbol));
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

Board.prototype.paths = [
    [[0, 0], [0, 1], [0, 2]],
    [[1, 0], [1, 1], [1, 2]],
    [[2, 0], [2, 1], [2, 2]],

    [[0, 0], [1, 0], [2, 0]],
    [[0, 1], [1, 1], [2, 1]],
    [[0, 2], [1, 2], [2, 2]],

    [[0, 0], [1, 1], [2, 2]],
    [[0, 2], [1, 1], [2, 0]]
];

Board.prototype.getWinner = function (step, symbol) {
    //Todo check the winner. If no winner then return null else symbol
    let paths = this.getPaths(step);
    let steps = this.steps;
    let isWinner = paths.some(function (path) {
        return path.every(function (point) {
            return steps[point[0]][point[1]] === symbol;
        });
    });

    if (isWinner) {
        return symbol;
    }

    let draw = this.steps.every(function (columns) {
        return columns.every(function (column) {
            return column !== null;
        });

    });

    if (draw) {
        return "draw";
    }

    return null;
};

Board.prototype.getPaths = function (step) {
    return this.paths.filter(function (steps) {
        return steps.some(function (point) {
            return point[0] === step.row && point[1] === step.column;
        })
    });


};


