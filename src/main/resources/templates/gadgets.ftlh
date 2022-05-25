<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["/js/main.js"]>

    <div class="content flex flex-wrap" id="itemList">
        <#list item as listItem>
            <figure class="figure">
                <img src="/images/${listItem.image}" alt="${listItem.name}">
                <figcaption class="figure-caption"><h4>${listItem.name}</h4></figcaption>
                <figcaption class="figure-caption"><h4>${listItem.price} USD</h4></figcaption>
                <figcaption class="figure-caption"><h5>${listItem.description}</h5></figcaption>
                <hr>
                <form action="/cart/add" method="post" id="cart-form">
                    <#if _csrf??>
                        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                    </#if>
                    <div>
                        <input type="hidden" name="type" id="type" value="${listItem.gadgetType}">
                        <input type="hidden" name="name" id="name" value="${listItem.name}">
                        <button type="submit" class="btn btn-danger" >Add to cart</button>
                    </div>
                </form>
            </figure>
        </#list>
    </div>
    <#include "partials/pagination.ftlh">

</@main.renderWith>