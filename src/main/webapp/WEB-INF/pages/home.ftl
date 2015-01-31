<html>
<head>
<#include 'common_header.ftl'>
    <link rel="stylesheet" href="/style/global.css">
    <link rel="stylesheet" href="/style/home.css">
</head>
<body>
<#include 'nav.ftl'>
<div class="eh_category eh_wrapper">
    <div class="primary_category">
        <ul>
        <#list rootCategories as category>
            <#if category.id == activeId>
                <li class="cat_item active"><a href="/category/${category.id}">${category.name}</a></li>
            <#else>
                <li class="cat_item"><a href="/category/${category.id}">${category.name}</a></li>
            </#if>
        </#list>
        </ul>
    </div>
    <div class="secondary_category">
        <ul>
        <#list children as child>
            <#if child.id == activeSubId>
                <li class="cat_item active"><a href="/category/${activeId}/${child.id}">${child.name}</a></li>
            <#else>
                <li class="cat_item"><a href="/category/${activeId}/${child.id}">${child.name}</a></li>
            </#if>
        </#list>
        </ul>
    </div>
</div>
<div class="eh_content eh_wrapper">
    <ul class="goods_items">
        <#list cards as card>
            <li class="goods_item">
                <div class="goods_card">
                    <div class="card_left">
                        <a title="${card.title}" href="" target="_blank">
                            <img class="goods_image" width="200" height="200" alt="123" src="${card.picUrl}">
                        </a>
                        <span class="goods_price">￥${card.price}<#if card.canBargain>(可讲价)</#if></span>
                    </div>
                    <div class="card_right">
                        <div class="goods_title"><a href="">${card.title}</a></div>
                        <div class="goods_time">${card.releaseTime}</div>
                        <div class="goods_description">${card.description}</div>
                        <div class="goods_other">
                            <span class="goods_place">${card.tradePlace}</span>
                            <span class="goods_redHeart">喜欢 19</span>
                            <span class="goods_comment">评论 2</span>
                        </div>
                    </div>
                </div>
            </li>
        </#list>
    </ul>
</div>
</body>
</html>