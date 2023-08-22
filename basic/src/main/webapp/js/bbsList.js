var serverUrl = document.location.origin;

$(function() {
	
});

function selectBbsDetail(bbsNo){
	//var url = '/bbs/'+bbsNo;
	var url = '/bbs-view?bbsNo='+bbsNo;
	$(location).attr('href',url);
}