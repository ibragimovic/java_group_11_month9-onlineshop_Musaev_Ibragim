<#macro renderWith title="Welcome to Online Shop!" scripts=[] styles=[]>
    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <title>${title}</title>

        <link rel="stylesheet" href="/css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
              integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
              crossorigin="anonymous">
        <#list styles as styleSource>
            <link rel="stylesheet" href="${styleSource}">
        </#list>
        <script src="https://code.jquery.com/jquery-3.6.0.js"
                integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous">
        </script>

    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Aruuzone online shop</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/cart">Cart<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/profile">Profile<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                            Settings
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/register">Register</a>
                            <a class="dropdown-item" href="/login">Login</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/logout">Logout</a>
                        </div>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/customer/restore-password">Restore password<span class="sr-only">(current)</span></a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        <div class="wrapper">
            <div class="content">
                <div class="sidebar">
                    <div class="sidebar__fixed">
                        <nav class="menu">
                            <a href="/" class="menu__item menu_item_active">
                                <span>Home</span>
                            </a>
                            <a href="/laptops" class="menu__item">
                                <span>Laptops</span>
                            </a>
                            <a href="/tablets" class="menu__item">
                                <span>Tablets</span>
                            </a>
                            <a href="/phones" class="menu__item">
                                <span>Phones</span>
                            </a>
                        </nav>
                    </div>
                </div>
                <main class="main">
                    <section>
                        <div class="posts" id="myPosts">
                            <div class="container">
                                <#nested>
                            </div>
                            <a href="/feedback"><span></span>Feedback</a>
                        </div>
                    </section>
                </main>
            </div>
        </div>

        <#list scripts as scriptSource>
            <script src="${scriptSource}"></script>
        </#list>

    </body>
    </html>
</#macro>