<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["/main.js"]>
    <div>
        <#if item??>
            <#list item as listItem>
            <table class="table table-striped table-dark">
                <thead>
                <tr>
                    <th scope="col">Type</th>
                    <th scope="col">Name</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${listItem.gadgetType}</td>
                    <td>${listItem.gadgetName}</td>
                    <td>
                        <form action="/cart/delete" method="post">
                            <#if _csrf??>
                                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                            </#if>
                            <div>
                                <input type="hidden" name="type" id="type" value="${listItem.gadgetType}">
                                <input type="hidden" name="name" id="name" value="${listItem.gadgetName}">
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </div>
                        </form>
                    </td>
                </tr>
                </tbody>
            </table>
            </#list>
            <div>
                <form action="/cart/empty" method="post">
                    <#if _csrf??>
                        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                    </#if>
                    <button type="submit" class="btn btn-danger">Clear the cart</button>
                </form>
            </div>
            <div>
                <form action="/cart/make-order" method="post">
                    <#if _csrf??>
                        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                    </#if>
                    <button type="submit" class="btn btn-success">Make an order</button>
                </form>
            </div>
            <#include "partials/pagination.ftlh">
        <#else>
            <p>Nothing in here!</p>
        </#if>
    </div>

</@main.renderWith>