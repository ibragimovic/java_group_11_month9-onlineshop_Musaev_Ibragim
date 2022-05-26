<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["/main.js"]>
    <div>

        <#if contact??>
            <div class="jumbotron" xmlns="http://www.w3.org/1999/html">
                <p><b><i>Your address: </i></b>${contact.address}</p>
                <hr class="my-4">
                <p><b><i>Your phone: </i></b>${contact.phone}</p>
                <hr class="my-4">
                <p><b><i>Your price: </i></b>${contact.price} USD</p>
                <hr class="my-4">
                <h1 class="display-4">Your order has been successfully placed, please wait!</h1>
                <a class="btn btn-primary btn-lg" href="/" role="button">Main page</a>
            </div>

        <#else>
            <div class="jumbotron" xmlns="http://www.w3.org/1999/html">
                <h1>Contact not found!</h1>
            </div>
        </#if>
    </div>

</@main.renderWith>