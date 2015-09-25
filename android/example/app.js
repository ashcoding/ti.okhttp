var win = Ti.UI.createWindow({
	backgroundColor : 'white'
});

var okhttp = require('ti.okhttp');

var url = "http://httpbin.org/patch?address=12345";

var client = okhttp.createOkhttpclient({
	// function called when the response data is available
	onload : function(e) {
		Ti.API.info("Received text: " + this.responseText);
		alert('success');

	},

	// function called when an error occurs, including a timeout
	onerror : function(e) {
		Ti.API.debug(e.error);
		alert('error');

	},

	timeout : 5000 // in milliseconds

});

// Prepare the connection.
client.open("PATCH", url);

// Send the request.
var body = {
	"deliver_address" : 67,
	"invoice_address" : 89
};

client.send(body);

win.open();

