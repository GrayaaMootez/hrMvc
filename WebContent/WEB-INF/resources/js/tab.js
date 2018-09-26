function post(path, params, method) {
	method = method || "post";

	var form = document.createElement("form");
	form.setAttribute("method", method);
	form.setAttribute("action", path);

	for ( var key in params) {
		if (params.hasOwnProperty(key)) {
			var hiddenField = document.createElement("input");
			hiddenField.setAttribute("type", "hidden");
			hiddenField.setAttribute("name", key);
			hiddenField.setAttribute("value", params[key]);

			form.appendChild(hiddenField);
		}
	}

	document.body.appendChild(form);
	form.submit();
}

$(document).ready(function() {
	$('#tab').DataTable();
});

$(document).ready(function() {
	$('#tab1').DataTable();
});

$('.tab1').dataTable({
	bAutoWidth : false,
	aoColumns : [ {
		sWidth : '10%'
	}, {
		sWidth : '30%'
	}, {
		sWidth : '30%'
	}, {
		sWidth : '20%'
	}, {
		sWidth : '10%'
	}, {
		sWidth : '10%'
	}, {
		sWidth : '10%'
	}, {
		sWidth : '15%'
	}, {
		sWidth : '15%'
	}, {
		sWidth : '15%'
	} ]
});
