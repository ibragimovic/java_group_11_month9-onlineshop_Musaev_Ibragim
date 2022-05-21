<#import "partials/main.ftlh" as main />

<@main.renderWith scripts=["/main.js"]>

  <br>
  <div class="title product"><h3>Choose our products</h3></div>

    <div class="content flex flex-wrap" id="itemList">
        <figure class="figure">
            <a href="/laptops"><img src="/images/AppleIMAC.jpg" class="figure-img img-fluid rounded" alt="Laptops"></a>
            <figcaption class="figure-caption"><a href="/laptops">Laptops</a></figcaption>
        </figure>
        <figure class="figure">
            <a href="/tablets"><img src="/images/SamsungGalaxyTAB.jpg" class="figure-img img-fluid rounded" alt="Tablets"></a>
            <figcaption class="figure-caption"><a href="/tablets">Tablets</a></figcaption>
        </figure>
        <figure class="figure">
            <a href="/phones"><img src="/images/iphone_13_ProMAX.jpg" class="figure-img img-fluid rounded" alt="Phones"></a>
            <figcaption class="figure-caption"><a href="/phones">Phones</a></figcaption>
        </figure>
    </div>
</@main.renderWith>