<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["/main.js"]>
    <#if dto??>
        <div class="jumbotron" xmlns="http://www.w3.org/1999/html">
            <h1 class="display-4">Successful registration!</h1>
            <hr class="my-4">
            <p><b><i>Name: </i></b>${(dto.fullName)!'-- missing --'}</p>
            <p><b><i>Email: </i></b>${(dto.email)!'-- email missing --'}</p>
            <hr class="my-4">
            <a class="btn btn-primary btn-lg" href="/" role="button">Main page</a>
        </div>

    <#else>
        <div class="jumbotron" xmlns="http://www.w3.org/1999/html">
            <h1>User not found!</h1>
        </div>
    </#if>
    <div class="btn-secondary">
        <a href="/">Main page</a>
    </div>
</@main.renderWith>