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
            // Handle the data returned from the server
            console.log('Cars:', data);
            data = data.sort((car1, car2) => car1.price - car2.price)
            displayCars(data)
        })
        .catch(error => {
            console.error('Fetch error:', error);
            // Handle errors, e.g., display an error message to the user
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
                // Handle the data returned from the server
                console.log('Cars:', data);
                data = data.sort((car1, car2) => car1.price - car2.price)
                displayCars(data)
                // You can process the data here, such as updating the UI
            })
            .catch(error => {
                console.error('Fetch error:', error);
                // Handle errors, e.g., display an error message to the user
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
                // Handle the data returned from the server
                console.log('Cars:', data);
                data = data.sort((car1, car2) => car2.price - car1.price)
                displayCars(data)
                // You can process the data here, such as updating the UI
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
                // Handle the data returned from the server
                console.log('Cars:', data);
                data = data.sort((car1, car2) => car1.mileage - car2.mileage)
                displayCars(data)
                // You can process the data here, such as updating the UI
            })
            .catch(error => {
                console.error('Fetch error:', error);
                // Handle errors, e.g., display an error message to the user
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
                // Handle the data returned from the server
                console.log('Cars:', data);
                data = data.sort((car1, car2) => car2.mileage - car1.mileage)
                displayCars(data)

            })
            .catch(error => {
                console.error('Fetch error:', error);
                // Handle errors, e.g., display an error message to the user
            });
    }

    function displayCars(data) {
        const carListContainer = document.getElementById("product-list");
        carListContainer.innerHTML = '';
        data.forEach(car => {
            console.log(car); // To check the whole object
            console.log('Model:', car.model); // To check the value of model specifically
            const dataElement = document.createElement('div');
            dataElement.innerHTML = `<strong>${car.name}</strong> (${car.year}): $${car.price} mileage: ${car.mileage}`;
            carListContainer.appendChild(dataElement);
        })
    }

