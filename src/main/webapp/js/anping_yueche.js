/**
 * 客服电话 拨打记录
 */
function saveServiceTelCall() {
	var data = {
        "telFrom": "",
        "telTo": "15933855081"
	};

	$.ajax({
		type: "POST",
        url: "/yuecheApi/saveServiceTelCall",
        // url: "/yuecheApi/countOfServiceTelCall",
		dataType: "json",
		contentType: "application/json",
		data: JSON.stringify(data),
		success: function (data) {
		    alert(111);
		}
	});
};

/**
 * 获取 客服电话 拨打记录数
 */
// function getCountOfServiceTelCall() {
//     var data = {
//         "telFrom": "",
//         "telTo": "15933855081"
//     };
//
//     $.ajax({
//         type: "POST",
//         url: "/yuecheApi/countOfServiceTelCall",
//         dataType: "json",
//         contentType: "application/json",
//         data: JSON.stringify(data),
//         success: function (data) {
//             return data.count;
//         }
//     });
// };
