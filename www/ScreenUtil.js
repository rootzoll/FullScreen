var exec = require('cordova/exec');

function ScreenUtil() {
    console.log("ScreenUtil.js: is created");
}

ScreenUtil.prototype.settings = function (action) {
    exec(function (result) {
        //        callback(result);
    }, function (result) {
        alert(JSON.stringify(result));
    }, "ScreenUtil", action, []);
};

var ScreenUtil = new ScreenUtil();
module.exports = ScreenUtil;
