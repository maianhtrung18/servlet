$(document).ready(function () {


	$('.btn_xoa').click(function () {
		var id = $(this).attr("id-role")
		var row = $(this).closest('tr')
		$.ajax({
			method: "POST",
			url: "http://localhost:8080/crm/api/roles",
			data: { id }
		})
			.done(function (data) {
				if(data.isSuccess){
					row.remove()
				}else{
					alert("Xoa that bai" + data)
				}			
			});
	})
})