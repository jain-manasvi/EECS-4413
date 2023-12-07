function submitForm(){
    let response =  submitReview()
    // window.location.href = "../index.html";
    return false; // Prevent default form submission
}

async function submitReview() {
    try {
        const urlParams = new URLSearchParams(window.location.search);
        const productId = urlParams.get('id');
        console.log(productId);

        const selectedOption = document.getElementById("rate").value;
        const body = document.getElementById("review").value;
        console.log(selectedOption, body);

        const response = await fetch(`/api/reviews/write`, {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                rating: selectedOption,
                body: body,
                productId: productId
            })
        });

        // Returned information
        const data = await response.json();
        if(response.ok){
            alert("Review submitted")
        }
        else{
            alert("Review unsuccessful")
        }
        console.log('Review submitted:', data);
    } catch (error) {
        console.error('Error submitting review:', error);
    }
}