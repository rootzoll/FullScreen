var exec = require('cordova/exec');

function StayAwake() {
    console.log("StayAwake.js: is created");
}

StayAwake.prototype.disableScreenTimeout = function () {
    exec(function (result) {
        // callback(result);
    }, function (result) {
        alert(JSON.stringify(result));
    }, "StayAwake", "DISABLE_TIMEOUT", []);
};

StayAwake.prototype.enableScreenTimeout = function () {
    exec(function (result) {
        // callback(result);
    }, function (result) {
        alert(JSON.stringify(result));
    }, "StayAwake", "REACTIVATE_TIMEOUT", []);
};

var StayAwake = new StayAwake();
module.exports = StayAwake;
