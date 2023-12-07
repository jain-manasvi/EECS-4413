const urlParams = new URLSearchParams(window.location.search);
const productId = urlParams.get('id');
function openTab(tabName) {
    var i;
    var x = document.getElementsByClassName("tab");
    for (i = 0; i < x.length; i++) {
        x[i].style.display = "none";
    }
    document.getElementById(tabName).style.display = "block";
}

// Fetch product details from the server
async function fetchProductDetails(productId) {
    try {
        const response = await fetch(`/api/products/${productId}`);
        const product = await response.json();
        return product;
    } catch (error) {
        console.error('Error fetching product details:', error);
        throw error; // Re-throw the error to be handled elsewhere if needed
    }
}

// Function to display product details
async function displayProductDetails(productId) {
    try {
        const product = await fetchProductDetails(productId);

        // Display product details in the HTML
        const productDetailsContainer = document.getElementById('productDetails');
        productDetailsContainer.innerHTML = `
            <h3>${product.name}</h3>
            <p>Price: $${product.price}</p>
            <p>Year: ${product.year}</p>
            <p>Brand: ${product.brand}</p>
            <p>Mileage: ${product.mileage}</p>
            <p>Description: ${product.description}</p>
            ${product.discount !== 0? `<p>Discount: ${product.discount}%</p>` : ''}<br>
            <button type="button" onclick="addToCart('${product.id}', '${product.name}', 1)">Add to cart</button><br>
            <button type="button" onclick="redirectToReviewPage('${product.id}')">Write a Review</button>
            <!-- Add more details as needed -->
        `;
    } catch (error) {
        console.error('Error displaying product details:', error);
        // Handle the error as needed
    }
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
        alert("Please sign in")
    }

}

//Function to display the reviews associated with the product
async function getReviews(productId) {
    try {
        const response = await fetch(`/api/reviews/${productId}`);
        const reviews = await response.json();
        await displayReviews(reviews);
    } catch (error) {
        console.error('Error fetching reviews:', error);
        throw error; // Re-throw the error to be handled elsewhere if needed
    }
}

async function displayReviews(reviews) {
    try {
        const reviewContainer = document.getElementById("displayReviews");

        // Clear existing content
        reviewContainer.innerHTML = '';

        if (reviews.length === 0) {
            reviewContainer.innerHTML = '<p>No reviews available for this product.</p>';
            return;
        }

        reviews.forEach(review => {
            const reviewElement = document.createElement('div');
            reviewElement.innerHTML = `
                <p>Rating: ${review.rating}</p>
                <p>${review.body}</p>
                <hr>
            `;
            reviewContainer.appendChild(reviewElement);
        });
    } catch (error) {
        console.error('Error displaying reviews:', error);
    }
}


function redirectToReviewPage(productId){
    window.location.href=`../html/reviews.html?id=${productId}`
}

displayProductDetails(productId);
getReviews(productId);
