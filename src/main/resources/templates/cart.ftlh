<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["/main.js"]>
    <div class="container">
        <h1>Ваша корзина</h1>
        <#if cartItems??>
            <#list cartItems as item>
                <p>${item}</p>
            </#list>
            <form action="/cart/empty" method="post">
                <button>Очистить корзину</button>
            </form>
        <#else>
            <p>тут ничего нет!</p>
        </#if>
        <div>
            <a href="/">назад</a>
        </div>
    </div>

</@main.renderWith>