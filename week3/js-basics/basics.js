// Line comment

/*
    Block comment
*/

hello();

function hello(){
    console.log("Hello World!");
}

function helloMessage(message){
    console.log(message);
}
hello();
helloMessage("Hello from message!");
helloMessage(1233123);
helloMessage(4/2);
helloMessage(hello());
helloMessage("Hi " + "hello ");
helloMessage(4 == 4);
helloMessage(4 == '4'); // Evaluates to true because of type coercion
helloMessage(4 === '4'); // Evaluates to false

var v; // undefined

v = 'something';
v = 5;
v = true;


