document.addEventListener('DOMContentLoaded', () => {
    const cartItemsContainer = document.getElementById('cart-items');

    function updateCartDisplay() {
        cartItemsContainer.innerHTML = '';


        cartItems.forEach((item, index) => {
            const itemElement = document.createElement('div');
            itemElement.innerHTML = `
                <p>Item: ${item.name}, Quantity: ${item.quantity}</p>
                <button onclick="increaseQuantity(${index})">+</button>
                <button onclick="decreaseQuantity(${index})">-</button>
                <button onclick="removeItem(${index})">Remove</button>
                <button onclick="goToCustomization('${item.name}')">Customize</button>
            `;
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

    function removeItem(index) {
        cartItems.splice(index, 1);
        updateCartDisplay();
    }

    function goToCustomization(itemName) {
        window.location.href = `customization.html?item=${itemName}`;
    }

    updateCartDisplay();
});