function HumanPlayer(symbol) {
    this.symbol = symbol;

}

/**
 * @param {string[][]} board
 * @returns {Promise<Step>}
 */
HumanPlayer.prototype.turn = function () {
    return new Promise(function (resolve) {
        const handler = function () {
            $(".game-container").off("click", "span.btn.square", handler);

            let $element = $(this);
            let elementId = $element.attr('id');
            let idParts = elementId.split('-');
            let step = new Step(parseInt(idParts[1], 10), parseInt(idParts[2], 10));

            resolve(step);
        };

        $(".game-container").on("click", "span.btn.square", handler);
    });
};