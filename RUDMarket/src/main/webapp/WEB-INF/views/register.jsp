<html>
<head>
    <title>Please register</title>
</head>
<body>
<div>
<form action="/register/doRegister" method="post">
    <fieldset>
        <legend>Effettuare la Registrazione</legend>
        <table>
            <tr>
                <td>Email:</td><td><input type="text" id="email" name="email"/></td>
            </tr>
            <tr>
                <td>Nome:</td><td><input type="text" id="nome" name="nome"/></td>
            </tr>
            <tr>
                <td>Cognome:</td><td><input type="text" id="cognome" name="cognome"/></td>
            </tr>
            <tr>
                <td>Password:</td><td><input type="password" id="password" name="password"/></td>
            </tr>
            <tr>
                <td></td><td><button type="submit" class="btn">Register</button></td>
            </tr>
        </table>
    </fieldset>
</form>
<p><a href="/">Home</a></p>
</div>
</body>
</html>

