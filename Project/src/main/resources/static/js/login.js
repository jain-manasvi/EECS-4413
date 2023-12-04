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
            else{
                alert("User logged in successfully")
            }

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