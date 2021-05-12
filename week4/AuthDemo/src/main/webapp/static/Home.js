// Retrieving the token we received from our Servlets
let token = sessionStorage.getItem("token");
console.log(token);

/*
	Checks that the token is present otherwise redirects to login page
*/
if(!token){
	window.location.href="http://localhost:8080/AuthDemo/login";
} else {
	// In this case our token contains the user id for convenience
	let tokenArr = token.split(":");
	if(tokenArr.length===2){
		let baseUrl = "http://localhost:8080/AuthDemo/api/users/";
		sendAjaxGet(baseUrl+tokenArr[0], displayName);
	} else {
		window.location.href="http://localhost:8080/AuthDemo/login";
	}
}

/*
 * if we are not redirected when checking for the token, a request will be made to 
 * the url for that particular user 
 */

function sendAjaxGet(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState===4 && this.status===200){
			callback(this);
		} else if (this.readyState===4){
			window.location.href="http://localhost:8080/AuthDemo/login";
		}
	}
	//Here the token is included into the request being made
	xhr.setRequestHeader("Authorization",token);
	xhr.send();
}

function displayName(xhr){
	let user = JSON.parse(xhr.response);
	document.getElementById("user").innerHTML = `Welcome ${user.username}`;
	
}