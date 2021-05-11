// 'use strict';
/*
    var
        - gets hoisted
*/

// var integer; variable declaration
// integer = 6; variable assignment/initialization

console.log(integer);
var integer = 15;

var globalVar = 'I\'m a global scope variable';

function myFunction() {
    var functionVar = 'I\'m a function scope variable.';

    if (true) {
        let blockVar = 'I\'m a block scope variable.';
        blockVar = 'Reassigned';
        const blockConst = 'I\'m anst';
        // Can't reassign a const.
        // blockConst = 'Reassigned2';

        // Can't redeclared let and const
        // let blockVar = 'redeclared';
        console.log(blockConst);
    }

    // blockVar is not availble within the function scope
    console.log('global" ' + globalVar + ' function ' + functionVar);
}

myFunction();
x = 10;

let obj = {
    id: 1,
    name: 'Something',
    favoriteColor: 'Orange'
}

// Arrays, unlike Java, arrays can support multiple types and arrays are dynamic in js.
let arr = [1, 'Something', 'Orange'];

console.log(obj);
console.log(arr);
console.log(typeof obj + ', ' + typeof arr);

let name = 'some name';

var obj2 = {
    id: 1,
    name: 'Something',
    favoriteColor: 'Orange',
    nameAndFavColor: function () {
        console.log('My name is: ' + this.name + ', and my favorite color is: ' + this.favoriteColor);
    }
}

obj2.nameAndFavColor();

console.log("My name is:  " + obj2.name);
console.log(`My name: 
${obj2.name}`);

// Similar control flow to Java if/else, switch, for loop, while loops

var objs = [obj, obj2];

for (let i = 0; i < arr.length; i++) {
    console.log(arr[i]);
}

// leverages index
for (let element in objs) {
    console.log(element);
    console.log(objs[element].name);
}

// leverages the object itself
for (let el of objs) {
    console.log('el + ' + el.name);
}

// look into array methods, splice, join...
objs.forEach((item) => { console.log(item.name) });

// Functions
function add(a, b) {
    return a + b;
}

console.log(add(1, 2));

// like a final variable in java
const add2 = function (a, b) {
    return a + b;
}

console.log(add2(1, 2));

// Arrow Function notation
const add3 = (a, b) => {
    return a + b;
}


// Arrow Function notation
const add4 = (a, b) => a + b;

console.log(add4(1, 2));

let person = {
    age: 10,
    grow: function () {
        this.age++;
    }
}

console.log(person.age);
person.grow();
console.log(person.age);

let student = {
    hasDebts: true
    // __proto__ : person
}

// prototypical inheritance 
student.__proto__ = person;

student.grow();
console.log(student.age);

function count() {
    let counter = 0;

    return function () { counter += 1; return counter; };
}

// count = count();
console.log(count());
console.log(count());
console.log(count());
console.log(count());

function Person(age){
    let age = age;

    this.getAge = function(){
        return age;
    }
    this.setAge = function(age){
        this.age = age;
    }
}