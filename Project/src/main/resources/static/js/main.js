function openTab(tabName) {
    var i;
    var x = document.getElementsByClassName("tab");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    document.getElementById(tabName).style.display = "block";
}
let value = 0;

// function sortForm() {
//     let filterValue = document.getElementById('brand').value; // Assuming 'brand' is your filter input field
//     let sortValue = document.getElementById('sort').value;
//     fetchFilteredProducts(filterValue, sortValue);
// }
//
// function fetchFilteredProducts(filter, sortValue) {
//     fetch(`/api/products/getFilteredProducts?brand=${filter}`)
//         .then(response => {
//             if (!response.ok) {
//                 throw new Error(`HTTP error! Status: ${response.status}`);
//             }
//             return response.json();
//         })
//         .then(data => {
//             console.log('Filtered Cars:', data);
//             applySort(data, sortValue);
//         })
//         .catch(error => {
//             console.error('Fetch error:', error);
//         });
// }
//
// function applySort(data, sortValue) {
//     if (sortValue === "price_asc") {
//         data.sort((car1, car2) => car1.price - car2.price);
//     } else if (sortValue === "price_desc") {
//         data.sort((car1, car2) => car2.price - car1.price);
//     } else if (sortValue === "mileage_asc") {
//         data.sort((car1, car2) => car1.mileage - car2.mileage);
//     } else if (sortValue === "mileage_desc") {
//         data.sort((car1, car2) => car2.mileage - car1.mileage);
//     }
//     displayCars(data); // Assuming this is your function to display the cars
// }

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
    // let brandName = document.querySelector("#brand").value;
    // fetch("/api/products/getFilteredProducts"), {
    //     method: "POST",
    //     headers: {
    //
    //     }
    // }
    fetch("/api/products/getFullPriceProducts").then(response => {
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

    fetch("/api/products/getDiscountedProducts").then(response => {
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json();
    })
        .then(data => {
            console.log('Cars:', data);
            data = data.sort((car1, car2) => car1.price - car2.price)
            displayHotDeals(data)

        })
        .catch(error => {
            console.error('Fetch error:', error);
        });
})

    function sortPriceAscending() {
        fetch("/api/products/getFullPriceProducts").then(response => {
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

        fetch("/api/products/getDiscountedProducts").then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
            .then(data => {
                console.log('Cars:', data);
                data = data.sort((car1, car2) => car1.price - car2.price)
                displayHotDeals(data)

            })
            .catch(error => {
                console.error('Fetch error:', error);
            });
    }

    function sortPriceDescending() {
        fetch("/api/products/getFullPriceProducts").then(response => {
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

        fetch("/api/products/getDiscountedProducts").then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
            .then(data => {
                console.log('Cars:', data);
                data = data.sort((car1, car2) => car2.price - car1.price)
                displayHotDeals(data)

            })
            .catch(error => {
                console.error('Fetch error:', error);
            });
    }

    function sortMileageAscending() {
        fetch("/api/products/getFullPriceProducts").then(response => {
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

        fetch("/api/products/getDiscountedProducts").then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
            .then(data => {
                console.log('Cars:', data);
                data = data.sort((car1, car2) => car1.mileage - car2.mileage)
                displayHotDeals(data)

            })
            .catch(error => {
                console.error('Fetch error:', error);
            });
    }

    function sortMileageDescending() {
        fetch("/api/products/getFullPriceProducts").then(response => {
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

        fetch("/api/products/getDiscountedProducts").then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
            .then(data => {
                console.log('Cars:', data);
                data = data.sort((car1, car2) => car2.mileage - car1.mileage)
                displayHotDeals(data)

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
        <button onclick="addToCart('${car.id}', '${car.name}', 1)">Add to Cart</button>
<button onclick="goToReviews()">Write Reviews</button>`;
            carListContainer.appendChild(dataElement);
        })
    }

function goToReviews(){
    window.location.href = "../html/reviews.html"
}

async function addToCart(id, name, quantity) {
    let body = {id: id, name: name, quantity: quantity };
    console.log(body);
    // try{
    //     let response = await fetch("")
    // }
    // catch{
    //
    // }
    try{
        let response = await fetch("/cart/add", {
            method: "PUT",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(body)
        })
        let json = await response.json();
        console.log(json)

    }
    catch{
        console.log("Fetch error in put method")
    }

}

function displayHotDeals(data) {
    const hotDealsCarsContainer = document.getElementById("product-list-hot");
    hotDealsCarsContainer.innerHTML = '';
    data.forEach(car => {
        console.log(car); // To check the whole object
        console.log('Model:', car.model); // To check the value of model specifically
        const dataElement = document.createElement('div');
        dataElement.innerHTML = `<strong>${car.name}</strong> (${car.year}): $${car.price} mileage: ${car.mileage} Discount: ${car.discount}
        <button onclick="addToCart('${car.id}', '${car.name}', 1)">Add to Cart</button>
<button onclick="goToReviews()">Write Reviews</button>`;
        hotDealsCarsContainer.appendChild(dataElement);
    })
}

// async function changeQuantity(productId, change) {
//     try {
//         const response = await fetch("/cart/update", {
//             method: "PUT",
//             headers: {
//                 'Content-Type': 'application/json',
//             },
//             body: JSON.stringify({ productId, change })
//         });
//
//         const data = await response.json();
//         if (data.cart) {
//             updateCartDisplay(data.cart);
//         } else {
//             await shoppingCart();
//         }
//     } catch (error) {
//         console.error('Error:', error);
//     }
// }

// function increaseQuantity(productId) {
//     changeQuantity(productId, 1); // Increase by 1
// }
//
// function decreaseQuantity(productId) {
//     changeQuantity(productId, -1); // Decrease by 1
// }

