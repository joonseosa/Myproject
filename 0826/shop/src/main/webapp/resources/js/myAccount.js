function numberWithCommas(x) {
	document.write(x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));
}
