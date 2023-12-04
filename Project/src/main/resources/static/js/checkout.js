function processOrder() {
    let cardNumber = document.getElementsByName("cardNumber");
    let isLengthMoreThan16 = cardNumber.toString().length == 16 ? true : false;
    // Here, you can add logic to handle the form submission
    // For example, you might want to validate the form fields and send the data to the server

    // If everything is valid, you can redirect the user to a confirmation page or perform other actions
    window.location.href = '/confirmation'; // Replace with the actual confirmation page URL
}
