console.log('Hello World!');
// implicitely assigns myVar to type String
let myVar = 'my Var!';
// Cannot assign a boolean to a type String
// myVar = true;
let myNum = 5;
// myNum = '5';
var colors;
(function (colors) {
    colors[colors["BLUE"] = 1] = "BLUE";
    colors[colors["GREEN"] = 2] = "GREEN";
    colors[colors["RED"] = 3] = "RED";
})(colors || (colors = {}));
let myEnum = colors.BLUE;
let myEnum2 = colors.GREEN;
console.log(myEnum);
console.log(myEnum2);
class MyClass {
    constructor(someVar) {
        this._myVar = someVar;
    }
    get myVar() {
        return this._myVar;
    }
}
