let apiURL = 'https://pokeapi.co/api/v2/pokemon/';

document.getElementById('getData').onclick = getData;  // Assign functionality

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
}