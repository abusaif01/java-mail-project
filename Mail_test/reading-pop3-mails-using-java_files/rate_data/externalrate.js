function createXMLHttpRequest(){

    var ua;
    if(window.XMLHttpRequest) {

        try {
        ua = new XMLHttpRequest();

        }catch(e) {
        ua = false;
        }

    } else if(window.ActiveXObject) {

        try {

          ua = new ActiveXObject("Microsoft.XMLHTTP");

        } catch(e) {

        ua = false;

        }
    }
    return ua;
    }

var extxmlhttp = createXMLHttpRequest();
 
function sndexternalReq(vote,id_num,ip_num,units) {
	    var element = document.getElementById('unit_long'+id_num);
	
	    element.innerHTML = '<div class="loading"></div>';
	
	    var url = location.href.toString();
	
	    var chkurl = /blogadda.com/;
	    var result = url.search(chkurl);
	
    if(result > 0){
 extxmlhttp.open('get', '../../rpcext.php?j='+vote+'&q='+id_num+'&t='+ip_num+'&c='+units);
   }else{
    extxmlhttp.open('get', '/ib/rpcext.php?j='+vote+'&q='+id_num+'&t='+ip_num+'&c='+units);
    }
    extxmlhttp.onreadystatechange = handleResponse;
    extxmlhttp.send(null);	
}

function handleResponse() {
  if(extxmlhttp.readyState == 4){
		if (extxmlhttp.status == 200){
       	
        var response = extxmlhttp.responseText;
        var update = new Array();

        if(response.indexOf('|') != -1) {
            update = response.split('|');
 //document.getElementById("update[0]").innerHTML = update[1];
  changeText(update[0], update[1]);
        }
		}
    }
}

function changeText( div2show, text ) {
    // Detect Browser
    var IE = (document.all) ? 1 : 0;
    var DOM = 0; 
    if (parseInt(navigator.appVersion) >=5) {DOM=1};

    // Grab the content from the requested "div" and show it in the "container"
    if (DOM) {
        var viewer = document.getElementById(div2show);
        viewer.innerHTML = text;
    }  else if(IE) {
        document.all[div2show].innerHTML = text;
    }

}

/* =============================================================== */
var ratingAction = {
		'a.rater' : function(element){
			element.onclick = function(){
			//alert("this is url"+this.href);	
		
			var parameterString = this.href.replace(/.*db\W(.*)/, "$1");
			//	alert(parameterString);
			
			var parameterTokens = parameterString.split("/"); // onclick="sndReq('j=1,q=2,t=127.0.0.1,c=5');
			//alert(parameterTokens.length);			
			var theratingID = parameterTokens[1];
			var theVote = parameterTokens[0];
			var theuserIP = parameterTokens[2];
			var theunits = parameterTokens[3];
			//alert("this is url "+parameterString);
			//alert(theVote+','+theratingID+','+theuserIP+','+theunits); 

			//for testing
			sndexternalReq(theVote,theratingID,theuserIP,theunits); return false;		
			}
		}
		
	};
Behaviour.register(ratingAction);
