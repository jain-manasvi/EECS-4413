function openTab(tabName) {
    var i;
    var x = document.getElementsByClassName("tab");
    for (i = 0; i < x.length; i++) {
      x[i].style.display = "none";  
    }
    document.getElementById(tabName).style.display = "block"; 

  }
  document.addEventListener("DOMContentLoaded", function() {
  var sortFilterForm = document.getElementById('sortFilterForm');
  
  if (sortFilterForm) {
      sortFilterForm.addEventListener('submit', function(event) {
          event.preventDefault(); // Prevent the form from submitting in the traditional way
          
          var sortValue = document.getElementById('sort').value;
          var filterBrandValue = document.getElementById('filterBrand').value;

          // Construct the query parameters
          var queryParams = '?sort=' + sortValue;
          if (filterBrandValue) {
              queryParams += '&brand=' + filterBrandValue;
          }

          // Make the AJAX call to the backend
          fetch('/api/products' + queryParams)
          .then(response => response.json())
          .then(data => {
              // Handle the response data
              console.log(data);
              // Update the product listing on the page
              // This would typically involve iterating over the data and appending each product to the DOM
          })
          .catch(error => console.error('Error:', error));
      });
  }
});