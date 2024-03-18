document.addEventListener('DOMContentLoaded', function() {
        const deleteButtons = document.querySelectorAll('.delete-button');

        deleteButtons.forEach(button => {
            button.addEventListener('click', function() {
                const productId = button.dataset.productId;

                if (confirm("Are you sure you want to delete this product?")) {
                    // Send a fetch request to delete the product
                    fetch(contextPath+'/products?id=' + productId, {
                        method: 'DELETE'
                    })
                    .then(response => {
                        // Redirect to the products page after successful deletion
                        window.location.href = contextPath+'/products';
                    })
                    .catch(error => {
                        // Handle error response
                        console.error('There was a problem with the fetch operation:', error);
                    });
                }
            });
        });
    });