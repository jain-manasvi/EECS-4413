function processOrder() {
    let cardNumber = document.getElementsByName("cardNumber")[0].value;
    let cvv = document.getElementsByName("cvv")[0].value;
    let address = document.getElementsByName("address")[0].value;
    let fullName = document.getElementsByName("fullName")[0].value;
    let zipcode = document.getElementsByName("zipcode")[0].value;

    let isCardNumberValid = cardNumber.length === 16 && /^\d+$/.test(cardNumber);
    let isCvvValid = cvv.length === 3 && /^\d+$/.test(cvv);
    let isAddressValid = /^[A-Za-z0-9\s.,'-]+$/.test(address);
    let isFullNameValid = /^[A-Za-z\s]+$/.test(fullName);
    let isZipcodeValid = zipcode.length === 6 && /^\d+$/.test(zipcode);

    if (!isCardNumberValid) {
        alert("Please make sure your card number is 16 digits long and numerical.");
        return;
    } else if (!isCvvValid) {
        alert("Please make sure your CVV is 3 digits long and numerical.");
        return;
    } else if (!isAddressValid) {
        alert("Please make sure your address does not contain special characters.");
        return;
    } else if (!isFullNameValid) {
        alert("Please make sure your full name contains only letters.");
        return;
    } else if (!isZipcodeValid) {
        alert("Please make sure your postal code is 6 digits long.");
        return;
    } else {
        alert("Order placed");
        window.location.href = "../index.html"
        clearCart().then(r => console.log(r));
    }
}

async function clearCart() {
    try {
        const response = await fetch("/cart/clear", {
            method: "DELETE",
            headers: {
                'Content-Type': 'application/json',
                // Include any additional headers as needed
            },
            // Include any request body if required
            // body: null
        });

        if (response.ok) {
            const data = await response.json();
            console.log('Cart cleared:', data);
            alert("cart cleared")
            // Perform any additional actions after clearing the cart if needed
        } else {
            console.error('Failed to clear cart:', response.statusText);
        }
    } catch (error) {
        console.error('Error:', error);
    }
}
