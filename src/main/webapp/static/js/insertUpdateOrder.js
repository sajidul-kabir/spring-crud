document.getElementById('saveOrderButton').addEventListener('click', function() {

        let method = null;
        var formData = {
//            id: document.getElementById('id').value,
            customer_name: document.getElementById('customer_name').value,
            product: document.getElementById('product').value,
            transaction: document.getElementById('transaction').value,
            address: document.getElementById('address').value
        };
        if (formData.id == null || formData.id === "") {
            method = "POST";
        } else {
            method = "PATCH";
        }

        console.log(formData, method);
        fetch(contextPath + '/orders', {
                method: method,
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            })
            .then(response => {
                window.location.href = contextPath + '/orders';
            })
            .catch(error => {

                console.error('There was a problem with the fetch operation:', error);
            });
 });