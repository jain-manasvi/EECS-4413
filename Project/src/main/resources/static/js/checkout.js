function processOrder() {
    let cardNumber = document.getElementsByName("cardNumber");
    let cvv = document.getElementsByName("cvv");
    let isLengthMoreThan16 = cardNumber.toString().length == 16;
    let isLengthMoreThan3 = cvv.toString().length == 3;
    if(!isLengthMoreThan16 || !isLengthMoreThan3){
        alert("Please make sure your card number is 16 digits and make sure your cvv is 3 digits long")
        return;
    }
    // Here, you can add logic to handle the form submission
    // For example, you might want to validate the form fields and send the data to the server

    // If everything is valid, you can redirect the user to a confirmation page or perform other actions
    window.location.href = '/confirmation'; // Replace with the actual confirmation page URL
}
