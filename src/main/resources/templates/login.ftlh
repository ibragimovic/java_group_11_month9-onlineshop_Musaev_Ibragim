<#import "partials/main.ftlh" as main />

<@main.renderWith>

    <h2>Please sign in</h2>

    <form action="/login" method="post">


        <#if error!false >
            <p style="color:red"><b>Invalid username or password!</b></p>
        </#if>


        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username" placeholder="your email address" autofocus>
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="enter your password" autofocus>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>

    </form>
    <hr class="my-4">-->
    <div class="bottom-box">
        <a href="/">Main page</a>
    </div>
</@main.renderWith>
