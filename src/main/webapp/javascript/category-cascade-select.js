var CategoryCascadeSelect = function(){

}

CategoryCascadeSelect.prototype.init = function(){
    $("#rootCategory .eh_input_wr span").click(function(e){
        $("#rootCategory .eh_form_dropMenu").toggle();
        e.stopPropagation();
    })

    $(document).click(function() {
        $("#rootCategory .eh_form_dropMenu").hide();
    });

    $("#rootCategory .eh_form_dropMenu li").click(function(){
        var code = $(this).attr("code");
        var label = $(this).attr("label");
        $("#rootCategory .eh_input_wr span").text(label);
        if($("#secondCategory .eh_form_dropMenu[parent='"+code+"']").length==0){
            $("#goods_category").val(code);
        }else{
            $("#goods_category").val("");
        }
        $(this).parent().hide();

        $("#secondCategory .eh_input_wr span").empty();
        $("#secondCategory").hide();
        $("#secondCategory .eh_form_dropMenu").removeClass("active");
        $("#secondCategory .eh_form_dropMenu[parent='"+code+"']").addClass("active");
        $("#secondCategory .eh_form_dropMenu[parent='"+code+"']").parent().css("display","inline-block");
    });

    $("#secondCategory .eh_input_wr span").click(function(e){
        $("#secondCategory .eh_form_dropMenu.active").toggle();
        e.stopPropagation();
    })

    $(document).click(function() {
        $("#secondCategory .eh_form_dropMenu").hide();
    });

    $("#secondCategory .eh_form_dropMenu li").click(function(){
        var code = $(this).attr("code");
        var label = $(this).attr("label");
        $("#secondCategory .eh_input_wr span").text(label);
        $("#goods_category").val(code);
        $(this).parent().hide();
    });

}