// let response = async () => {
//     const response = await fetch("/cart", { method: "GET" });
//     const data = await response.json();
//     // Assuming the data contains a 'cart' array
//     return data;
// };
//
//
// document.addEventListener('DOMContentLoaded', () => {
//     const cartItemsContainer = document.getElementById('items-table');
//     cartItemsContainer.innerHTML = '';
//     let shoppingCart = async () => {
//         const cart = await response;
//         console.log(cart)
//         return cart;
//     }
//     let info = shoppingCart()
//     console.log("Logging info: " + info);
//     // shoppingCart.forEach((item) => {
//     //     const itemElement = document.createElement('div');
//     //     itemElement.innerHTML = `
//     //             <p>Item: ${item.name}, Quantity: ${item.quantity}</p>
//     //             <button onclick="increaseQuantity(${item.quantity})">+</button>
//     //             <button onclick="decreaseQuantity(${item.quantity})">-</button>
//     //             <button onclick="removeItem(${item.name})">Remove</button>
//     //             <button onclick="goToCustomization('${item.name}')">Customize</button>
//     //         `;
//     //     cartItemsContainer.appendChild(itemElement);
//     // });
//
// });
//
//
// function increaseQuantity(index) {
//     cartItems[index].quantity++;
//     updateCartDisplay();
// }
//
// function decreaseQuantity(index) {
//     if (cartItems[index].quantity > 1) {
//         cartItems[index].quantity--;
//     } else {
//         removeItem(index);
//     }
//     updateCartDisplay();
// }
//
// function removeItem(index) {
//     cartItems.splice(index, 1);
//     updateCartDisplay();
// }
//
// function goToCustomization(itemName) {
//     window.location.href = `customization.html?item=${itemName}`;
// }
//
// function clearAll(){
//     fetch("/cart/clear", {
//         method: "DELETE"
//     }).then(response => response.json())
//         .then(data => {
//             // Assuming your API returns a success message or an updated cart status
//             console.log('Cart cleared:', data);
//         })
//         .catch(error => console.error('Error:', error));
// }

const response = fetch("/cart", {
    method: "GET"
}).then((response) => response.json()).then((data) => data)


// document.addEventListener('DOMContentLoaded', () => {
//     const cartItemsContainer = document.getElementById('items-table');
//     cartItemsContainer.innerHTML = '';
//     let shoppingCart = async () => {
//         const cart = await response;
//         return cart;
//     }
//     console.log(shoppingCart());
//     // shoppingCart.forEach((item) => {
//     //     const itemElement = document.createElement('div');
//     //     itemElement.innerHTML =
//     //             <p>Item: ${item.name}, Quantity: ${item.quantity}</p>
//     //             <button onclick="increaseQuantity(${item.quantity})">+</button>
//     //             <button onclick="decreaseQuantity(${item.quantity})">-</button>
//     //             <button onclick="removeItem(${item.name})">Remove</button>
//     //             <button onclick="goToCustomization('${item.name}')">Customize</button>
//     //         ;
//     //     cartItemsContainer.appendChild(itemElement);
//     // });
//
// });
let shoppingCart = async () => {
    const response = await fetch("/cart", { method: "GET" });
    const cart = await response.json();
    console.log(cart)
    let cartList = cart.cart;
    console.log(cartList)
    updateCartDisplay(cartList)
};

document.addEventListener('DOMContentLoaded', () => {

    // Call the shoppingCart function and handle the promise
    shoppingCart().catch(error => console.error('Error:', error));
});

