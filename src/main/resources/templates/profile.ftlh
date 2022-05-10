<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["/main.js"]>
    <#if dto??>
        <h1>Успешная регистрация!</h1>
        <p>${(dto.name)!'-- missing --'} - ${(dto.email)!'-- email missing --'}</p>
    <#else>
        <h1>Пользователь не найден!</h1>
    </#if>
</@main.renderWith>