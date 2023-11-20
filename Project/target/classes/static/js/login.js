function submit(){
    let uname = document.getElementsByName("uname")[0].value;
    let psw = document.getElementsByName("psw")[0].value;
    let body = {"email": uname}
    fetch("/sign-in", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(body)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log("Logging data: ", data);
            let result = verifyPsw(data, psw);
            console.log(result);
        })
        .catch((error) => {
            console.error('There has been a problem with your fetch operation:', error);
        });
}

function verifyPsw(data, psw){
    if(data == psw){
        return "User logged in";
    }
    else{
        alert("Incorrect Password. Please try again.")
        return "Incorrect password";
    }
}