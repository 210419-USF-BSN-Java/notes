let apiURL = 'https://pokeapi.co/api/v2/pokemon/';

document.getElementById('getData').onclick = getData;  // Assign functionality

function getData() {

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

    function receiveData() {
        let dataSection = document.getElementById('data');

        // Ready state is done, reponse has been retrieved
        if (xhr.readyState === 4) {
            // Status code is in the 200s, meaning successful
            if (xhr.status >= 200 && xhr.status < 300) {
                let response = xhr.responseText;
                // Converting JSON to JS object
                response = JSON.parse(response);
                // Data processing behavior
                populateData(response);
            } else {
                // Behavior if request was unsuccessful
            }
        }
    }
}

function populateData(response) {
    console.log(response);
    /*
        Use DOM Manipulation to write the data into our HTML page in the section tag.
    */
    let statName = [];
    let stats = [];
    let ability =[];
    let n = response.name;
    let t = response.types[0].type.name;
    n = n.charAt(0).toUpperCase() + n.slice(1);
    t = t.charAt(0).toUpperCase() + t.slice(1);

    // abilities
    for (i = 0; i < Object.keys(response.abilities).length; i++) {

        let temp = response.abilities[i].ability.name;
        temp = temp.charAt(0).toUpperCase() + temp.slice(1);
        ability.push(`<li>${temp}</li>`);
    };

    // stats
    for (i = 0; i < Object.keys(response.stats).length; i++) {
        let tempName = response.stats[i].stat.name;
        tempName = tempName.charAt(0).toUpperCase() + tempName.slice(1);

        statName.push(`<td>${tempName}</td>`);
        stats.push(`<td>${response.stats[i].base_stat}</td>`);
    };

    document.getElementById('data').innerHTML = `
        <img src=${response.sprites.front_default}></img>
        <div>Name: ${n}</div>
        <div>Type: ${t} </div>
        <ul id="append">Abilities: ${ability.join("")}</ul>
    `;
    document.getElementById('table').innerHTML = ` 

        <table id="tableId"> 
            <thead>
                <tr>
                    <th>Base Stats</th>
                </tr>
            </thead>
            <tbody>
                <tr >
                    ${statName.join("")}
                </tr>
                <tr>
                    ${stats.join("")}
                </tr>
            </tbody>
        </table>
    `;
}