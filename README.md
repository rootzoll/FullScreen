cordova-plugin-screen-util

=========

A small library providing utility methods to `disable` the status bar of an application as well as the navigation button on the screen thus allowing the application to be in full screen mode. In addition, it provides the method to `disable` timeout for that particular application thus enable it to stay awake.

## Constraint
 <ul>
     <li>
         The on screen navigation button will appear only if you swipe up at the bottom of the screen.
     </li>
     <li>
         Support only android.
     </li>
 </ul>


## Installation
  cordova plugin add cordova-plugin-screen-util

## Usage
In the index.html include :
```html
 <script src="ScreenUtil.js"></script>
```
below the cordova.js script.


```javascript
//in cordova 

    document.addEventListener("deviceready", function () {
        setTimeout(function () {
            ScreenUtil.settings("FULL_SCREEN");
            ScreenUtil.settings("DISABLE_TIMEOUT");
        }, 500);
    }, false);
    
    
//in ionic

   angular.module('yourModule')
    .controller('yourController', function ($scope, $timeout) {

        angular.element(document).ready(function () {
            $timeout($scope.ScreenCalibrate, 500);//invoking the plugin in a timeout function
        });

        $scope.ScreenCalibrate = function () {
            ScreenUtil.settings("FULL_SCREEN");
            ScreenUtil.settings("DISABLE_TIMEOUT");
        };

    });

```

## Release History

* 0.0.0 Initial release
