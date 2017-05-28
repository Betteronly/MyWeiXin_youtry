window.onload = function onload() {
  // $(document).ready(function() {
  $("div[id^='myButtons'] .btn").click(function() {
    $(this).button('loading').delay(1000).queue(function() {
    });
  });

  $("img[id^='img']").click(function() {
    $(this).toggleClass('min');
    $(this).toggleClass('max');
  });

  $("#tableSchools tr").click(function() {
    console.log($(this).text());

    var tr = $(this);
    var inputs = tr.find("input");

    // var aaa = $("input[id^='gradeId']");
    // var a1 = tr.find(aaa);
    // var b1 = tr.find("input[id^='gradeClassId']");
    // console.log(a1.val());
    // console.log(b1.val());

    inputs.each(function() {
      var input = $(this);
      console.log(input.val());

      if (input.attr("name") == "gradeId") {
        console.log($("#selectedGradeId").val());
        $("#selectedGradeId").val(input.val());
        $(this).parents("#schoolForm").find("#selectedGradeId").val(input.val());
        console.log($("#selectedGradeId").val());
      }

      if (input.attr("name") == "gradeClassId") {
        $("#selectedGradeClassId").val(input.val());
        $(this).parents("#schoolForm").find("#selectedGradeClassId").val(input.val());
      }
      // var a = $("input[id^='gradeId']").val();
      // var b = $("input[id^='gradeClassId']").val();
    });

    // $("#schoolForm").submit();
    $(this).parents("#schoolForm").submit();

    // document.getElementById("oddNum").value = this.id; //
    // 每行设置不同的id值，该行是获取当前行的唯一值
    // $(this).addClass("backcolor").siblings("tr").removeClass("backcolor");
    // // 这行是进行背景色的切换，backcolor
    // 是提前定义好的外部css样式，这里进行添加与删除同类的，即实现了选中改行，其他行颜色去掉。
    // backcolor
    // 中的属性
    // 要加上
    // !important
    // ，提高其优先级
    // $(this).siblings("tr").find("td").removeClass("backcolor_font");
    // //
    // 下边两行是修改该tr中的字体颜色，该行的作用是删除样式
    // $(this).find("td").addClass("backcolor_font"); //
    // 该行是添加样式，因为想要实现的效果是点击某行，字体颜色切换，只有一行的字体颜色改变
    // });
    // }
  });
}

// $("img[id^='img']").dblclick(function(){
// $(this).toggleClass('min');
// $(this).toggleClass('max');
// });

// $(function() {
// $('#collapseOne').collapse('hide')
// });

// $(function() {
// $('#collapseTwo').collapse('show')
// });

// $(function() {
// $('#collapseThree').collapse('toggle')
// });

// $(function() {
// $('#collapseFour').collapse({
// toggle : false
// })
// });

