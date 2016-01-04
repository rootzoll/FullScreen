var exec = require('cordova/exec');

function ScreenUtil() {
    console.log("ScreenUtil.js: is created");
}

ScreenUtil.prototype.settings = function (action, callback) {
    var args = [statusBar, onScreenButton, timeout];
    exec(function (result) {
//        callback(result);
    }, function (result) {
        alert(JSON.stringify(result));
    }, "ScreenUtil", action, args);
};

var ScreenUtil = new ScreenUtil();
module.exports = ScreenUtil;
