let apiURL = 'https://pokeapi.co/api/v2/pokemon/';

document.getElementById('getData').onclick = getData;  // Assign functionality

async function getData(){
    
    // Retrieving the user input, in this case the pokemon id to be retrieved
    let userInput = document.getElementById('dataInput').value;

    let response = await fetch(apiURL+userInput);

    if(response.status >= 200 && response.status <300){
        let data = await response.json();
        populateData(data);
       } else{
              document.getElementById('data').innerHTML = "<img src=https://ih1.redbubble.net/image.731955024.9007/farp,small,wall_texture,product,750x1000.u3.jpg />";
        }
}

function populateData(response){
    /*
        Use DOM Manipulation to write the data into our HTML page in the section tag.
    */
   console.log(response);

   let dataSection = document.getElementById('data');
   
   // Resets the innerHTML before loading new data
   dataSection.innerHTML ='';

   let nameTag = document.createElement('h3');
   nameTag.innerHTML = response.name.toUpperCase();
   
   let abilitiesArray = response.abilities;
   let abilities = document.createElement('ul');
   // Appending list elements to a ul
   for(let ability of abilitiesArray){
       let abilityLi = document.createElement('li');
       abilityLi.innerHTML = ability.ability.name;
       abilities.appendChild(abilityLi);
   }

   // Appending h3 and List to the section tag
   dataSection.appendChild(nameTag);
   dataSection.appendChild(abilities);

   // Appending sprites to section
   let spritesObject = response.sprites;
   for(let sprite in spritesObject){
       if(spritesObject[sprite] && spritesObject[sprite].length > 2){
           let spriteImg = document.createElement('img');
           spriteImg.src = spritesObject[sprite];
           dataSection.appendChild(spriteImg);
       }
   }
}