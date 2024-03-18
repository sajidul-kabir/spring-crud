document.getElementById('saveProductButton').addEventListener('click', function() {
    let method = null;
    var formData = {
        id: document.getElementById('id').value,
        name: document.getElementById('name').value,
        price: document.getElementById('price').value
    };

    if (formData.id == null || formData.id === "") {
        method = "POST";
    } else {
        method = "PATCH";
    }

    console.log(formData, method);
    fetch(contextPath + '/products', {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        .then(response => {
            window.location.href = contextPath + '/products';
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
});
