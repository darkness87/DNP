/**
 *  [리소스 관리 ]
 * 
 *  사용법:
 *  	- javascript : AMI_RES.get(id);
 *  		ex) var recvlist = AMI_RES.get("ami_product_name");
 *  
 *  	- html:  $$([id])
 *  		ex) <li id="xxx11232"> $$([ami_product_name]) </li>
 */
var AMI_RES = {
	get : function (id) {
		return RES_STRING[id.replace(".", "_")];
	},
	
	replaceResource : function (str) {		
		var resultArray = str.match(/\$\$\(\[[\w]+\]\)/g);
		
		if (resultArray != undefined && resultArray != null) {
			var value;
			for (var i = 0; i < resultArray.length; i++) {
				value = AMI_RES.get(resultArray[i].substring(4, (resultArray[i].length - 2)));
				if (value == undefined) {
					value = "null";
				}
				str = str.replace(resultArray[i], value);
			}
		}
		
		return str;
	}
};