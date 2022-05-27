<#import "partials/main.ftlh" as main />

<@main.renderWith>

    <h3>Your new password: ${identity}</h3>
    <form action="/customer/restore-password/new-password" method="post">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" name="hash" placeholder="enter your password" autofocus>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</@main.renderWith>
