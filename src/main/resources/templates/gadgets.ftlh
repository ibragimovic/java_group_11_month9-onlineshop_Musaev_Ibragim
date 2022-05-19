<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["/main.js"]>

    <div class="flex flex-wrap" id="itemList">
        <#list item as listItem>
            <figure class="figure">
                <img src="/images/${listItem.image}" alt="${listItem.name}">
                <figcaption class="figure-caption"><h4>${listItem.name}</h4></figcaption>
                <hr>
            </figure>
        </#list>
    </div>



</@main.renderWith>