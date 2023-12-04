let isSignedIn = false;
let count = 0;
function openTab(tabName) {
    var i;
    var x = document.getElementsByClassName("tab");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    document.getElementById(tabName).style.display = "block";
}

function submit(){
    let uname = document.getElementsByName("uname")[0].value;
    let psw = document.getElementsByName("psw")[0].value;
    // console.log(uname, psw)
    let body = {"email": uname, "password": psw }
    // console.log(body)
    fetch("/sign-in", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(body)
    })
        .then(response => {
            if (!response.ok) {
                // alert("Incorrect credentials. Please try again")
                throw new Error('Network response was wrong.');
            }
            if(response.ok){
                isSignedIn = true
            }

            validateUserSignIn(count)

            return response.json();
        })
        .then(data => {
            // console.log("Logging data: ", data);
        })
        .catch((error) => {
            alert("Incorrect credentials. Please try again")
            console.error('There has been a problem with your fetch operation:', error);
        });
}

function validateUserSignIn(count){
    if(count > 0){
        alert("User already signed in")
        window.location.href = "../index.html"
    }
    else{
        count = 1
        window.location.href = "../index.html"
    }



}