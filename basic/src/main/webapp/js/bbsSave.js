var serverUrl = document.location.origin;
var fileList = null;

$(function() {
	
	$("#saveForm").submit(function(e){	 
		e.preventDefault();
		debugger;
		
		var formData = new FormData($(this)[0]);
		formData.append("fileList", fileList);
		var bbsNo = formData.get('bbsNo');
		
		$.ajax({
			url: '/bbs/'+bbsNo,
			type: 'POST',
			data: formData,
			async: false,
			cache: false,
			contentType: false,
			enctype: 'multipart/form-data',
			processData: false,
			success: function (data, txtStatus, xhr) {
				var code = xhr.status;
				if(200 <= code && code < 300) {
					$(location).attr('href', '/bbs');
				}	
			}
		});
		return false;
	});
	
	$('#fileViewBtn').click(function (e) {
		e.preventDefault();
		$("#fileBtn").click();
	});
	
	$("#fileBtn").change(function(e){
		debugger;
		if(fileList != null) {
			$("#newFile").empty();
		}
		
		fileList = e.target.files;
		for(var i=0 ; i<fileList.length ; i++){
			var file = fileList[i];
			var el = $("<p>" + file.name + "<span onClick='deleteFile(this,\""+i+"\")'> x</span></p>");
			el.appendTo($("#savedFile"));
		}
	});
	
});

function deleteSavedFile(e, fileNo){
	var p = e.closest("p");
	p.remove();
	
	var deleteFileNoList = $("#deleteFileNoList");
	var value = deleteFileNoList.val();
	if(value){
		deleteFileNoList.val(value + "," + fileNo);
	} else {
		deleteFileNoList.val(fileNo);
	}
	
}

function deleteFile(e, idx){
	var p = e.closest("p");
	p.remove();

	debugger;
	var tempList = new Array();
	for(var i=0 ; i<fileList.length ; i++){
		if(i != idx){
			tempList.push(fileList[i]);
		}
	}
	fileList = tempList;
}