function updateCartDisplay(cartList){
    const cartItemsContainer = document.getElementById('items-table');
    cartItemsContainer.innerHTML = '';
    cartList.forEach((item) => {
        const itemElement = document.createElement('div');
        itemElement.innerHTML = `
                <p>Item: ${item.productName}, Quantity: ${item.qty}</p>
<!--                <button type="button" onclick="increaseQuantity(${item.qty})">+</button>-->
<!--                <button type="button" onclick="decreaseQuantity(${item.qty})">-</button>-->
                <button type="button" onclick="removeItem('${item.productId}')">Remove</button>
<!--                <button type="button" onclick="goToCustomization('${item.productName}')">Customize</button>-->
            `;
//         itemElement.innerHTML = `
//     <p>Item: ${item.productName}, Quantity: ${item.qty}</p>
//     <button type="button" onclick="increaseQuantity('${item.productId}')">+</button>
//     <button type="button" onclick="decreaseQuantity('${item.productId}')">-</button>
// `;
        cartItemsContainer.appendChild(itemElement);
    });
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
//
// function removeItem(id) {
//     let body = {id: id}
//     fetch("/cart/remove", {
//         method: "DELETE",
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(body)
//     })
//
//     // cartItems.splice(index, 1);
//     // updateCartDisplay();
// }

// function removeItem(productID) {
//     fetch(`/cart/remove`, {
//         method: "DELETE",
//         headers: {
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify({ id: productID })
//     })
//         .then(response => {
//             let val = response.json()
//             updateCartDisplay(val.cart);
//         })
//         .then(data => {
//             console.log('Item removed:', data);
//             // Reload or update the cart display after removal
//
//         })
//         .catch(error => console.error('Error:', error));
// }

// function removeItem(productID) {
//     console.log("In remove item method")
//     console.log(productID)
//     fetch(`/cart/remove`, {
//         method: "DELETE",
//         headers: {
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify({ id: productID })
//     })
//         .then(response => response.json()) // Wait for the JSON response
//         .then(data => {
//             console.log('Item removed:', data);
//             if(data.cart) { // Check if the server sends back the updated cart
//                 updateCartDisplay(data.cart);
//             } else {
//                 // If not, refetch the cart
//                 shoppingCart().catch(error => console.error('Error:', error));
//             }
//         })
//         .catch(error => console.error('Error:', error));
// }

async function removeItem(productID) {
    try {
        console.log("In remove item method");
        console.log(productID);

        const response = await fetch(`/cart/remove`, {
            method: "DELETE",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ id: productID })
        });

        const data = await response.json(); // Wait for the JSON response

        console.log('Item removed:', data);

        if (data.cart) {
            // Check if the server sends back the updated cart
            updateCartDisplay(data.cart);
        } else {
            // If not, refetch the cart
            await shoppingCart();
        }
    } catch (error) {
        console.error('Error:', error);
    }
}

function signOut(){

}

// function removeItem(productID) {
//     fetch(`/cart/remove`, {
//         method: "DELETE",
//         headers: {
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify({ id: productID })
//     })
//         .then(response => response.json())
//         .then(data => {
//             console.log('Item removed:', data);
//             shoppingCart().catch(error => console.error('Error:', error)); // Fetch updated cart
//         })
//         .catch(error => console.error('Error:', error));
// }

function goToCheckout(){
    window.location.href = "../html/checkout.html"
}

function goToCustomization(itemName) {
    window.location.href = `customization.html?item=${itemName}`;
}

async function clearAll() {
    // try {
    //     const response = await fetch("/cart/clear", {
    //         method: "DELETE",
    //         body: null
    //     });
    //
    //     const data = await response.json();
    //     console.log('Cart cleared:', data);
    //
    //     // If necessary, perform additional actions after clearing the cart
    //
    // } catch (error) {
    //     console.error('Error:', error);
    // }
    try {
        const response = await fetch("/cart/clear", {
            method: "DELETE",
            headers: {
                'Content-Type': 'application/json',
                // Include any additional headers as needed
            },
            // body: null
        });

        if (response.ok) {
            const data = await response.json();
            console.log('Cart cleared:', data);
            // alert("cart cleared")
        } else {
            console.error('Failed to clear cart:', response.statusText);
        }
    } catch (error) {
        console.error('Error:', error);
    }
}



