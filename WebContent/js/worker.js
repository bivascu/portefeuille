/**
 * Main object to manipulate the results from the rest services
 * This is a module pattern 
 */

var portefeuille = function(){
		
	function doStuff(x){
		alert(x);
	}
	
	return {
		displayAlert: function () { alert("hello");}		 
	}	
}();