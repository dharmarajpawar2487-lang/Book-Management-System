function confirmDelete(bookId) {
    return confirm("Are you sure you want to delete the book with ID: " + bookId + "?");
}

function validateForm() {
    let title = document.querySelector("[name='title']").value.trim();
    let author = document.querySelector("[name='author']").value.trim();
    let price = document.querySelector("[name='price']").value.trim();

    if (title === "" || author === "" || price === "") {
        alert("All fields are required!");
        return false;
    }
    if (isNaN(price) || parseFloat(price) <= 0) {
        alert("Price must be a positive number!");
        return false;
    }
    return true;
}
