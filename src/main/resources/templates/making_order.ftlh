<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["/main.js"]>
    <div>

        <#if totalPrice??>
            <div class="jumbotron" xmlns="http://www.w3.org/1999/html">
                <h1 class="display-4">Total price: ${totalPrice} USD</h1>
                <hr class="my-4">
                <form action="/cart/order-success" method="post">
                    <#if _csrf??>
                        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                    </#if>

                    <h2>Enter your contact details</h2>
                    <div class="form-group">
                        <input type="hidden" name="price" value="${totalPrice}">
                        <label for="formGroupExampleInput">Enter your address</label>
                        <input type="text" class="form-control" id="formGroupExampleInput" placeholder="your address" name="address">
                    </div>
                    <div class="form-group">
                        <label for="formGroupExampleInput2">Enter your phone number</label>
                        <input type="number" class="form-control" id="formGroupExampleInput2" placeholder="your phone number" name="phone">
                    </div>
                    <button type="submit" class="btn btn-danger">Confirm</button>
                </form>
                <hr class="my-4">
                <a class="btn btn-primary btn-lg" href="/" role="button">Main page</a>
            </div>

        <#else>
            <div class="jumbotron" xmlns="http://www.w3.org/1999/html">
                <h1>Cart not found!</h1>
            </div>
        </#if>
    </div>

</@main.renderWith>