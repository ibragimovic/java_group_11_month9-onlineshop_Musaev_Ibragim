<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["/main.js"]>
<#--    <div class="container">-->
<#--        <h1>Ваша корзина</h1>-->
<#--        <#if cartItems??>-->
<#--            <#list cartItems as item>-->
<#--                <p>${item}</p>-->
<#--            </#list>-->
<#--            <form action="/cart/empty" method="post">-->
<#--                <button>Очистить корзину</button>-->
<#--            </form>-->
<#--        <#else>-->
<#--            <p>тут ничего нет!</p>-->
<#--        </#if>-->
<#--        <div>-->
<#--            <a href="/">назад</a>-->
<#--        </div>-->
<#--    </div>-->

    <div class="content flex flex-wrap" id="itemList">
        <#if item??>
            <#list item as listItem>
                <figcaption class="figure-caption"><h4>${listItem.name}</h4></figcaption>
                <figcaption class="figure-caption"><h4>${listItem.price} USD</h4></figcaption>

<#--                <figure class="figure">-->
<#--                    <img src="/images/${listItem.image}" alt="${listItem.name}">-->
<#--                    <figcaption class="figure-caption"><h4>${listItem.name}</h4></figcaption>-->
<#--                    <figcaption class="figure-caption"><h4>${listItem.price} USD</h4></figcaption>-->
<#--                    <hr>-->
<#--                </figure>-->
            </#list>
            <form action="/cart/empty" method="post">
                <button>Clear the cart</button>
            </form>

            <#include "partials/pagination.ftlh">

        <#else>
            <p>Nothing in here!</p>
        </#if>
    </div>

</@main.renderWith>