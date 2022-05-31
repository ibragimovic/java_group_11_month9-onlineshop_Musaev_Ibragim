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
                <form action="/feedback" method="post">

                    <#if _csrf??>
                        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
                    </#if>

                    <div class="form-group">
                        <input type="hidden" class="form-control" aria-describedby="emailHelp" name="email" value="${email}">
                    </div>
                    <div class="form-group">
                        <label for="inputFeedback">Your feedback</label>
                        <input type="text" class="form-control" id="inputFeedback" name="feedback" placeholder="please, enter your feedback">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>

                </form>
            </div>

        <#else>
            <div class="jumbotron" xmlns="http://www.w3.org/1999/html">
                <h1>Contact not found!</h1>
            </div>
        </#if>
    </div>

</@main.renderWith>