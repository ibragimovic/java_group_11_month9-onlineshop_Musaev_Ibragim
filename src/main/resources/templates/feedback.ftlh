<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["/js/main.js"]>

    <#if item??>
        <div class="content flex flex-wrap" id="itemList">
            <#list item as listItem>
                <figure class="figure">
                    <figcaption class="figure-caption"><h4>${listItem.email} : ${listItem.feedback}</h4></figcaption>
                    <hr>
                </figure>
            </#list>
        </div>
        <#include "partials/pagination.ftlh">
    <#else>
        <div>
            There is no feedback yet!
        </div>
    </#if>>

</@main.renderWith>