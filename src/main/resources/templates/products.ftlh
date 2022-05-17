<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["/main.js"]>

<#--    <form action="/register" method="post">-->

<#--        <#if _csrf??>-->
<#--            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>-->
<#--        </#if>-->

<#--        <div class="form-group">-->
<#--            <label for="exampleInputName1">Name</label>-->
<#--            <input type="text" class="form-control" id="exampleInputName1" placeholder="Enter your name" name="name">-->
<#--        </div>-->
<#--        <div class="form-group">-->
<#--            <label for="exampleInputEmail1">Email address</label>-->
<#--            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">-->
<#--            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>-->
<#--        </div>-->
<#--        <div class="form-group">-->
<#--            <label for="exampleInputPassword1">Password</label>-->
<#--            <input type="password" class="form-control" id="exampleInputPassword1" name="password">-->
<#--        </div>-->
<#--        <button type="submit" class="btn btn-primary">Submit</button>-->
<#--        <div>-->
<#--            <#if errors?? >-->
<#--                <div class="alert alert-warning" role="alert">-->
<#--                    <p><b>Input data with errors!</b></p>-->
<#--                    <#list errors as fieldError>-->
<#--                        <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>-->
<#--                    </#list>-->
<#--                </div>-->
<#--            </#if>-->
<#--        </div>-->
<#--    </form>-->



    <img src="/product_images/"${item.image}>
    <img src="..." class="rounded float-right" alt="...">


    <div style="display: inline-block;"><img id='lImage' style="width: 250px; height: 250px;" src="/images/${images.lImageFile}" /></div>
    <div style="display: inline-block;"><img id='rImage' style="width: 250px; height: 250px;" src="/images/${images.rImageFile}" /></div>
    <div>
        <button id="l" onclick="sendResult('lImage', '${images.lImageFile}')"><-</button>
        <button id="r" onclick="sendResult('rImage', '${images.rImageFile}')">-></button>
    </div>


</@main.renderWith>