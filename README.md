cordova-android-stayawake

=========

A small library providing utility methods to `disable` screen timeout for that particular application thus enable it to stay awake.

## Constraint
 <ul>
     <li>
         Support only android.
     </li>
 </ul>


## Installation
  cordova plugin add https://github.com/rootzoll/cordova-android-stayawake

## Usage
In the index.html include :
```html
 <script src="StayAwake.js"></script>
```
provides you the following two scripts:


```javascript
    StayAwake.disableScreenTimeout();
    StayAwake.enableScreenTimeout();
```

Just use when device is ready.