<%-- 
    Document   : home
    Created on : Mar 16, 2018, 12:46:48 PM
    Author     : Md. Rezve Hasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Login</title>

        <!-- Bootstrap core CSS -->
        <link href="resourses/css/bootstrap.css" rel="stylesheet">  
        <!-- Custom styles for this template -->
        <link href="resourses/css/login.css" rel="stylesheet">
        
    </head>

    <body class="text-center">


        <div class="wrapper">
            <div class="login">
                <div class="banner-wrapper">
                    <div class="banner__img"> </div>
                </div>

                <div class="form-wrapper">
                    <div class="form__heading">
                        <h2>Wellcome to FTS</h2>
                        <p>Education is a commitment to excellence in Teaching and Learning.</p>
                    </div>

                    <form class="form__main" action="login" method="post">
                        <div class="form-group">
                            <label class="form-lable" for="username">Username</label>
                            <input class="form-input" type="text" name="username" id="username">
                            <span class="form-message"></span>
                        </div>

                        <div class="form-group">
                            <label class="form-lable" for="password">Password</label>
                            <input class="form-input" type="password" name="password" id="password" autocomplete="off">
                            <span class="form-message"></span>
                        </div>

                        <button class="form-submit" type="submit">Login</button>
                    </form>
                    <div class="form__footer">
                        <div class="line">
                            <span>Or sign in with</span>
                        </div>

                        <div class="login-method">
                            <a href="#" class="link">
                                <div class="social-media">
                                    <img src="resourses/image/login/google-symbol.png" alt="" srcset="">
                                </div>
                            </a>
                            <a href="#" class="link">
                                <div class="social-media">
                                    <img src="resourses/image/login/facebook.png" alt="" srcset="">
                                </div>
                            </a>
                            <a href="#" class="link">
                                <div class="social-media github">
                                    <img src="resourses/image/login/github-character.png" alt="" srcset="">
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="resourses/js/jquery-slim.min.js"><\/script>')</script>
        <script src="./resourses/js/bootstrap.min.js"></script>
        <script src="./resourses/js/popper.min.js"></script>
    </body>
</html>
