<#-- импортируем основной шаблон-контейнер который содержит в себе разметку для основной структуры страницы -->
<#import "partials/main.ftlh" as main />

<#-- обрабатываем его, и передаём ему список скриптов, которые необходимо подключить-->
<@main.renderWith scripts=["/js/main.js"]>

<#--
здесь находится содержимое этой страницы
и оно будет подставлено вместо <#nested> элемента
в макро-функции
https://freemarker.apache.org/docs/dgui_misc_userdefdir.html
-->

    <a href="/register"> Зарегистрироваться! </a>
    <h1>Places</h1>
    <div class="flex flex-wrap" id="itemList">
        <#list items as listItem>
            <div class="flex flex-column box flex-v-center">
                <a href="/places/${listItem.id}">
                    <div class="flex flex-column flex-v-center box-128">
                        <img class="food-icon" src="${listItem.imagePath}" alt="${listItem.name}">
                        ${listItem.name}
                    </div>
                </a>
            </div>
        </#list>
    </div>

<#--
здесь мы подставляем содержимое другого "частичного" шаблона
который отвечает за отображение элементов для постраничного просмотра данных
https://freemarker.apache.org/docs/ref_directive_include.html
 -->
    <#include "partials/pagination.ftlh">

</@main.renderWith>
