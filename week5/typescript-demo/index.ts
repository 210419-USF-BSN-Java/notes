console.log('Hello World!');

// implicitely assigns myVar to type String
let myVar = 'my Var!';

// Cannot assign a boolean to a type String
// myVar = true;

let myNum: number = 5;

// myNum = '5';

enum colors{
    BLUE = 1 , GREEN, RED
}

let myEnum:colors = colors.BLUE;
let myEnum2:colors = colors.GREEN;

console.log(myEnum);
console.log(myEnum2);

interface myClass {
    myVar: string;
}

class MyClass implements myClass{
    
    private _myVar:string;

    constructor(someVar:string){
        this._myVar = someVar;
    }

    get myVar(){
        return this._myVar;
    }
}