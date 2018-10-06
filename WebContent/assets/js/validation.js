function validation() {
	let isbn = document.getElementById("isbn");
	let form = document.getElementById("form");

	if (isbn.value == "") {
		alert("Datos no validos");
	} else {
		alert("Datos validos");
		// form.submit();
	}
}