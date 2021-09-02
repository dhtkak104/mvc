var serverUrl = document.location.origin;

$(function() {
	
});

function selectBbsDetail(bbsNo){
	var url = '/bbs/'+bbsNo;
	$(location).attr('href',url);
}