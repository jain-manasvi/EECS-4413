function openTab(tabName) {
    var i;
    var x = document.getElementsByClassName("tab");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    document.getElementById(tabName).style.display = "block";
}
let value = 0;
function sortForm(){
    let text = document.getElementById('sort').value;
    console.log(text);
    value = text;
    if(value == "price_asc"){
        sortPriceAscending()
    }
    if(value == "price_desc"){
        sortPriceDescending()
    }
    if(value == "mileage_asc"){
        sortMileageAscending()
    }
    if(value == "mileage_desc"){
        sortMileageDescending()
    }
    return text;
}

document.addEventListener("DOMContentLoaded", function () {
    fetch("/api/products/getAllProducts").then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
    })
        .then(data => {
            console.log('Cars:', data);
            data = data.sort((car1, car2) => car1.price - car2.price)
            displayCars(data)
        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
})

    function sortPriceAscending() {
        fetch("/api/products/getAllProducts").then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
            .then(data => {
                console.log('Cars:', data);
                data = data.sort((car1, car2) => car1.price - car2.price)
                displayCars(data)
            })
            .catch(error => {
                console.error('Fetch error:', error);
            });
    }

    function sortPriceDescending() {
        fetch("/api/products/getAllProducts").then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
            .then(data => {
                console.log('Cars:', data);
                data = data.sort((car1, car2) => car2.price - car1.price)
                displayCars(data)
            })
            .catch(error => {
                console.error('Fetch error:', error);

            });
    }

    function sortMileageAscending() {
        fetch("/api/products/getAllProducts").then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
            .then(data => {
                console.log('Cars:', data);
                data = data.sort((car1, car2) => car1.mileage - car2.mileage)
                displayCars(data)
            })
            .catch(error => {
                console.error('Fetch error:', error);
            });
    }

    function sortMileageDescending() {
        fetch("/api/products/getAllProducts").then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
            .then(data => {
                console.log('Cars:', data);
                data = data.sort((car1, car2) => car2.mileage - car1.mileage)
                displayCars(data)

            })
            .catch(error => {
                console.error('Fetch error:', error);
            });
    }

    function displayCars(data) {
        const carListContainer = document.getElementById("product-list");
        carListContainer.innerHTML = '';
        data.forEach(car => {
            console.log(car); // To check the whole object
            console.log('Model:', car.model); // To check the value of model specifically
            const dataElement = document.createElement('div');
            dataElement.innerHTML = `<strong>${car.name}</strong> (${car.year}): $${car.price} mileage: ${car.mileage}
        <button onclick="addToCart('${car.id}', '${car.name}', 1)">Add to Cart</button>`;
            carListContainer.appendChild(dataElement);
        })
    }

async function addToCart(id, name, quantity) {
    let body = {id: id, name: name, quantity: quantity };
    console.log(body);
    try {
        let response = await fetch("/cart/add", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(body)
        });

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        else{
            console.log("Hello")
            let cart = await response.json();
            console.log(cart);
        }

        let text = await response.text();
        console.log(text)

    } catch (error) {
        console.error('Fetch error:', error);
    }
}

