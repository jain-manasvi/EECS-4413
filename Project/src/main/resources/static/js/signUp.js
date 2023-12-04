 var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
function redirectToHome(){
    // document.getElementById('id01').style.display='none'
    console.log("In redirect function")
    window.location.href = "../index.html"
}
 function openTab(tabName) {
     var i;
     var x = document.getElementsByClassName("tab");
     for (i = 0; i < x.length; i++) {
         x[i].style.display = "none";
     }
     document.getElementById(tabName).style.display = "block";
 }

function matchPassword(){
    matchDetails()
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
            .then(data => {
                console.log("Success: ", data)
                window.location.href = "../index.html"
            })
            .catch((error) => {
                alert("User already exists. Please use the sign-in function.")
            })

    }
}

 function matchDetails() {
     var fName = document.getElementById('fName').value;
     var lName = document.getElementById('lName').value;
     var email = document.getElementById('email').value;

     // Regular expression patterns
     var namePattern = /^[A-Za-z]+$/;
     var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // Simple email pattern for example purposes

     // Validate First Name
     if (!namePattern.test(fName)) {
         alert("First name should contain only letters.");
         return false;
     }

     // Validate Last Name
     if (!namePattern.test(lName)) {
         alert("Last name should contain only letters.");
         return false;
     }

     // Validate Email
     if (!emailPattern.test(email)) {
         alert("Please enter a valid email address.");
         return false;
     }


 }