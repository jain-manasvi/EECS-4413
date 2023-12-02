document.addEventListener('DOMContentLoaded', () => {
    const cartItemsContainer = document.getElementById('items-table');
    cartItemsContainer.innerHTML = '';
    let shoppingCart = getCartList();
    console.log(shoppingCart);
    // shoppingCart.forEach((item, index) => {
    //     const itemElement = document.createElement('div');
    //     itemElement.innerHTML = `
    //             <p>Item: ${item.name}, Quantity: ${item.quantity}</p>
    //             <button onclick="increaseQuantity(${index})">+</button>
    //             <button onclick="decreaseQuantity(${index})">-</button>
    //             <button onclick="removeItem(${index})">Remove</button>
    //             <button onclick="goToCustomization('${item.name}')">Customize</button>
    //         `;
    //     cartItemsContainer.appendChild(itemElement);
    // });

});
async function getCartList(){
    let response = await fetch("/cart");

    if(!response.ok){
        const message = `An error has occured: ${response.status}`;
        throw new Error(message);
    }
    let shoppingCart = await response.json();
    return shoppingCart;
}


function increaseQuantity(index) {
    cartItems[index].quantity++;
    updateCartDisplay();
}

function decreaseQuantity(index) {
    if (cartItems[index].quantity > 1) {
        cartItems[index].quantity--;
    } else {
        removeItem(index);
    }
    updateCartDisplay();
}

function removeItem(index) {
    cartItems.splice(index, 1);
    updateCartDisplay();
}

function goToCustomization(itemName) {
    window.location.href = `customization.html?item=${itemName}`;
}

function clearAll(){
    fetch("/cart/clear", {
        method: "DELETE"
    }).then(response => response.json())
        .then(data => {
            // Assuming your API returns a success message or an updated cart status
            console.log('Cart cleared:', data);
        })
        .catch(error => console.error('Error:', error));
}