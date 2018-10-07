function validation() {
	let isbn = document.getElementById("isbn");
	let form = document.getElementById("form");

	if (isbn.value == "") {
		alert("No valid data");
	} else {
		alert("Valid data");
		form.submit();
	}
}