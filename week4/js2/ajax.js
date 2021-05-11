let apiURL = 'https://pokeapi.co/api/v2/pokemon/';

document.getElementById('getData').onclick = getData;  // Assign functionality

sb.onClick = getSprite;

function getData(){
    
    // Retrieving the user input, in this case the pokemon id to be retrieved
    let userInput = document.getElementById('dataInput').value;

    // 4 Steps to make an AJAX call
    // 1: Create an XMLHttpRequest object
    let xhr = new XMLHttpRequest();

    // 2: Set a callback function to the readystatechange event
    xhr.onreadystatechange = receiveData;

    // 3: Open the request/parameterize it
    xhr.open('GET', `${apiURL}${userInput}`);

    // 4: Send the request
    xhr.send();

    function receiveData(){
        let dataSection = document.getElementById('data');

        // Ready state is done, reponse has been retrieved
        if(xhr.readyState === 4){
            // Status code is in the 200s, meaning successful
            if(xhr.status >= 200 && xhr.status < 300){
                let response = xhr.responseText;
                // Converting JSON to JS object
                response = JSON.parse(response);
                // Data processing behavior
                populateData(response);
            } else{
                // Behavior if request was unsuccessful
            }
        }
    }
}

function populateData(response){
    /*
        Use DOM Manipulation to write the data into our HTML page in the section tag.
    */
   console.log(response);

   let section = document.getElementById('data');
   section.innerHTML = 
   `
        <h1>Name: ${response.name}</h1>
        <h1>Height: ${response.height}</h1>
        <h1>Weight: ${response.weight}</h1>
        <h1>ID: ${response.id}</h1>
        <img src =${response.sprites.back_default}>
        <img src =${response.sprites.front_default}>
        
   `

   for(var i = 0; i < response.abilities.length; i++){
    section.innerHTML += 
    `
        <h2>Ability ${i}: ${response.abilities[i].ability.name}</h2>
    `
   }
   
//    let i = 0;
//    section.innerHTML += `<h3>Type: </h3>`
//     do{
//         section.innerHTML += `<h3>${response.types[i].type.name}</h3>`
//         i++;
//     }while (response.types[i] != null)

}
