 var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

function matchPassword(){
    let pw1 = document.getElementsByName("psw")[0].value;
    let pw2 = document.getElementsByName("psw-repeat")[0].value;
    let fName = document.getElementsByName("fName")[0].value;
    let lName = document.getElementsByName("lName")[0].value;
    let email = document.getElementsByName("email")[0].value;
    if(fName == "" || lName == "" || email == "" || pw1 == "" || pw2 == ""){
        alert("Please fill in all fields");
        return;
    }
    if(pw1 !== pw2){
        console.log(pw1);
        console.log(pw2);
        alert("Passwords do not match. Please make sure they match");
        return;
    }
    else{
        let formData = {
            fName: document.getElementsByName("fName")[0].value,
            lName: document.getElementsByName("lName")[0].value,
            email: document.getElementsByName("email")[0].value,
            password: document.getElementsByName("psw")[0].value
        }
        // console.log(formData)
        fetch("/register", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }).then(response => response.json())
            .then(data => console.log("Success: ", data))
            .catch((error) => {
                alert("User already exists. Please use the sign-in function.")
            })

    }
}