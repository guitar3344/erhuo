<html>
<head>
    <#include 'common_header.ftl'>
    <link rel="stylesheet" href="/style/awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/style/global.css">
    <link rel="stylesheet" href="/style/home.css">
    <link rel="stylesheet" href="/style/form.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!--引入CSS-->
    <link rel="stylesheet" type="text/css" href="/plugin/webuploader/webuploader.css">
    <!--引入JS-->
    <script type="text/javascript" src="/plugin/webuploader/webuploader.js"></script>
    <script src="/javascript/form/category-cascade-select.js"></script>
    <script src="/javascript/upload-picture.js"></script>
    <script>
        $.fn.serializeObject = function()
        {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function() {
                if (o[this.name] !== undefined) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };

        $(function(){
            var categoryCascadeSelect = new CategoryCascadeSelect();
            categoryCascadeSelect.init();

            uploadPicture();

            $("#releaseGoods").click(function(){
//                var param = {
//                    title:$("#goods_title").val(),
//                    description:$("#goods_desc").val()
//                }

                $.ajax({
                    type: "POST",
                    url:"/goods/",
                    dataType: 'json',
                    contentType: 'application/json;charset=utf-8',
                    data:JSON.stringify($('#goodsForm').serializeObject()),// 要提交的表单
//                    data:JSON.stringify(param),
                    success: function(res) {
                        if(res.status == 'success'){
                            alert("发布成功")
                        }
                    }
                });
            });
        })
    </script>
</head>
<body>
<#include 'nav.ftl'>
<div class="eh_wrapper eh_form">
    <div class="eh_form_title">
        <h2>发布商品</h2>
    </div>
    <form id="goodsForm">
        <div class="eh_form_item goods_title">
            <div class="eh_form_label"><label>标题</label></div>
            <div class="eh_form_value">
                <div class="eh_input_wr">
                    <input class="eh_text" id="goods_title" name="title">
                </div>
            </div>
        </div>
        <div class="eh_form_item goods_desc">
            <div class="eh_form_label"><label>简要描述</label></div>
            <div class="eh_form_value">
                <div class="eh_input_wr">
                    <textarea class="eh_text" id="goods_desc" name="description"></textarea>
                </div>
            </div>
        </div>
        <div class="eh_form_item goods_category">
            <div class="eh_form_label"><label>分类</label></div>
            <div class="eh_form_value m" id="rootCategory">
                <div class="eh_input_wr">
                    <span>请选择</span>
                </div>

                <ul class="eh_form_dropMenu">
                <#list rootCategories as category>
                    <li code="${category.code}" label="${category.name}"><a href="#">${category.name}</a></li>
                </#list>
                </ul>
            </div>
            <div class="eh_form_value m" id="secondCategory">
                <div class="eh_input_wr">
                    <span>请选择</span>
                </div>

                <#list childrenCategoryMap?keys as key>
                    <ul class="eh_form_dropMenu" parent="${key}">
                        <#assign categoryList = childrenCategoryMap[key]>
                        <#list categoryList as category>
                            <li code="${category.code}" label="${category.name}"><a href="#">${category.name}</a></li>
                        </#list>
                    </ul>
                </#list>

            </div>
            <input type="hidden" id="goods_category" name="categoryCode">
        </div>

        <div class="eh_form_item goods_price">
            <div class="eh_form_label"><label>价格</label></div>
            <div class="eh_form_value m">
                <div class="eh_input_wr">
                    <input class="eh_text" id="goods_price" name="price">
                </div>
            </div>
            <div class="eh_form_value m">
                <div class="eh_input_wr original_price">
                    <input class="eh_text" id="goods_originalPrice" name="originalPrice">
                </div>
            </div>
        </div>

        <div class="eh_form_item goods_canBargain">
            <div class="eh_form_label"><label>可议价</label></div>
            <div class="eh_form_value m">
                <div class="onoffswitch">
                    <input type="checkbox" class="onoffswitch-checkbox" id="goods_canBargain" name="canBargain" value="true" checked>
                    <label class="onoffswitch-label" for="goods_canBargain">
                        <span class="onoffswitch-inner"></span>
                        <span class="onoffswitch-switch"></span>
                    </label>
                </div>
            </div>
        </div>

        <div class="eh_form_item goods_tradePlace">
            <div class="eh_form_label"><label>交易地点</label></div>
            <div class="eh_form_value">
                <div class="eh_input_wr">
                    <input class="eh_text" id="goods_tradePlace" name="tradePlace">
                </div>
            </div>
        </div>

        <div class="eh_form_item goods_pic">
            <div class="eh_form_label"><label>二货图片</label></div>
            <div class="eh_form_value">
                <div id="picList" class="eh_pic_list"></div>
                <div class="eh_upload">
                    <div class="eh_upload_inner" id="filePicker">
                        <i class="icon-picture"></i>
                        <b>添加图片</b>
                    </div>
                </div>
                <#--<div class="eh_input_wr">-->
                    <#--<input class="eh_text" id="goods_tradePlace" name="tradePlace">-->
                <#--</div>-->
            </div>
            <input type="hidden" id="goods_pic" name="goodsPics">
        </div>

        <div class="eh_form_item">
            <div class="eh_form_button_group">
                <button type="button" id="releaseGoods">发布</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>